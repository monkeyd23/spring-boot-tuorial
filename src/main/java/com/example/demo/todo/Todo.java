package com.example.demo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Todo {
    private final Long id;
    private String name;
    private String Description;
    private Date dueDate;
    private TodoStatus status;
}
