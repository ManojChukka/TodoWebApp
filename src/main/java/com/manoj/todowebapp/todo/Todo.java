package com.manoj.todowebapp.todo;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Todo {

    private int id;
    private String name;
    @Size(min=10, message="Enter atleast 10 character description")
    private String description;
    private LocalDate targetDate;
    private boolean status;
}
