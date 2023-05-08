package online.pupu.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import online.pupu.api.model.Channel;
import online.pupu.api.model.Guild;

@Data
@AllArgsConstructor
public class GuildCreateResponse {
    private Guild guild;
    private Channel channel;
}
