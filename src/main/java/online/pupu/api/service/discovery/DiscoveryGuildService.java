package online.pupu.api.service.discovery;

import online.pupu.api.model.DiscoveryGuild;

import java.util.List;


public interface DiscoveryGuildService {

    DiscoveryGuild save(DiscoveryGuild o);

    List<DiscoveryGuild> findAll();

}
