package yemenshi.gsp.todo_list.domain.member.service;

import yemenshi.gsp.todo_list.domain.member.entity.Todo;
import yemenshi.gsp.todo_list.domain.member.entity.TodoDto;

import java.util.List;

public interface TodoService {
  List<Todo> listTodos(TodoDto todoDto);
  Todo getTodo(int id);
  void createTodo(TodoDto todoDto);
//  void updateTodo(int id, TodoDto todoDto);
//  void deleteTodo(int id);
}