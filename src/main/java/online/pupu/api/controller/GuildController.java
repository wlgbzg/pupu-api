package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.config.MessageUtils;
import online.pupu.api.model.*;
import online.pupu.api.request.GuildCreate;
import online.pupu.api.request.GuildUsers;
import online.pupu.api.response.GuildCreateResponse;
import online.pupu.api.response.UserGuildDTO;
import online.pupu.api.service.channel.ChannelService;
import online.pupu.api.service.channel.ChannelType;
import online.pupu.api.service.guild.GuildService;
import online.pupu.api.service.user.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import utils.BeanUtilsV2;
import utils.Result;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 行会
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/guild")
public class GuildController {

    private final GuildService guildService;
    private final UserService userService;
    private final ChannelService channelService;

    /**
     * 创建一个行会
     */
    @PostMapping("/create")
    Result create(@RequestHeader String id, @RequestBody GuildCreate r) {
        String guildId = guildService.generateId();
        String channelId = channelService.generateId();

        // 保存: 行会信息
        Guild guild = new Guild();
        guild.setId(guildId);
        BeanUtilsV2.copyPropertiesIgnoreNull(r, guild);
        guild.setCreateTime(System.currentTimeMillis());
        guild.setOwnerId(id);
        guild.setDefaultChannelId(channelId);
        guild = guildService.saveGuild(guild);

        // 保存: 行会角色分组
        GuildRole guildRole = new GuildRole();
        guildRole.setGuildId(guildId);
        guildRole.setRole(0);
        guildRole.setPermissions(0L);
        guildRole.setName("everyone");
        guildRole.setSystem(true);
        guildService.saveGuildRoleDao(guildRole);

        // 保存: 用户-行会关系
        UserGuild userGuild = new UserGuild();
        userGuild.setCreateTime(System.currentTimeMillis());
        userGuild.setUserId(id);
        userGuild.setGuildId(guildId);
        userGuild.setRole(0);
        guildService.saveUserGuild(userGuild);

        // 保存: 行会系统频道
        Channel channel = new Channel();
        channel.setId(channelId);
        channel.setCreateTime(System.currentTimeMillis());
        channel.setGuildId(guildId);
        channel.setName(MessageUtils.message("default.channel.name"));
        channel.setReadonly(false);
        channel.setType(ChannelType.TEXT.getValue());
        channel.setIsPrivate(false);
        channel = channelService.saveChannel(channel);
        return Result.success(new GuildCreateResponse(guild, channel));
    }

    /**
     * 获取行会成员分页列表
     */
    @PostMapping("/users/{guildId}")
    Result guildUsers(@PathVariable("guildId") String guildId, @RequestBody GuildUsers r) {
        Page<UserGuild> userGuildByGuildId = guildService.findUserGuildByGuildId(guildId, PageRequest.of(r.getPageNum(), r.getPageSize(),
                Sort.by(Sort.Order.desc("role"), Sort.Order.desc("activeTime"))));
        List<String> idList = userGuildByGuildId.stream().map(UserGuild::getUserId).toList();
        Map<String, User> userMap = userService.findByIdIn(idList).stream().collect(Collectors.toMap(User::getId, user -> user));
        Map<String, UserGuild> userGuildMap = userGuildByGuildId.stream().collect(Collectors.toMap(UserGuild::getUserId, userGuild -> userGuild));
        List<UserGuildDTO> list = idList.stream().map(id -> new UserGuildDTO(userGuildMap.get(id), userMap.get(id))).toList();
        return Result.success(list);
    }
}
