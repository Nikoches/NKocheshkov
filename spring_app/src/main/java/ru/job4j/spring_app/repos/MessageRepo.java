package ru.job4j.spring_app.repos;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.spring_app.Domain.Message;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {
    List<Message> findByTag(String tag);
}
