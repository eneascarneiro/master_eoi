package com.example.demo.service;

import com.example.demo.data.entity.BooksRead;
import com.example.demo.data.repository.BooksReadRepository;
import com.example.demo.data.repository.BooksRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.BooksReadDTO;
import com.example.demo.service.mapper.BooksReadMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BooksReadService extends AbstractBusinessService<BooksRead, Integer, BooksReadDTO,
        BooksReadRepository, BooksReadMapper> {
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    @Autowired
    protected BooksReadService(BooksReadRepository repository, BooksReadMapper serviceMapper,
                               UserRepository userRepository, BooksRepository booksRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }

    //Metodo para guardar datos
    @Override
    public BooksReadDTO save(BooksReadDTO dto) {
        final BooksRead entity = getServiceMapper().toEntity(dto);
        entity.setUser(this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserId()))));
        entity.setBooks(this.booksRepository.findById(dto.getBooksId()).
                orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getBooksId()))));
        final BooksRead savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    //Metodo para el listado principal
    public Page<BooksReadDTO> findByUserId(Integer userId, Pageable pageable) {
        return getRepository().findByUserId(userId, pageable).map(getServiceMapper()::toDto);
    }

    //El administrador verá todos los libros vendidos
    public Page<BooksReadDTO> findAll( Pageable pageable) {
        return getRepository().findAll( pageable).map(getServiceMapper()::toDto);
    }
}
