package online.pupu.api.request;

import lombok.Data;

import java.util.List;

@Data
public class DiscoveryGuildCreate {

    private String id; // ID
    private List<String> guildList; // 社区id

}