package online.pupu.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 社区推荐
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("discoveryGuild")
public class DiscoveryGuild {

    @Id
    private String id; // ID
    private List<String> guildList; // 名称

}
