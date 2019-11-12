package Spring_packages.Repos;

import Spring_packages.Domains.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepo extends CrudRepository<Message,Long> {

    List<Message> findByAuthor(String author);
}
