package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.dto.AddArticleRequest;
import com.example.demo.service.BlogService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON 형태로 반환하는 컨트롤러

public class BlogApiController{
  private final BlogService blogService;
  // HTTP 메서드가 포스트일 때 전달받은 URL과 동일하면 메서드로 매핑
  @PostMapping("/api/articles")

  public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request){
    Article savedArticle = blogService.save(request);
    // 요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
    return ResponseEntity.status(HttpStatus.CREATED)
      .body(savedArticle);
  }

  @GetMapping("/api/articles")
  public ResponseEntity<List