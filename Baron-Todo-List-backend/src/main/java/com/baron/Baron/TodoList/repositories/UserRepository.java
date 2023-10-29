package com.baron.Baron.TodoList.repositories;

import com.baron.Baron.TodoList.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
