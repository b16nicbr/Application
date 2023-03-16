

import com.persistence.entity.User;
import com.service.service.UserSeriveImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}/name")
    public ResponseEntity<model.User> getUserName(@PathVariable String name){
        User user = userService.findByName(name);
        if(user == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new model.User(user.getName(), user.getID(), user.getAccesslevel()));
    }
}
