package uz.divergenny.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.divergenny.authservice.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
