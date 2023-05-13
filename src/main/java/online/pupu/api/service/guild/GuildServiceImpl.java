package online.pupu.api.service.guild;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.GuildDao;
import online.pupu.api.dao.GuildRoleDao;
import online.pupu.api.dao.UserGuildDao;
import online.pupu.api.model.Guild;
import online.pupu.api.model.GuildRole;
import online.pupu.api.model.UserGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import utils.RandomStringUtilsV2;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuildServiceImpl implements GuildService {

    private final GuildDao guildDao;
    private final UserGuildDao userGuildDao;

    private final GuildRoleDao guildRoleDao;

    private final MongoTemplate mongoTemplate;

    @Override
    public String generateId() {
        String id;
        do {
            id = RandomStringUtilsV2.randomId();
        } while (guildDao.existsById(id));
        return id;
    }

    @Override
    public Guild saveGuild(Guild o) {
        return guildDao.save(o);
    }

    @Override
    public Guild findById(String id) {
        return guildDao.findById(id).orElse(null);
    }

    @Override
    public List<Guild> findByIdIn(List<String> idList) {
        return guildDao.findByIdIn(idList);
    }

    @Override
    public UserGuild saveUserGuild(UserGuild o) {
        return userGuildDao.save(o);
    }

    @Override
    public Page<UserGuild> findUserGuildsByGuildId(String guildId, Pageable pageable) {
        return userGuildDao.findByGuildId(guildId, pageable);
    }

    @Override
    public List<UserGuild> findUserGuildsByUserId(String userId) {
        return userGuildDao.findByUserId(userId);
    }

    @Override
    public GuildRole saveGuildRoleDao(GuildRole o) {
        return guildRoleDao.save(o);
    }


}
