package com.manoj.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 0;
     static {
        todos.add(new Todo(++todosCount, "Learn Spring", "Complete learning spring by the end of feb 2024",
                LocalDate.now().plusWeeks(5), false));
        todos.add(new Todo(++todosCount, "Learn GCP", "Do certification on google cloud digital leader by the end of jan 2024",
                LocalDate.now().plusWeeks(1), false));
        todos.add(new Todo(++todosCount, "Learn GCP", "Do certification on google associate cloud engineer by the end of feb 2024",
                LocalDate.now().plusWeeks(5), false));
        todos.add(new Todo(++todosCount, "Learn DSA", "Start learning DSA and Practice it after completing the spring",
                LocalDate.now().plusMonths(4), false));
    }

    public List<Todo> findAllTodosOfUser(){
        return todos;
    }

    public List<Todo> findByName(String name){
        Predicate<Todo> predicate = todo -> todo.getName().equals(name);
         return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String name, String description, LocalDate targetDate, boolean status){
         Todo todo = new Todo(++todosCount,name,description,targetDate,status);
         todos.add(todo);
    }
    
    public void deleteById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(int id, String name, String description, LocalDate targetdate){
         Todo todo = findById(id);
         todo.setName(name);
         todo.setDescription(description);
         todo.setTargetDate(targetdate);
    }
}
