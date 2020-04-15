package com.example.restapicrud.ToDoItem.Service;

import com.example.restapicrud.ToDoItem.Domain.entity.ToDoItemEntity;
import com.example.restapicrud.ToDoItem.Domain.repository.ToDoItemRepository;
import com.example.restapicrud.ToDoItem.Dto.ToDoItemDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository toDoItemRepository;

    private ToDoItemDto toDoItemEntityBuild(ToDoItemEntity toDoItemEntity){
        ToDoItemDto toDoItemDto = ToDoItemDto.builder()
                .id(toDoItemEntity.getId())
                .title(toDoItemEntity.getTitle())
                .done(toDoItemEntity.getDone())
                .build();
        return toDoItemDto;
    }

    @Transactional
    public List<ToDoItemDto> getToDoList(){
        List<ToDoItemEntity> toDoItemEntities = toDoItemRepository.findAll();
        List<ToDoItemDto> toDoItemDtoList = new ArrayList<>();

        for (ToDoItemEntity toDoItemEntity : toDoItemEntities){
            if (toDoItemEntity != null) {
                ToDoItemDto toDoItemDto = toDoItemEntityBuild(toDoItemEntity);
                toDoItemDtoList.add(toDoItemDto);
            }
        }
        return toDoItemDtoList;
    }

    @Transactional
    public Long saveItem(ToDoItemDto toDoItemDto){
        return toDoItemRepository.save(toDoItemDto.toEntity()).getId();
    }

    @Transactional
    public ToDoItemDto getItem(Long id){
        ToDoItemEntity toDoItemEntity = toDoItemRepository.findById(id).get();
        ToDoItemDto toDoItemDto = toDoItemEntityBuild(toDoItemEntity);
        return toDoItemDto;

    }
}
