package DreamCoder.Changjin_Practice.repository;

import DreamCoder.Changjin_Practice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryUserRepository implements UserRepository{
    private static Map<Integer, User> userList = new HashMap<>();
    private static Integer sequence = 0;

    @Override
    public User save(User user) {
        user.setUserId(++sequence);
        userList.put(user.getUserId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Integer userId) {
        return Optional.ofNullable(userList.get(userId));
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userList.values().stream()
                .filter(user -> user.getUserName().equals(userName))
                .findAny();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userList.values().stream()
                .filter(user->user.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<User> findALL() {
        return new ArrayList<>(userList.values());
    }

    @Override
    public void updateById(Integer userId, User user) {
        Optional<User> findUser = findById(userId);
        if (findUser.isPresent()){
            user.setUserId(findUser.get().getUserId());
            deleteById(user.getUserId());
            save(user);
        }
    }

    @Override
    public void updateByName(String userName, User user) {
        Optional<User> findUser = findByUserName(userName);
        if (findUser.isPresent()){
            user.setUserId(findUser.get().getUserId());
            deleteById(user.getUserId());
            save(user);
        }
    }

    @Override
    public void updateByEmail(String email, User user) {
        Optional<User> findUser = findByEmail(email);
        if (findUser.isPresent()){
            user.setUserId(findUser.get().getUserId());
            deleteById(user.getUserId());
            save(user);
        }
    }

    @Override
    public void deleteById(Integer userId) {
        userList.remove(userId);
    }

    @Override
    public void deleteByName(String userName) {
        Optional<User> findUser = findByUserName(userName);
        if (findUser.isPresent()){
            deleteById(findUser.get().getUserId());
        }
    }

    @Override
    public void deleteByEmail(String Email) {
        Optional<User> findUser = findByEmail(Email);
        if (findUser.isPresent()){
            deleteById(findUser.get().getUserId());
        }
    }

    @Override
    public void clearUserList(){
        userList.clear();
    }
}
