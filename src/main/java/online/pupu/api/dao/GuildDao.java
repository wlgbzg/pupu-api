package online.pupu.api.dao;

import online.pupu.api.model.Guild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GuildDao extends MongoRepository<Guild, String> {

    List<Guild> findByIdIn(List<String> idList);

    Page<Guild> findByNameLike(String name, Pageable pageable);
}
