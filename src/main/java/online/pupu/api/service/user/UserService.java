package online.pupu.api.service.user;


import online.pupu.api.model.User;

import java.util.Optional;

public interface UserService {
    String generateUserId();

    User save(User o);

    User findByPhone(String phone);

    User findById(String id);


}
