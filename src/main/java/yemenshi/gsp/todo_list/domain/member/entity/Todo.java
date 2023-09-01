package yemenshi.gsp.todo_list.domain.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "member_id", nullable = false)
  private Member member;

  @Column(nullable = false)
  private String title;

  @Column
  private String description;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Status status;

  @Column(nullable = false)
  private LocalDateTime createdTime;

  @Column
  private LocalDateTime dueDate;

  @Column(nullable = false)
  private boolean isDeleted;

  public Todo(TodoDto todoDto){
    this.id = todoDto.getId();
    this.member = todoDto.getMember();
    this.title = todoDto.getTitle();
    this.description = todoDto.getDescription();
    this.status = todoDto.getStatus();
    this.createdTime = todoDto.getCreatedTime();
    this.dueDate = todoDto.getDueDate();
    this.isDeleted = todoDto.isDeleted();
  }


  public enum Status {
    COMPLETED,
    PENDING,
    DELETED
  }
}
