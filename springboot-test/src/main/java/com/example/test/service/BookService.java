package com.example.test.service;

import com.example.test.dto.response.GetBookListResponseDto;
import com.example.test.dto.response.GetBookResponseDto;
import com.example.test.dto.request.PostBookRequestDto;
import com.example.test.dto.response.PostBookResponseDto;
import com.example.test.entity.Book;
import com.example.test.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // 책 생성
    public PostBookResponseDto createBook(PostBookRequestDto requestDto) {
        Book book = new Book (
                null, requestDto.getBook_title(), requestDto.getBook_author(), requestDto.getCategory()
        );
        Book savedBook = bookRepository.save(book);
        return convertToPostResponseDto(savedBook);
    }

    // 책 전체 조회
    public List<GetBookListResponseDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(this::convertToGetBookListResponseDto)
                .collect(Collectors.toList());
    }

    // 책 단건 조회
    public GetBookResponseDto getBookById(Long id) {
        try {
            Book book = bookRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("책을 찾을 수 없습니다" + id));
            return convertToGetBookResponseDto(book);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }




    private PostBookResponseDto convertToPostResponseDto(Book book) {
        return new PostBookResponseDto (
                book.getId() ,book.getBook_title(), book.getBook_author(), book.getCategory()
        );
    }

    private GetBookListResponseDto convertToGetBookListResponseDto(Book book) {
        return new GetBookListResponseDto (
                book.getId() ,book.getBook_title(), book.getBook_author(), book.getCategory()
        );
    }

    private GetBookResponseDto convertToGetBookResponseDto(Book book) {
        return new GetBookResponseDto (
                book.getId() ,book.getBook_title(), book.getBook_author(), book.getCategory()
        );
    }


}
