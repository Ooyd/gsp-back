package yemenshi.gsp.todo_list.domain.member.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import yemenshi.gsp.todo_list.domain.member.entity.Todo;
import yemenshi.gsp.todo_list.domain.member.entity.TodoDto;

import java.util.*;


@Repository
public class TodoRepository {

  @PersistenceContext
  private EntityManager em;

  public void create(Todo todo) {
    em.persist(todo);
  }


  public void save(TodoDto todoDto) {
    Todo todo = new Todo(todoDto);
    if (todoDto.getId() == 0) {
      em.persist(todo);
    } else {
      em.merge(todo);
    }
  }

  public Todo getTodo(int id) {
    return em.find(Todo.class, id);
  }

//  public Optional<Todo> findById(TodoDto todoDto) {
//    Todo todo = em.find(Todo.class, todoDto.getId());
//    return Optional.of(todo);
//  }


  public void delete(TodoDto todoDto) {
    Todo todo = new Todo(todoDto);
    em.remove(em.contains(todo) ? todo : em.merge(todo));
  }


  public List<Todo> searchTodos(TodoDto todoDto) {
    StringBuilder queryStr = new StringBuilder("SELECT t FROM Todo t WHERE 1=1");
    Map<String, Object> params = new HashMap<>();

    if (todoDto.getKeyword() != null) {
      queryStr.append(" AND (t.title LIKE :keyword OR t.description LIKE :keyword)");
      params.put("keyword", "%" + todoDto.getKeyword() + "%");
    }
//    if (todoDto.getStartDate() != null) {
//      queryStr.append(" AND t.createdTime >= :startDate");
//      params.put("startDate", LocalDateTime.parse(todoDto.getStartDate()));
//    }
//    if (todoDto.getEndDate() != null) {
//      queryStr.append(" AND t.createdTime <= :endDate");
//      params.put("endDate", LocalDateTime.parse(todoDto.getEndDate()));
//    }

    TypedQuery<Todo> query = em.createQuery(queryStr.toString(), Todo.class);
    for (Map.Entry<String, Object> param : params.entrySet()) {
      query.setParameter(param.getKey(), param.getValue());
    }

    List<Todo> todos = query.getResultList();
    return null;
  }
}
