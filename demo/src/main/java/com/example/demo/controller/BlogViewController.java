package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.Article;
import com.example.demo.dto.ArticleListViewResponse;
import com.example.demo.dto.ArticleViewResponse;
import com.example.demo.service.BlogService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller

public class BlogViewController {
  private final BlogService blogService;

  @GetMapping("/articles")
  public String getArticles(Model model) {
    List<ArticleListViewResponse> articles = blogService.findAll()
        .stream()
        .map(ArticleListViewResponse::new)
        .toList();
    model.addAttribute("articles", articles);

    return "articleList";
  }

  @GetMapping("/articles/{id}")
  public String getArticle(@PathVariable Long id, Model model){
    Article article = blogService.findById(id);
    model.addAttribute("article", new ArticleViewResponse(article));

    return "article";
  }
}