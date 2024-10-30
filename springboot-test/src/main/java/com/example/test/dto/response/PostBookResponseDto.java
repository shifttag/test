package com.example.test.dto.response;

import com.example.test.entity.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostBookResponseDto {
    private Long id;
    private String book_title;
    private String book_author;
    private Category category;
}
