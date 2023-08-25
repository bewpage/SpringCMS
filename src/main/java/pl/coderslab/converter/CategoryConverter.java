package pl.coderslab.converter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Category;
import org.springframework.core.convert.converter.Converter;

@Component
@AllArgsConstructor
public class CategoryConverter implements Converter<String, Category> {

  private CategoryDao categoryDao;

  @Override
  public Category convert(String id) {
    return categoryDao.findById(Integer.parseInt(id));
  }
}
