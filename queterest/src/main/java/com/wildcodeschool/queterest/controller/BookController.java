package com.wildcodeschool.queterest.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.wildcodeschool.queterest.model.Book;
import com.wildcodeschool.queterest.repository.BookRepository;

@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book Book){
        return bookRepository.save(Book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        // getting Book
        Book BookToUpdate = bookRepository.findById(id).get();
        BookToUpdate.setTitle(book.getTitle());
        BookToUpdate.setDescription(book.getDescription());
        BookToUpdate.setAuthor(book.getAuthor());
        return bookRepository.save(BookToUpdate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Long id){
        bookRepository.deleteById(id);
        return true;
    }
}
    

