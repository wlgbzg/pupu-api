package online.pupu.api.service.guild;


import online.pupu.api.model.Guild;
import online.pupu.api.model.GuildRole;
import online.pupu.api.model.UserGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface GuildService {
    String generateId();

    Guild saveGuild(Guild o);

    void deleteGuild(String id);

    Guild findById(String id);

    Page<Guild> search(String key, Pageable pageable);

    List<Guild> findByIdIn(List<String> idList);

    UserGuild saveUserGuild(UserGuild o);

    Page<UserGuild> findUserGuildsByGuildId(String guildId, Pageable pageable);

    List<UserGuild> findUserGuildsByUserId(String userId);

    GuildRole saveGuildRoleDao(GuildRole o);

}
