package com.example.test.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, length = 100)
    private String book_title;

    @Column(nullable = false, length = 255)
    private String book_author;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @PrePersist
    public void prePersist() {
        if (this.category == null) {
            this.category = Category.기타; // 기본값 설정
        }
    }


}
