package online.pupu.api.service.message;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.MessageDao;
import online.pupu.api.model.Message;
import org.springframework.stereotype.Service;
import utils.RandomStringUtilsV2;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageDao messageDao;

    @Override
    public String generateId() {
        String id;
        do {
            id = RandomStringUtilsV2.randomMessageId();
        } while (messageDao.existsById(id));
        return id;
    }

    @Override
    public Message save(Message o) {
        return messageDao.save(o);
    }

    @Override
    public List<Message> findMessage(String channelId, Long time) {
        return messageDao.findByChannelIdAndTimeBeforeOrderByTimeDesc(channelId, time);
    }
}
