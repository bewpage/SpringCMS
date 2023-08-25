package pl.coderslab.converter;

import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

@Component
@AllArgsConstructor
public class ArticleConverter implements Converter<String, Article> {

  private ArticleDao articleDao;
  @Override
  public Article convert(String id) {
    return articleDao.findById(Long.parseLong(id));
  }
}
