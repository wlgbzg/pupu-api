package online.pupu.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Document("user")
public class User {

    @Id
    private String id; // ID
    private String name; // 名称
    private String avatar; // 头像
    private Long createTime; // 创建时间
    private String intro; // 个人介绍

    // 安全信息不能通过用户资料泄露
    @JsonIgnore
    private Long mobile; // 手机号
    @JsonIgnore
    private String email; // 邮箱

}
