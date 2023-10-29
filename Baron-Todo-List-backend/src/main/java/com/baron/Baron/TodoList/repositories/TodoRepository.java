package com.baron.Baron.TodoList.repositories;

import com.baron.Baron.TodoList.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByUsername(String username);
}
