package com.example.demo.service;

import com.example.demo.data.entity.Books;
import com.example.demo.data.entity.Empresa;
import com.example.demo.data.repository.BooksRepository;
import com.example.demo.data.repository.EmpresaRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.BooksDTO;
import com.example.demo.dto.EmpresaDTO;
import com.example.demo.service.mapper.BooksMapper;
import com.example.demo.service.mapper.EmpresaMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService extends AbstractBusinessService<Empresa, Integer, EmpresaDTO, EmpresaRepository, EmpresaMapper> {

    private final UserRepository userRepository;

    protected EmpresaService(EmpresaRepository repository, EmpresaMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado del los libros
    public Page<EmpresaDTO> findAll( Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un libro
    @Override
    public EmpresaDTO save(EmpresaDTO dto) {
        final Empresa entity = getServiceMapper().toEntity(dto);
        final Empresa savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
