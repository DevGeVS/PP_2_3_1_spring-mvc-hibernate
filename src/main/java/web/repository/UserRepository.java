package web.repository;


import web.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
    void delete(Long id);
    User findById(Long id);
}
