package com.hendisantika.springboothikaricpsample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-hikaricp-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/02/20
 * Time: 07.03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleInfoDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long articleId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;
}
