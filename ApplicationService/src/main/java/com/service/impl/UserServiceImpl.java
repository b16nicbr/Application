

import com.persistence.entity.User;
import com.persistence.repository.UserRepository;
import com.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

}
