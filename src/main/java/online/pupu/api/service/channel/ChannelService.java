package online.pupu.api.service.channel;


import online.pupu.api.model.Channel;
import online.pupu.api.model.ChannelGroup;

import java.util.List;

public interface ChannelService {
    String generateId();

    Channel saveChannel(Channel o);

    Channel findById(String id);

    void deleteChannel(String id);

    List<Channel> findChannelsByGuildId(String guildId);

    String generateChannelGroupId();

    ChannelGroup saveChannelGroup(ChannelGroup o);

    List<ChannelGroup> findChannelGroupsByGuildId(String guildId);

    ChannelGroup findChannelGroupById(String id);

    void deleteChannelGroupById(String id);

    List<Channel> findChannelsByChannelGroupById(String channelGroupById);

}
