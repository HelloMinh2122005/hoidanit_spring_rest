package org.example.springrest.repository;

import org.example.springrest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    User findUserByEmail(String email);
    User findUserByName(String name);
    User deleteUserById(Long id);
}
