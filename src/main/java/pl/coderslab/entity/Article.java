package pl.coderslab.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "articles")
@Setter
@Getter
@EqualsAndHashCode
public class Article {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 200)
  private String title;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToMany(fetch = FetchType.EAGER)
  private @JoinTable(
      name = "articles_categories",
      joinColumns = @JoinColumn(name = "article_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id"))
  Set<Category> categories = new HashSet<>();

  @Lob private String content;

  @Column(updatable = false)
  @CreationTimestamp
  private LocalDateTime created;

  @UpdateTimestamp private LocalDateTime updated;

  @PrePersist
  public void prePersist() {
    created = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updated = LocalDateTime.now();
  }
}
