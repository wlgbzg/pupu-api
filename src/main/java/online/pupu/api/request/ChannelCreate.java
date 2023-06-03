package online.pupu.api.request;

import lombok.Data;

@Data
public class ChannelCreate {
    private String name; // 名称
    private Integer type; // 频道类型
    private String guildId; // 行会id
    private Boolean isPrivate; // 是否隐私频道
    private String channelGroupId; // 频道组id

}
