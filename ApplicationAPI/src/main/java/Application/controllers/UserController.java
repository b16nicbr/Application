package Application.controllers;

import Application.controllers.models.User;
import com.application.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/it-systems")
public class UserController {


    @Autowired
    UserServiceImpl userService;


    @GetMapping(path = "/management/users/{ID}")
    public ResponseEntity<User> userInManagement(@PathVariable int ID){
        com.application.entity.User user = userService.findById(ID);
        if (user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new User(user.getName(), user.getAge(), user.getAccesslevel()));
    }
}
