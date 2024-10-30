package com.example.test.dto.response;

import com.example.test.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetBookListResponseDto {
    private Long id;
    private String title;
    private String book_author;
    private Category category;
}
