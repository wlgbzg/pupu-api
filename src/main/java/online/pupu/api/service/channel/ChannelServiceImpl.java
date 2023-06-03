package online.pupu.api.service.channel;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.ChannelDao;
import online.pupu.api.dao.ChannelGroupDao;
import online.pupu.api.model.Channel;
import online.pupu.api.model.ChannelGroup;
import org.springframework.stereotype.Service;
import utils.RandomStringUtilsV2;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelDao channelDao;
    private final ChannelGroupDao channelGroupDao;

    @Override
    public String generateId() {
        String id;
        do {
            id = RandomStringUtilsV2.randomId();
        } while (channelDao.existsById(id));
        return id;
    }

    @Override
    public Channel saveChannel(Channel o) {
        return channelDao.save(o);
    }

    @Override
    public Channel findById(String id) {
        return channelDao.findById(id).orElse(null);
    }

    @Override
    public void deleteChannel(String id) {
        channelDao.deleteById(id);
    }

    @Override
    public List<Channel> findChannelsByGuildId(String guildId) {
        return channelDao.findByGuildId(guildId);
    }

    @Override
    public String generateChannelGroupId() {
        String id;
        do {
            id = RandomStringUtilsV2.randomId();
        } while (channelGroupDao.existsById(id));
        return id;
    }

    @Override
    public ChannelGroup saveChannelGroup(ChannelGroup o) {
        return channelGroupDao.save(o);
    }

    @Override
    public List<ChannelGroup> findChannelGroupsByGuildId(String guildId) {
        return channelGroupDao.findByGuildId(guildId);
    }

    @Override
    public ChannelGroup findChannelGroupById(String id) {
        return channelGroupDao.findById(id).orElse(null);
    }

    @Override
    public void deleteChannelGroupById(String id) {
        channelGroupDao.deleteById(id);
    }

    @Override
    public List<Channel> findChannelsByChannelGroupById(String channelGroupById) {
        return channelDao.findByChannelGroupId(channelGroupById);
    }

}
