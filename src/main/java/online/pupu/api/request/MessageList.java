package online.pupu.api.request;

import lombok.Data;

@Data
public class MessageList {
    private String channelId; // 消息频道
    private Long time; // 消息时间, 毫秒
}
