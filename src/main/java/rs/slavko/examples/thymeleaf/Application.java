package rs.slavko.examples.thymeleaf;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import rs.slavko.examples.thymeleaf.model.News;
import rs.slavko.examples.thymeleaf.repository.NewsRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private NewsRepository newsRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        for (int i = 0; i < 10; i++) {
            newsRepository.save(new News("This is a news number #" + (i+1), new Date(),"Slavko Komarica"));
        }
    }
}
