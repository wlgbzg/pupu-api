package online.pupu.api.dao;

import online.pupu.api.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, String> {
    User findByPhone(String phone);

    List<User> findByIdIn(List<String> idList);
}
