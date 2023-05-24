package online.pupu.api.dao;

import online.pupu.api.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageDao extends MongoRepository<Message, String> {

    List<Message> findByChannelIdAndTimeBeforeOrderByTimeDesc(String channelId, Long time);

}
