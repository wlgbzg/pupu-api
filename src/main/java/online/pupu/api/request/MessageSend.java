package online.pupu.api.request;

import lombok.Data;

@Data
public class MessageSend {
    private String channelId; // 消息频道
    private Integer type; // 消息类型
    private Object body; // 消息内容
}
