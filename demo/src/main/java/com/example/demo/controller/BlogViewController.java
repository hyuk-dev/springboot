package com.example.demo.controller;

import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller

public class BlogViewController{
  private final BlogService blogService;

  @GetMapping("/articles")
  public String getArticles(Model model){
    List<ArticleListViewResponse> articles = blogService.findAll().stream()
      .map(ArticleListViewResponse::new)
      .toList();
    model.addAttribute("articles", articles);

    return "articleList";
  }
}