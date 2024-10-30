package com.example.test.controller;

import com.example.test.dto.request.PostBookRequestDto;
import com.example.test.dto.response.GetBookListResponseDto;
import com.example.test.dto.response.GetBookResponseDto;
import com.example.test.dto.response.PostBookResponseDto;
import com.example.test.repository.BookRepository;
import com.example.test.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    // 책 생성
    @PostMapping
    public ResponseEntity<PostBookResponseDto> createBook(@RequestBody PostBookRequestDto requestDto) {
        PostBookResponseDto createdBook = bookService.createBook(requestDto);
        return ResponseEntity.ok(createdBook);
    }

    // 책 전체 조회
    @GetMapping()
    public ResponseEntity<List<GetBookListResponseDto>> getAllBooks() {
        List<GetBookListResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // 책 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<GetBookResponseDto> getBookById(@PathVariable Long id){
        GetBookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }


}
