package online.pupu.api.dao;

import online.pupu.api.model.Guild;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildDao extends MongoRepository<Guild, String> {

}
