package deu.ac.kr.webapp.entity;


import deu.ac.kr.webapp.enums.BoardType;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 게시글 정보를 저장하는 Post Entity입니다.
 */
@Entity
@Table(name = "post")
@Getter
@Builder
@AllArgsConstructor
@Setter
@RequiredArgsConstructor
public class Post {

  /**
   * Post 엔티티의 Primary Key입니다. 자동으로 생성되며, 대부분의 API에서 이 ID를 통해 접근합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Setter(AccessLevel.NONE)
  private Long id;

  /**
   * 이 Post가 어떤 게시판의 글인지를 나타내는 필드입니다.
   */
  @Column(nullable = false)
  @Setter(AccessLevel.NONE)
  private BoardType boardType;

  /**
   * Post 엔티티의 제목 필드입니다.
   */
  @Column(nullable = false)
  @Setter(AccessLevel.NONE)
  private String title;

  /**
   * Post 엔티티의 내용 필드입니다. HTML 태그를 포함할 수 있습니다.
   */
  @Column(nullable = false)
  private String content;

  /**
   * Post 엔티티의 작성자 필드입니다.
   */
  @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  @JoinColumn(name = "author_id")
  @Setter(AccessLevel.NONE)
  private User author;

  /**
   * Post 엔티티의 좋아요를 누른 사용자 목록입니다.
   */
  @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  @JoinColumn(name = "liked_user")
  private List<User> likedUser;

  /**
   * Post 엔티티의 싫어요를 누른 사용자 목록입니다.
   */
  @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  @JoinColumn(name = "disliked_user")
  private List<User> dislikedUser;

  /**
   * Post 엔티티의 게시글 작성 시간입니다. 자동으로 Entity 생성 시간에 맞춰 생성됩니다.
   */
  @Column(nullable = false)
  @Setter(AccessLevel.NONE)
  private LocalDateTime createdAt;


  @PrePersist
  protected void onCreate() {
    this.createdAt = LocalDateTime.now();
  }

}
