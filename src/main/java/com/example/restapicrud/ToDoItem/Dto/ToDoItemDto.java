package com.example.restapicrud.ToDoItem.Dto;

import com.example.restapicrud.ToDoItem.Domain.entity.ToDoItemEntity;
import lombok.*;
import net.bytebuddy.asm.Advice;

@Getter @Setter
@ToString
@NoArgsConstructor
public class ToDoItemDto {
    private Long id;
    private String title;
    private Boolean done;

    public ToDoItemEntity toEntity(){
        ToDoItemEntity toDoItemEntity = ToDoItemEntity.builder()
                .id(id)
                .title(title)
                .done(done)
                .build();
        return toDoItemEntity;
    }

    @Builder
    public ToDoItemDto(Long id, String title, Boolean done){
        this.id = id;
        this.title = title;
        this.done = done;
    }
}
