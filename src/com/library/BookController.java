package com.library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class BookController {
        private final bookDBA bookDBA = new bookDBA();
        @GetMapping("/api/books")
        public List<Book> getBooks() {
            return bookDBA.getAllBooks();
        }

}
