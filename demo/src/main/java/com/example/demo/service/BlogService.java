package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.dto.AddArticleRequest;
import com.example.demo.repository.BlogRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 생성자를 추가
@Service // 빈으로 등록
public class BlogService{
  
  private final BlogRepository blogRepository;

  public Article save(AddArticleRequest request){
    return blogRepository.save(request.toEntity());
  }
}