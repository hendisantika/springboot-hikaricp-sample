package com.hendisantika.springboothikaricpsample.repository;

import com.hendisantika.springboothikaricpsample.entity.Article;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-hikaricp-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/20
 * Time: 06.59
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
