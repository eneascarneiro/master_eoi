package com.example.demo.service;

import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.entity.Mensajes;
import com.example.demo.data.repository.BooksReadRepository;
import com.example.demo.data.repository.BooksRepository;
import com.example.demo.data.repository.MensajesRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.BooksReadDTO;
import com.example.demo.dto.MensajesDTO;
import com.example.demo.service.mapper.BooksReadMapper;
import com.example.demo.service.mapper.MensajesServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MensajesService extends AbstractBusinessService<Mensajes, Integer, MensajesDTO,
        MensajesRepository, MensajesServiceMapper> {
    private final UserRepository userRepository;


    @Autowired
    protected MensajesService(MensajesRepository repository, MensajesServiceMapper serviceMapper,
                              UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }

    //Metodo para guardar datos
    @Override
    public MensajesDTO save(MensajesDTO dto) {
        final Mensajes entity = getServiceMapper().toEntity(dto);
        entity.setUser(this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserId()))));
        final Mensajes savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    @Override
    public MensajesDTO save(MensajesDTO dto, Integer usrid) {
        final Mensajes entity = getServiceMapper().toEntity(dto);
        dto.setUserId(usrid);
        entity.setUser(this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserId()))));
        final Mensajes savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    //Metodo para el listado principal
    public Page<MensajesDTO> findByUserId(Integer userId, Pageable pageable) {
        return getRepository().findByUserId(userId, pageable).map(getServiceMapper()::toDto);
    }
}
