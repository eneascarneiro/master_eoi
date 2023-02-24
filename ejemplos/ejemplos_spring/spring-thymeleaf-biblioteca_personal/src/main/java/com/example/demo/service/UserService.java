package com.example.demo.service;

import com.example.demo.data.entity.User;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.service.mapper.UserServiceMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractBusinessService<User, Integer, UserDTO, UserRepository, UserServiceMapper> {


    protected UserService(UserRepository repository, UserServiceMapper serviceMapper) {
        super(repository, serviceMapper);
    }

    //Obtener el listado del los libros
    public Page<UserDTO> findAll( Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un libro
    @Override
    public UserDTO save(UserDTO dto) {
        final User entity = getServiceMapper().toEntity(dto);
        final User savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
