package deu.ac.kr.webapp.repository;

import deu.ac.kr.webapp.configuration.annotate.RepositoryJpaTestEnvironment;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@Log4j2
@RepositoryJpaTestEnvironment
@DisplayName("[REPOSITORY] PostRepository Test")
public class PostRepositoryTest {
  // TODO: If repository need test related by convention, write test code.
}
