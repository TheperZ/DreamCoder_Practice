package DreamCoder.Changjin_Practice.controller;

import DreamCoder.Changjin_Practice.domain.User;
import DreamCoder.Changjin_Practice.dto.UserRequestDto;
import DreamCoder.Changjin_Practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users/new")
    public ResponseEntity create(UserRequestDto userRequestDto){
        User user = new User();
        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        userService.join(user);

        return ResponseEntity.ok().body(userService.findOne(user.getUserId()).get());
    }
    @GetMapping("/users/find")
    public ResponseEntity read(@RequestParam("userId") Integer userId){
        Optional<User> findUser = userService.findOne(userId);
        if (findUser.isPresent())
            return ResponseEntity.ok().body(findUser);
        else
            return new ResponseEntity<>("찾을 수 없는 유저", HttpStatus.OK);
    }
}
