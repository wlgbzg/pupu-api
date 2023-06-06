package online.pupu.api.dao;

import online.pupu.api.model.GuildRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuildRoleDao extends MongoRepository<GuildRole, String> {

    List<GuildRole> findByGuildId(String guildId);

}
