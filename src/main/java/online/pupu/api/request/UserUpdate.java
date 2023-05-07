package online.pupu.api.request;

import lombok.Data;

@Data
public class UserUpdate {
    private String name; // 名称
    private String avatar; // 头像
    private String intro; // 个人介绍
}
