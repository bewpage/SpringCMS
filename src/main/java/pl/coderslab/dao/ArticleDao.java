package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

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

  public Article findById(Long id) {
    return entityManager.find(Article.class, id);
  }

  public void update(Article article) {
    entityManager.merge(article);
  }

  @Transactional
  public void delete(Article article) {
    Article managedArticle =
        entityManager.contains(article) ? article : entityManager.merge(article);

    for (Category category : managedArticle.getCategories()) {
      category.getArticles().remove(managedArticle);
    }

    Author author = managedArticle.getAuthor();
    if (author != null) {
      author.getArticles().remove(managedArticle);
    }
    entityManager.remove(managedArticle);
  }

  public List<Article> findAll() {
    return entityManager.createQuery("SELECT a FROM Article a").getResultList();
  }

  public List<Article> findLastFive() {
    return entityManager
        .createQuery("SELECT a FROM Article a ORDER BY a.created DESC")
        .setMaxResults(5)
        .getResultList();
  }
}
