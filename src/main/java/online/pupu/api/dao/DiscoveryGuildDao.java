package online.pupu.api.dao;

import online.pupu.api.model.DiscoveryGuild;
import online.pupu.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscoveryGuildDao extends MongoRepository<DiscoveryGuild, String> {
}
