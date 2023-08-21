package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDAO {

  @PersistenceContext private EntityManager entityManager;

  public void saveAuthor(Author author) {
    entityManager.persist(author);
  }

  public Author findAuthorById(Integer id) {
    return entityManager.find(Author.class, id);
  }

  public void updateAuthor(Author author) {
    entityManager.merge(author);
  }

  public void deleteAuthor(Author author) {
    entityManager.remove(entityManager.contains(author) ? author : entityManager.merge(author));
  }

  public List<Author> findAllAuthors() {
    return entityManager.createQuery("SELECT a FROM Author a").getResultList();
  }
}
