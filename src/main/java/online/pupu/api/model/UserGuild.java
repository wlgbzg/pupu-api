package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 用户-行会-关系表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("userGuild")
public class UserGuild {

    @Id
    private String id; // ID
    private String userId; // 用户id
    private String guildId; // 行会id
    private Long createTime; // 创建时间
    private Long activeTime; // 最近在线时间

    // 可修改
    private Integer role; // 角色

}
