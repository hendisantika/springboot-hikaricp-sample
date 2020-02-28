package com.hendisantika.springboothikaricpsample.controller;

import com.hendisantika.springboothikaricpsample.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
