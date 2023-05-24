package online.pupu.api.service.discovery;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.DiscoveryGuildDao;
import online.pupu.api.dao.MessageDao;
import online.pupu.api.model.DiscoveryGuild;
import online.pupu.api.model.Message;
import online.pupu.api.service.message.MessageService;
import org.springframework.stereotype.Service;
import utils.RandomStringUtilsV2;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscoveryGuildServiceImpl implements DiscoveryGuildService {
    private final DiscoveryGuildDao discoveryGuildDao;

    @Override
    public DiscoveryGuild save(DiscoveryGuild o) {
        return discoveryGuildDao.save(o);
    }

    @Override
    public List<DiscoveryGuild> findAll() {
        return discoveryGuildDao.findAll();
    }


}
