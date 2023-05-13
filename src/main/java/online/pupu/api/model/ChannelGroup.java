package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 频道组
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("channelGroup")
public class ChannelGroup {

    @Id
    private String id; // ID
    private String guildId; // 行会id

    // 可修改
    private String name; // 名称
}
