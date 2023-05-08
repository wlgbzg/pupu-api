package online.pupu.api.dao;

import online.pupu.api.model.GuildRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRoleDao extends MongoRepository<GuildRole, String> {

}
