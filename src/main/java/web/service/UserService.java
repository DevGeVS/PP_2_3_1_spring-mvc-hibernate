package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    User findById(Long id);
    }


