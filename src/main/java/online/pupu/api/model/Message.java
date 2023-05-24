package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("message")
public class Message {

    @Id
    private String id; // 消息id, 由服务器生成
    private String from; // 消息的发送方
    private String channelId; // 消息频道
    private Integer type; // 消息类型
    private Object body; // 消息内容
    private Long time; // 消息时间, 毫秒

    private User user; // 不入数据库, 只用来查询出来以后，补充发消息用户的数据
}
