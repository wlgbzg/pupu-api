package online.pupu.api.dao;

import online.pupu.api.model.UserGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserGuildDao extends MongoRepository<UserGuild, String> {

    Page<UserGuild> findByGuildId(String guildId, Pageable pageable);
}
