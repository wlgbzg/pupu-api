package online.pupu.api.dao;

import online.pupu.api.model.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelDao extends MongoRepository<Channel, String> {

    List<Channel> findByGuildId(String guildId);
    List<Channel> findByChannelGroupId (String channelGroupId);
}
