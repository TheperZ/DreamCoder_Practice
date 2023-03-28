package DreamCoder.Changjin_Practice.service;

import DreamCoder.Changjin_Practice.domain.User;
import DreamCoder.Changjin_Practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User join(User user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }
    public User findOne(Integer userId){
        if(userRepository.findById(userId).isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        return userRepository.findById(userId).get();
    }

    public User updateOne(Integer userId, User user){
        if(userRepository.findById(userId).isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userRepository.updateById(userId, user);
        return findOne(user.getUserId());
    }
    public String deleteOne(Integer userId){
        if(userRepository.findById(userId).isEmpty()){
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }
        userRepository.deleteById(userId);
        return "삭제 완료";
    }
    private void validateDuplicateUser(User user){
        if(userRepository.findByUserName(user.getUserName()).isPresent()
                || userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
