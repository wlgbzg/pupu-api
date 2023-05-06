package online.pupu.api.service.impl;

import lombok.RequiredArgsConstructor;
import online.pupu.api.dao.UserDao;
import online.pupu.api.model.User;
import online.pupu.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public User save(User o) {
        return userDao.save(o);
    }
}
