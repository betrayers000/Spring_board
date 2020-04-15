package com.example.restapicrud.ToDoItem.Domain.repository;

import com.example.restapicrud.ToDoItem.Domain.entity.ToDoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItemEntity, Long>{

}
