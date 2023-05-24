package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 行会
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("guild")
public class Guild {

    @Id
    private String id; // ID
    private Long createTime; // 创建时间
    private String ownerId; // 所有者id

    // 可修改
    private String name; // 名称
    private String avatar; // 头像
    private String intro; // 行会简介
    private String cover; // 行会封面图
    private String defaultChannelId; // 默认频道
    private Long memberCount;

}
