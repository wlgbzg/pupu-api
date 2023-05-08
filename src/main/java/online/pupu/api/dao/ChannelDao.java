package online.pupu.api.dao;

import online.pupu.api.model.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelDao extends MongoRepository<Channel, String> {

}
