package deu.ac.kr.webapp.repository;

import deu.ac.kr.webapp.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
