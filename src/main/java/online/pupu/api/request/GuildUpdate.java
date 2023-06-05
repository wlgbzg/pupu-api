package online.pupu.api.request;

import lombok.Data;

@Data
public class GuildUpdate {
    private String id; // id
    private String name; // 名称
    private String intro; // 简介
    private String cover; // 行会封面图
}
