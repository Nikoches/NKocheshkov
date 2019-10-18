package ru.job4j.spring_app.repos;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.spring_app.Domain.Message;

public interface MessageRepo extends CrudRepository<Message,Long> {
}
