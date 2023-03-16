


import com.persistence.entity.User;

public interface UserService {


    User findByName(String name);

    void insert(User user);
}
