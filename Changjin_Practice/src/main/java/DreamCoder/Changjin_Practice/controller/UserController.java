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
        try{
            userService.join(user);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(userService.findOne(user.getUserId()));
    }
    @GetMapping("/users/find")
    public ResponseEntity read(@RequestParam("userId") Integer userId){
        User findUser;
        try{
            findUser = userService.findOne(userId);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(findUser);
    }
    @GetMapping("/users/update")
    public ResponseEntity update(@RequestParam("userId") Integer userId, UserRequestDto userRequestDto){
        User findUser;
        User updateUser = new User();
        updateUser.setUserName(userRequestDto.getUserName());
        updateUser.setEmail(userRequestDto.getEmail());
        updateUser.setPassword(userRequestDto.getPassword());
        try{
            findUser = userService.findOne(userId);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(userService.updateOne(userId, updateUser));
    }
    @GetMapping("/users/delete")
    public ResponseEntity delete(@RequestParam("userId") Integer userId, UserRequestDto userRequestDto){
        User findUser;
        try{
            findUser = userService.findOne(userId);
        }
        catch(IllegalStateException e){
            return ResponseEntity.ok().body(e.getMessage());
        }
        return ResponseEntity.ok().body(userService.deleteOne(userId));
    }
}
