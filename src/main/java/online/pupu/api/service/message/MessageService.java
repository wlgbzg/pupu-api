package online.pupu.api.service.message;


import online.pupu.api.model.Message;

import java.util.List;

public interface MessageService {
    String generateId();

    Message save(Message o);

    List<Message> findMessage(String channelId, Long time);
}
