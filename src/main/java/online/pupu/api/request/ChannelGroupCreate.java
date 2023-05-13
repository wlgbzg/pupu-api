package online.pupu.api.request;

import lombok.Data;

@Data
public class ChannelGroupCreate {
    private String name; // 名称
    private String guildId; // 行会id
}
