package com.example.demo.service;

import com.example.demo.data.entity.Task;
import com.example.demo.data.entity.User;
import com.example.demo.data.repository.TaskRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.TaskDTO;
import com.example.demo.service.mapper.TaskServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends AbstractBusinessService<Task, Integer, TaskDTO, TaskRepository, TaskServiceMapper> {

    private final UserRepository userRepository;

    @Autowired
    public TaskService(TaskRepository repository, TaskServiceMapper serviceMapper,
            UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }

    @Override
    public TaskDTO save(TaskDTO dto) {
        final Task entity = getServiceMapper().toEntity(dto);
        entity.setUser(this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserId()))));
        final Task savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    public Page<TaskDTO> findAll(Integer userId, Pageable pageable) {
        return getRepository().findByUserId(userId, pageable).map(getServiceMapper()::toDto);
    }
}
