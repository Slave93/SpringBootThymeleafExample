package rs.slavko.examples.thymeleaf.repository;

import org.springframework.data.repository.CrudRepository;

import rs.slavko.examples.thymeleaf.model.News;

public interface NewsRepository extends CrudRepository<News, Long> {
}
