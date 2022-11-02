package deu.ac.kr.webapp.enums;

import lombok.AllArgsConstructor;

/**
 * 게시판 종류를 관리하는 Enum 클래스입니다.
 *
 * @see deu.ac.kr.webapp.entity.Post
 * @author Mina-1316
 */
@AllArgsConstructor
public enum BoardType {
  /**
   * 공지 게시판입니다.
   */
  NOTICE,
  /**
   * 자유 게시판입니다.
   */
  FREE,
  /**
   * 질문 게시판입니다.
   */
  QNA
}
