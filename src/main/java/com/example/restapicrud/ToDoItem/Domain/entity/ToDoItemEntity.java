package com.example.restapicrud.ToDoItem.Domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "todoitem")
public class ToDoItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean done;

    @Builder
    public ToDoItemEntity(Long id, String title, Boolean done){
        this.id = id;
        this.title = title;
        this.done = done;
    }
}
