package Application.controllers;

import Application.controllers.models.User;
import Application.controllers.models.UserRequest;
import com.application.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/it-systems")
public class UserController {


    @Autowired
    UserServiceImpl userService;


    @GetMapping(path = "/management/users/{id}")
    public ResponseEntity<User> userInManagement(@PathVariable int id){
        com.application.entity.User user = userService.findById(id);
        if (user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new User(user.getId(), user.getName(), user.getAge(), user.getAccesslevel()));
    }
    @PostMapping(path = "/management/users/create-user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){

        com.application.entity.User user = userService.insert(new com.application.entity.User(userRequest.id(), userRequest.name(),userRequest.age(),userRequest.accesslevel()));
        return ResponseEntity.ok(new User(user.getId(),user.getName(),user.getAge(), user.getAccesslevel()));
    }
}
