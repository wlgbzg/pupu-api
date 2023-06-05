package online.pupu.api.request;

import lombok.Data;

@Data
public class ChannelUpdate {
    private String id; // id
    private String name; // 名称
    private String intro; // 简介
}
