package online.pupu.api.service.channel;


import online.pupu.api.model.Channel;

public interface ChannelService {
    String generateId();

    Channel saveChannel(Channel o);

    Channel findById(String id);


}
