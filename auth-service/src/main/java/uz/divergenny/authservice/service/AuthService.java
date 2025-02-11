package uz.divergenny.authservice.service;


import uz.divergenny.authservice.model.Role;
import uz.divergenny.authservice.model.User;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    void saveUser(User user);

    String generateToken(String username, List<Role> roles);

    boolean validateToken(String token);

    Optional<User> getUser(String username);
}
