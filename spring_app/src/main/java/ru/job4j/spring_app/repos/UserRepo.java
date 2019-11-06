package ru.job4j.spring_app.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.spring_app.Domain.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
