package online.pupu.api.service.user;


import online.pupu.api.model.User;

import java.util.List;

public interface UserService {
    String generateUserId();

    User save(User o);
    List<User> findByIdIn(List<String> idList);

    User findByPhone(String phone);

    User findById(String id);


}
