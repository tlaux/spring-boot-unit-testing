package one.laux.unittesting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import one.laux.unittesting.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
