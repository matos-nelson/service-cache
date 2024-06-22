package com.cache.demo.service_cache.api.persistence.repository;

import com.cache.demo.service_cache.api.persistence.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
