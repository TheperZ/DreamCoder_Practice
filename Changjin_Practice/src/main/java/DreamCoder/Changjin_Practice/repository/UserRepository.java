package DreamCoder.Changjin_Practice.repository;
import DreamCoder.Changjin_Practice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    //Create
    User save(User user);
    //Read
    Optional<User> findById(Integer userId);
    Optional<User> findByUserName(String userName);
    Optional<User> findByEmail(String email);
    List<User> findALL();
    //Update
    void updateById(Integer userId, User user);
    void updateByName(String userName, User user);
    void updateByEmail(String email, User user);
    //Delete
    void deleteById(Integer userId);
    void deleteByName(String userName);
    void deleteByEmail(String Email);

    void clearUserList();
}
