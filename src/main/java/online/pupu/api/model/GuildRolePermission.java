package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 行会-身份组可设置的所有开关权限，系统管理的数据表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("guildRolePermission")
public class GuildRolePermission {

    @Id
    private String id; // ID
    private String subject; // 标题
    private String description; // 描述
    private Integer position; // permission setting 位置
    private Integer order; // 列表排序

}
