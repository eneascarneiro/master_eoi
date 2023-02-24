package com.example.demo.service;

import com.example.demo.data.entity.Books;
import com.example.demo.data.repository.BooksRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.BooksDTO;
import com.example.demo.service.mapper.BooksMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BooksService extends AbstractBusinessService<Books, Integer, BooksDTO, BooksRepository, BooksMapper> {

    private final UserRepository userRepository;

    protected BooksService(BooksRepository repository, BooksMapper serviceMapper, UserRepository userRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
    }
    //Obtener el listado del los libros
    public Page<BooksDTO> findAll( Pageable pageable) {
        return getRepository().findAll(pageable).map(getServiceMapper()::toDto);
    }

    //Modificar un libro
    @Override
    public BooksDTO save(BooksDTO dto) {
        final Books entity = getServiceMapper().toEntity(dto);
        final Books savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }
}
