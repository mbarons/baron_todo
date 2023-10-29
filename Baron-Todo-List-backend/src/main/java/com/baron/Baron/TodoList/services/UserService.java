package com.baron.Baron.TodoList.services;


import com.baron.Baron.TodoList.exceptions.NotUniqueUsernameException;
import com.baron.Baron.TodoList.exceptions.ResourceNotFoundException;
import com.baron.Baron.TodoList.dto.user.CreateUserDto;
import com.baron.Baron.TodoList.dto.user.UserDto;
import com.baron.Baron.TodoList.mapper.DozerMapper;
import com.baron.Baron.TodoList.models.User;
import com.baron.Baron.TodoList.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public UserDto findById(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return DozerMapper.parseObject(user, UserDto.class);
    }

    public List<UserDto> findAll() {
        return DozerMapper.parseListObjects(repository.findAll(), UserDto.class);
    }

    public UserDto create(CreateUserDto createUserDto) {
        User user = DozerMapper.parseObject(createUserDto, User.class);
        user.setEnabled(true);
        try {
            repository.save(user);
        } catch (Exception ex) {
            throw new NotUniqueUsernameException("This username already exists.");
        }

        return DozerMapper.parseObject(user, UserDto.class);
    }

    public void delete(Long id) {
        User user = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        repository.delete(user);
    }

}
