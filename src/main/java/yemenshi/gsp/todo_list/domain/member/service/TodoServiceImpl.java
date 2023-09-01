package yemenshi.gsp.todo_list.domain.member.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yemenshi.gsp.todo_list.domain.member.entity.Todo;
import yemenshi.gsp.todo_list.domain.member.entity.TodoDto;
import yemenshi.gsp.todo_list.domain.member.repository.TodoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class TodoServiceImpl implements TodoService {

  @Autowired
  private TodoRepository todoRepository;

  public List<Todo> listTodos(TodoDto todoDto) {
    List<Todo> todos = todoRepository.searchTodos(todoDto);
    return todos;
  }

  public Todo getTodo(int id) {
    Todo todo = todoRepository.getTodo(id);
    return todo;
  }

  public void createTodo(TodoDto todoDto) {
    Todo todo = new Todo(todoDto);
    todoRepository.create(todo);
  }

//  public void updateTodo(int id, TodoDto todoDto) {
//    Todo todo = new Todo(todoDto);
//    todoRepository.update(id, todo);
//  }

//  public void deleteTodo(int id) {
//    todoRepository.delete(id);
//  }
}