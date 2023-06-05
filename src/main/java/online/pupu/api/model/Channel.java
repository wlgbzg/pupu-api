package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 频道
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("channel")
public class Channel {

    @Id
    private String id; // ID
    private Long createTime; // 创建时间
    private String guildId; // 行会id
    private String intro; // 频道简介

    // 可修改
    private String name; // 名称
    private Boolean isPrivate; // 是否是隐私频道
    private Boolean readonly; // 是否是只读频道
    private Integer type; // 频道类型
    private String channelGroupId; // 频道组Id
}
