package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 私密频道允许访问的角色关联表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("channelGuildRole")
public class ChannelGuildRole {

    @Id
    private String id; // ID
    private String channelId; // 频道id
    private String guildRoleId; // 身份组id
}
