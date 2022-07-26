package com.example.demo.service;

import com.example.demo.data.entity.BooksSold;
import com.example.demo.data.entity.UserEmpresa;
import com.example.demo.data.repository.*;
import com.example.demo.dto.BooksSoldDTO;
import com.example.demo.dto.UserEmpresaDTO;
import com.example.demo.service.mapper.BooksSoldMapper;
import com.example.demo.service.mapper.UserEmpresaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserEmnpresaService extends AbstractBusinessService<UserEmpresa, Integer, UserEmpresaDTO,
        UserEmpresaRepository, UserEmpresaMapper> {
    private final UserRepository userRepository;
    private final EmpresaRepository empresaRepository;

    @Autowired
    protected UserEmnpresaService(UserEmpresaRepository repository, UserEmpresaMapper serviceMapper,
                                  UserRepository userRepository, BooksRepository booksRepository, EmpresaRepository empresaRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.empresaRepository = empresaRepository;
    }

    //Metodo para guardar datos
    @Override
    public UserEmpresaDTO save(UserEmpresaDTO dto) {
        final UserEmpresa entity = getServiceMapper().toEntity(dto);
        entity.setUser(this.userRepository.findById(dto.getUserDTO().getId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserDTO().getId()))));
       //Y que hago con la emnpresa?¿Se ha creado en el controlador o la creo en el servicio?

        final UserEmpresa savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    //Metodo para el listado principal
    public Page<UserEmpresaDTO> findByUserId(Integer userId, Pageable pageable) {
        return getRepository().findByUserId(userId, pageable).map(getServiceMapper()::toDto);
    }

    //El administrador verá todos los libros vendidos
    public Page<UserEmpresaDTO> findAll( Pageable pageable) {
        return getRepository().findAll( pageable).map(getServiceMapper()::toDto);
    }
}
