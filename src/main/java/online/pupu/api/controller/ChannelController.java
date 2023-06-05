package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.model.Channel;
import online.pupu.api.model.ChannelGroup;
import online.pupu.api.model.Guild;
import online.pupu.api.request.ChannelCreate;
import online.pupu.api.request.ChannelGroupCreate;
import online.pupu.api.request.ChannelGroupUpdate;
import online.pupu.api.request.ChannelSetGroup;
import online.pupu.api.service.channel.ChannelService;
import online.pupu.api.service.guild.GuildService;
import org.springframework.web.bind.annotation.*;
import utils.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 频道
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/channel")
public class ChannelController {

    private final ChannelService channelService;
    private final GuildService guildService;

    /**
     * 获取频道历史消息
     */
    @PostMapping("/{channelId}/messages")
    Result messages(@PathVariable("channelId") String channelId, Integer limit) {
        return Result.success();
    }

    /**
     * 修改频道类别
     */
    @PostMapping("/updateChannelGroup")
    Result updateChannelGroup(@RequestHeader String id, @RequestBody ChannelGroupUpdate r) {
        ChannelGroup channelGroup = channelService.findChannelGroupById(r.getId());
        channelGroup.setName(r.getName());
        channelGroup = channelService.saveChannelGroup(channelGroup);
        return Result.success(channelGroup);
    }


        /**
         * 创建一个频道
         */
    @PostMapping("/create")
    Result create(@RequestHeader String id, @RequestBody ChannelCreate r) {
        String channelId = channelService.generateId();

        Channel channel = new Channel();
        channel.setId(channelId);
        channel.setCreateTime(System.currentTimeMillis());
        channel.setGuildId(r.getGuildId());
        channel.setIsPrivate(r.getIsPrivate());
        channel.setName(r.getName());
        channel.setReadonly(false);
        channel.setType(r.getType());
        channel.setIsPrivate(false);
        channel.setChannelGroupId(r.getChannelGroupId());
        channel = channelService.saveChannel(channel);
        return Result.success(channel);
    }

    /**
     * 创建一个频道组
     */
    @PostMapping("/channelGroupCreate")
    Result channelGroupCreate(@RequestHeader String id, @RequestBody ChannelGroupCreate r) {
        String channelGroupId = channelService.generateChannelGroupId();
        ChannelGroup channelGroup = new ChannelGroup();
        channelGroup.setId(channelGroupId);
        channelGroup.setName(r.getName());
        channelGroup.setGuildId(r.getGuildId());
        channelGroup = channelService.saveChannelGroup(channelGroup);
        return Result.success(channelGroup);
    }

    /**
     * 设置频道的频道组
     */
    @PostMapping("/setChannelGroup")
    Result setChannelGroup(@RequestHeader String id, @RequestBody ChannelSetGroup r) {
        Channel channel = channelService.findById(r.getChannelId());
        channel.setChannelGroupId(r.getChannelGroupId());
        channel = channelService.saveChannel(channel);
        return Result.success(channel);
    }

    /**
     * 设置频道的频道组
     */
    @PostMapping("/deleteChannelGroup/{channelGroupId}")
    Result deleteChannelGroup(@RequestHeader String id, @PathVariable("channelGroupId") String channelGroupId ) {
        channelService.deleteChannelGroupById(channelGroupId);

        List<Channel> channels = channelService.findChannelsByChannelGroupById(channelGroupId);
        channels.forEach(channel -> {
            channel.setChannelGroupId("");
            channelService.saveChannel(channel);
        });
        return Result.success();
    }


    /**
     * 删除频道
     */
    @PostMapping("/delete/{channelId}")
    Result delete(@RequestHeader String id, @PathVariable("channelId") String channelId) {
        channelService.deleteChannel(channelId);
        return Result.success();
    }

    /**
     * 获取当前行会的频道列表（包含组信息）
     */
    @PostMapping("/list/{guildId}")
    Result list(@RequestHeader String id, @PathVariable("guildId") String guildId) {
        List<Channel> channels = channelService.findChannelsByGuildId(guildId);
        List<ChannelGroup> channelGroups = channelService.findChannelGroupsByGuildId(guildId);
        Guild guild = guildService.findById(guildId);
        return Result.success(Map.of("channels",channels, "channelGroups", channelGroups, "guild", guild));
    }

}
