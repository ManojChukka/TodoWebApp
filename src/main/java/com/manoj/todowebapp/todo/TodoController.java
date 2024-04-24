package com.manoj.todowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value="list-todos")
    public String listAllTodos(ModelMap model){
        List<Todo> todos = todoService.findAllTodosOfUser();
        model.put("todos",todos);
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(ModelMap model){
        Todo todo = new Todo(0,"","",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "todo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(@ModelAttribute("todo") @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        todoService.addTodo(todo.getName(),todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping(value="delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @GetMapping(value="update-todo")
    public String showUpdateTodo(ModelMap model, @RequestParam int id){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "todo";
    }

    @PostMapping(value="update-todo")
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        todoService.updateTodo(todo.getId(), todo.getName(),todo.getDescription(),todo.getTargetDate());
        return "redirect:list-todos";
    }
}
