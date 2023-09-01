package yemenshi.gsp.todo_list.domain.member;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yemenshi.gsp.todo_list.domain.member.entity.Member;
import yemenshi.gsp.todo_list.domain.member.entity.Todo;
import yemenshi.gsp.todo_list.domain.member.entity.TodoDto;
import yemenshi.gsp.todo_list.domain.member.service.TodoServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
@Slf4j
public class TodoController {

  @Autowired
  private TodoServiceImpl todoService;

  @GetMapping
  public ResponseEntity<Object> listTodos(TodoDto todoDto) {
    List<Todo> todos = todoService.listTodos(todoDto);
    return new ResponseEntity<>(todos, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getTodo(@PathVariable int id) {
    Todo todo = todoService.getTodo(id);
    return new ResponseEntity<>(todo, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Object> createTodo(@RequestBody TodoDto todoDto,HttpSession session) {

    Member member = (Member) session.getAttribute("user");
    if (member == null) {
      return new ResponseEntity<>("Member not found", HttpStatus.BAD_REQUEST);
    }
    todoService.createTodo(todoDto);
    return new ResponseEntity<>("Todo created successfully", HttpStatus.CREATED);
  }

//  @PutMapping("/{id}")
//  public ResponseEntity<Object> updateTodo(@PathVariable int id, @RequestBody TodoDto todoDto,HttpSession session) {
//    Member member = (Member) session.getAttribute("user");
//    if (member == null) {
//      return new ResponseEntity<>("Member not found", HttpStatus.BAD_REQUEST);
//    }
//    todoService.updateTodo(id, todoDto);
//    return new ResponseEntity<>("Todo updated successfully", HttpStatus.OK);
//  }

//  @DeleteMapping("/{id}")
//  public ResponseEntity<Object> deleteTodo(@PathVariable int id,HttpSession session) {
//    Member member = (Member) session.getAttribute("user");
//    if (member == null) {
//      return new ResponseEntity<>("Member not found", HttpStatus.BAD_REQUEST);
//    }
//    todoService.deleteTodo(id);
//    return new ResponseEntity<>("Todo deleted successfully", HttpStatus.OK);
//  }
}