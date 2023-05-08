package online.pupu.api.service.guild;


import online.pupu.api.model.Guild;
import online.pupu.api.model.GuildRole;
import online.pupu.api.model.UserGuild;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface GuildService {
    String generateId();

    Guild saveGuild(Guild o);

    Guild findById(String id);

    UserGuild saveUserGuild(UserGuild o);

    Page<UserGuild> findUserGuildByGuildId(String guildId, Pageable pageable);

    GuildRole saveGuildRoleDao(GuildRole o);

}
