package com.example.demo.service;

import com.example.demo.data.entity.BooksSold;
import com.example.demo.data.repository.BooksRepository;
import com.example.demo.data.repository.BooksSoldRepository;
import com.example.demo.data.repository.UserRepository;
import com.example.demo.dto.BooksSoldDTO;
import com.example.demo.service.mapper.BooksSoldMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class BooksSoldService extends AbstractBusinessService<BooksSold, Integer, BooksSoldDTO,
        BooksSoldRepository, BooksSoldMapper> {
    private final UserRepository userRepository;
    private final BooksRepository booksRepository;

    @Autowired
    protected BooksSoldService(BooksSoldRepository repository, BooksSoldMapper serviceMapper,
                               UserRepository userRepository, BooksRepository booksRepository) {
        super(repository, serviceMapper);
        this.userRepository = userRepository;
        this.booksRepository = booksRepository;
    }

    //Metodo para guardar datos
    @Override
    public BooksSoldDTO save(BooksSoldDTO dto) {
        final BooksSold entity = getServiceMapper().toEntity(dto);
        entity.setUser(this.userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getUserId()))));
        entity.setBooks(this.booksRepository.findById(dto.getBooksId()).
                orElseThrow(() -> new RuntimeException(String.format("The user %s does not exist", dto.getBooksId()))));
        final BooksSold savedEntity = this.getRepository().save(entity);
        return getServiceMapper().toDto(savedEntity);
    }

    //Metodo para el listado principal
    public Page<BooksSoldDTO> findByUserId(Integer userId, Pageable pageable) {
        return getRepository().findByUserId(userId, pageable).map(getServiceMapper()::toDto);
    }

    //El administrador verá todos los libros vendidos
    public Page<BooksSoldDTO> findAll( Pageable pageable) {
        return getRepository().findAll( pageable).map(getServiceMapper()::toDto);
    }
}
