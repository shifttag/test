package com.example.test.dto.response;

import com.example.test.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetBookResponseDto {
    private Long id;
    private String book_title;
    private String book_author;
    private Category category;
}
