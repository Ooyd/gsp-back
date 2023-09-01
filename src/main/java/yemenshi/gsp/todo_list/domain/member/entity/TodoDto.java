package yemenshi.gsp.todo_list.domain.member.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
public class TodoDto extends Todo {
  /**
   * DTO에만 선언되어있는 필드값들
   * Todo 검색시 사용할 필터값들을 필드에 선언 ::
   * 이유 -> get방식의 검색시 여러 파라미터들이 들어갈텐데 controller,service로직에서 매개변수가 많으면 불필요하다 생각해서 TodoDTO에 필드로 선언해서 가능한지 확인해보려고.
   * Test용임다.
   * Entity클래스만 보시면될듯(볼건 딱히 없지만..)
   */
  int startPage;
  int endPage;
  String keyword;
  String tag;
  LocalDateTime startDate;
  LocalDateTime endDate;
}
