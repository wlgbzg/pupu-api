package online.pupu.api.service.channel;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.ChannelDao;
import online.pupu.api.model.Channel;
import org.springframework.stereotype.Service;
import utils.RandomStringUtilsV2;

@Service
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelDao channelDao;

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

}
