package com.example.test.dto.request;

import com.example.test.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostBookRequestDto {
    private String book_title;
    private String book_author;
    private Category category;
}
