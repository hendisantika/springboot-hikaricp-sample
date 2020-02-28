package com.hendisantika.springboothikaricpsample.controller;

import com.hendisantika.springboothikaricpsample.dto.ArticleInfoDto;
import com.hendisantika.springboothikaricpsample.entity.Article;
import com.hendisantika.springboothikaricpsample.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-hikaricp-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/20
 * Time: 07.04
 */
@RestController
@RequestMapping("user")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    //Fetches all articles
    @GetMapping(value = "articles")
    public ResponseEntity<List<ArticleInfoDto>> getAllArticles() {
        List<ArticleInfoDto> responseArticleList = new ArrayList<>();
        List<Article> articleList = articleService.getAllArticles();
        for (int i = 0; i < articleList.size(); i++) {
            ArticleInfoDto ob = new ArticleInfoDto();
            BeanUtils.copyProperties(articleList.get(i), ob);
            responseArticleList.add(ob);
        }
        return new ResponseEntity<List<ArticleInfoDto>>(responseArticleList, HttpStatus.OK);
    }
}
