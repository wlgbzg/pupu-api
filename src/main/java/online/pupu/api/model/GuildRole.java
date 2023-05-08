package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 行会-身份组
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("guildRole")
public class GuildRole {

    @Id
    private String id; // ID
    private String guildId; // 行会id
    private boolean system; // 是否是系统默认角色

    // 可修改
    private Integer color; // 文字组颜色
    private String name; // 角色名称
    private Integer role; // 角色
    private Long permissions; // 权限

}
