package online.pupu.api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online.pupu.api.model.DiscoveryGuild;
import online.pupu.api.model.Guild;
import online.pupu.api.service.discovery.DiscoveryGuildService;
import online.pupu.api.service.guild.GuildService;
import org.springframework.web.bind.annotation.*;
import utils.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 发现（精选行会）
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/discoveryGuild")
public class DiscoveryGuildController {

    private final GuildService guildService;
    private final DiscoveryGuildService discoveryGuildService;

    @PostMapping("/create")
    Result create(@RequestHeader String id, @RequestBody DiscoveryGuild r) {
        discoveryGuildService.save(r);
        return Result.success();
    }


    /**
     * 获取推荐行会列表
     */
    @PostMapping("/list")
    Result list(@RequestHeader String id) {
        List<DiscoveryGuild> discoveryGuildList = discoveryGuildService.findAll();
        List<String> idList = discoveryGuildList.stream()
                .flatMap(g -> g.getGuildList().stream())
                .toList();
        List<Guild> guildList = guildService.findByIdIn(idList);
        Map<String, Guild> guildMap = guildList.stream().collect(Collectors.toMap(Guild::getId, guild -> guild));
        Map<String, List<Guild>> result = new HashMap<>();
        discoveryGuildList.forEach(dg -> {
            List<Guild> l = new ArrayList<>();
            dg.getGuildList().forEach(gid -> {
                l.add(guildMap.get(gid));
            });
            result.put(dg.getId(), l);
        });
        return Result.success(result);
    }

}
