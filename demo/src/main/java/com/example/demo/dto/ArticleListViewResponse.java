package com.example.demo.dto;

import java.time.LocalDateTime;

import com.example.demo.domain.Article;

import lombok.Getter;

@Getter
public class ArticleListViewResponse {
  private final Long id;
  private final String title;
  private final String content;
  private final LocalDateTime createdAt;

  public ArticleListViewResponse(Article article){
    this.id = article.getId();
    this.title = article.getTitle();
    this.content = article.getContent();
    this.createdAt = article.getCreatedAt();
  }
}