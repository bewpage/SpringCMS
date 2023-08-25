package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

  @PersistenceContext private EntityManager entityManager;

  public void save(Article article) {
    entityManager.persist(article);
  }

  public Article findById(Integer id) {
    return entityManager.find(Article.class, id);
  }

  public void update(Article article) {
    entityManager.merge(article);
  }

  public void delete(Article article) {
    entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
  }

  public List<Article> findAll() {
    return entityManager.createQuery("SELECT a FROM Article a").getResultList();
  }
}
