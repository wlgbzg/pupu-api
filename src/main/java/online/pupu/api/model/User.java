package online.pupu.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.PrePersist;
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
    private Long createTime; // 创建时间

    // 可修改
    private String name; // 名称
    private String avatar; // 头像
    private String intro; // 个人介绍

    // 不需要返回的数据
    @JsonIgnore
    private boolean profileComplete; // 是否完善过资料
    @JsonIgnore
    private String phone; // 手机号
    @JsonIgnore
    private String phonePrefix; // 手机号区号
    @JsonIgnore
    private String password; // 密码

    @PrePersist
    protected void onPersist() {
        profileComplete = false;
    }
}
