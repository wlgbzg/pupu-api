package online.pupu.api.dao;

import online.pupu.api.model.ChannelGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelGroupDao extends MongoRepository<ChannelGroup, String> {
    List<ChannelGroup> findByGuildId(String guildId);
}
