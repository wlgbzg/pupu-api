package online.pupu.api.request;

import lombok.Data;

@Data
public class GuildSearch {
    private Integer pageNum;
    private Integer pageSize;
    private String key;
}
