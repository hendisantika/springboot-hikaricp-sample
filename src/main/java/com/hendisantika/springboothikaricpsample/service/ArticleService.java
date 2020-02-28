package com.hendisantika.springboothikaricpsample.service;

import com.hendisantika.springboothikaricpsample.entity.Article;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-hikaricp-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/20
 * Time: 07.00
 */
public interface ArticleService {
    List<Article> getAllArticles();

    void addArticle(Article article);
}
