package com.example.demo.service.mapper;

import com.example.demo.data.entity.Task;
import com.example.demo.dto.TaskDTO;
import com.example.demo.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceMapper extends AbstractServiceMapper<Task, TaskDTO> {

    public Task toEntity(TaskDTO dto) {
        final Task entity = new Task();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setEndingDate(DateUtil.stringToDate(dto.getEndingDate()));
        entity.setStartingDate(DateUtil.stringToDate(dto.getStartingDate()));
        return entity;
    }

    public TaskDTO toDto(Task entity) {
        final TaskDTO dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setEndingDate(DateUtil.dateToString(entity.getEndingDate()));
        dto.setStartingDate(DateUtil.dateToString(entity.getStartingDate()));
        dto.setUserId(entity.getUser().getId());
        return dto;
    }

}
