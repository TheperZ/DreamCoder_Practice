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
        return userRepository.save(user);
    }
    public Optional<User> findOne(Integer userId){
        if (userRepository.findById(userId).isPresent())
            return Optional.ofNullable(userRepository.findById(userId).get());
        else
            return Optional.empty();
    }

    private void validDuplicateUser(User user){
        if(userRepository.findByUserName(user.getUserName()).isPresent()
                || userRepository.findByEmail(user.getEmail()).isPresent())
        {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }
}
