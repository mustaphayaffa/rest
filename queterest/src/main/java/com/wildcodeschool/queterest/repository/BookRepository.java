package com.wildcodeschool.queterest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wildcodeschool.queterest.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    
    public List<Book> findByTitleContainingOrDescriptionContaining(String text, String textAgain);
    
}
