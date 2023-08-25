package pl.coderslab.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.dao.AuthorDao;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.entity.Author;

@Component
@AllArgsConstructor
public class AuthorConverter implements Converter<String, Author> {

  private AuthorDao authorDao;

  @Override
  public Author convert(String id) {
    return authorDao.findById(Integer.parseInt(id));
  }
}
