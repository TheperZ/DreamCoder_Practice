package DreamCoder.Changjin_Practice.repository;

import DreamCoder.Changjin_Practice.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemoryUserRepositoryTest {
    UserRepository userRepository = new MemoryUserRepository();
    @AfterEach
    void afterEach(){
        userRepository.clearUserList();
    }
    @Test
    void findById() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        User finduser = userRepository.findById(user.getUserId()).get();
        //Then
        assertThat(finduser).isEqualTo(user);
    }

    @Test
    void findByUserName() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        User finduser = userRepository.findByUserName(user.getUserName()).get();
        //Then
        assertThat(finduser).isEqualTo(user);
    }

    @Test
    void findByEmail() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        User finduser = userRepository.findByEmail(user.getEmail()).get();
        //Then
        assertThat(finduser).isEqualTo(user);
    }

    @Test
    void findALL() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        User user1 = new User();
        user1.setUserName("이창진1");
        user1.setPassword("12341");
        user1.setEmail("changjin@gmail.com1");
        //When
        userRepository.save(user);
        userRepository.save(user1);
        //Then
        assertThat(2).isEqualTo(userRepository.findALL().size());
    }

    @Test
    void updateById() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        User user1 = new User();
        user1.setUserName("이창진1");
        user1.setPassword("12341");
        user1.setEmail("changjin@gmail.com1");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.updateById(findId, user1);
        //Then
        assertThat(user1).isEqualTo(userRepository.findById(findId).get());
    }

    @Test
    void updateByName() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        User user1 = new User();
        user1.setUserName("이창진");
        user1.setPassword("12341");
        user1.setEmail("changjin@gmail.com1");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.updateByName(user.getUserName(), user1);
        //Then
        assertThat(user1).isEqualTo(userRepository.findById(findId).get());
    }

    @Test
    void updateByEmail() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        User user1 = new User();
        user1.setUserName("이창진");
        user1.setPassword("12341");
        user1.setEmail("changjin@gmail.com1");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.updateByEmail(user.getEmail(), user1);
        //Then
        assertThat(user1).isEqualTo(userRepository.findById(findId).get());
    }

    @Test
    void deleteById() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.deleteById(findId);
        //Then
        assertThat(Optional.empty()).isEqualTo(userRepository.findById(findId));
    }

    @Test
    void deleteByName() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.deleteByName(user.getUserName());
        //Then
        assertThat(Optional.empty()).isEqualTo(userRepository.findById(findId));
    }

    @Test
    void deleteByEmail() {
        // Given
        User user = new User();
        user.setUserName("이창진");
        user.setPassword("1234");
        user.setEmail("changjin@gmail.com");
        //When
        userRepository.save(user);
        Integer findId = user.getUserId();
        userRepository.deleteByEmail(user.getEmail());
        //Then
        assertThat(Optional.empty()).isEqualTo(userRepository.findById(findId));
    }
}