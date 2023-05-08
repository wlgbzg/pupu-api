package online.pupu.api.service.user;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.UserDao;
import online.pupu.api.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public String generateUserId() {
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(8);
        } while (userDao.existsById(id));
        return id;
    }

    @Override
    public User save(User o) {
        return userDao.save(o);
    }

    @Override
    public List<User> findByIdIn(List<String> idList) {
        return userDao.findByIdIn(idList);
    }

    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id).orElse(null);
    }
}
