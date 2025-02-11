package uz.divergenny.authservice.service;

import uz.divergenny.authservice.model.Role;

import java.util.List;

public interface JwtService {
    boolean validateToken(final String token);

    String generateToken(String userName, List<Role> roles);
}
