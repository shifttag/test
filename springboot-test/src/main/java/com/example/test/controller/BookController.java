package com.example.test.controller;

import com.example.test.dto.request.PostBookRequestDto;
import com.example.test.dto.response.GetBookListResponseDto;
import com.example.test.dto.response.GetBookResponseDto;
import com.example.test.dto.response.PostBookResponseDto;
import com.example.test.entity.Book;
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

    // 책 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostBookResponseDto> updateBook(@PathVariable Long id, @RequestBody PostBookRequestDto requestDto){
        PostBookResponseDto updateBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.ok(updateBook);
    }

    // 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // 제목에 특정 단어가 포함된 책 조회
    @GetMapping("/{keyword}")
    public ResponseEntity<List<PostBookResponseDto>> getBooksByTitleContaining(@RequestParam String keyword) {
        List<PostBookResponseDto> books = bookService.getBooksByTitleContaining(keyword);
        return ResponseEntity.ok(books);
    }

}
