package com.example.demo.dto;

import com.example.demo.domain.Article;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class AddArticleRequest {
  private String title;
  private String content;

  public Article toEntity(){ // 생성자를 이용해 객체 생성
    return Article.builder()
      .title(title)
      .content(content)
      .build();
      
  }
}