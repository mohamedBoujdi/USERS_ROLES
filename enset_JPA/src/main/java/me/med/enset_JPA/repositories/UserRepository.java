package me.med.enset_JPA.repositories;

import me.med.enset_JPA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}