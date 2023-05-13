package online.pupu.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import online.pupu.api.model.Guild;
import online.pupu.api.model.User;
import online.pupu.api.model.UserGuild;

@Data
@AllArgsConstructor
public class UserGuildDTO {
    private UserGuild userGuild;
    // 用户信息
    private User user;
    // 行会信息
    private Guild guild;
}
