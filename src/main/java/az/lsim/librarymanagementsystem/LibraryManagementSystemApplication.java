package az.lsim.librarymanagementsystem;

import az.lsim.librarymanagementsystem.model.Book;
import az.lsim.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@RequiredArgsConstructor
public class LibraryManagementSystemApplication implements CommandLineRunner {

    private final BookRepository bookRepository;
    private static Long id=10L;

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final int[] count = {0};
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (count[0] < 10) {
                Book entity = new Book();
                entity.setName("New Entity");
                entity.setAuthor("123");
                entity.setGenre("genre");
                bookRepository.save(entity);
                count[0]++;
            } else {
                executor.shutdown(); // stop the task after 10 iterations
            }
        }, 0, 5, TimeUnit.SECONDS);
    }
}



