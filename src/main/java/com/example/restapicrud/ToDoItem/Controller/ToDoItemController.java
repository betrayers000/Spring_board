package com.example.restapicrud.ToDoItem.Controller;

import com.example.restapicrud.ToDoItem.Dto.ToDoItemDto;
import com.example.restapicrud.ToDoItem.Service.ToDoItemService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
public class ToDoItemController {

    String SUCCESS = "Success";
    String FAIL = "Fail";

    // if don't use autowired, toDoItemService is null.
    @Autowired
    private ToDoItemService toDoItemService;

    @Getter
    @Setter
    @Builder
    public static class ToDoItemRequest{
        private long id;
        private String title;
        private Boolean done;
    }

    private ToDoItemDto toDoItemBuild(ToDoItemRequest toDoItemRequest){
        ToDoItemDto toDoItemDto = ToDoItemDto.builder()
                .id(toDoItemRequest.getId())
                .title(toDoItemRequest.getTitle())
                .done(toDoItemRequest.getDone())
                .build();
        return toDoItemDto;
    }

    @GetMapping("/todolist")
    @ResponseBody
    public HashMap<String, Object> ToDoList(){
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ToDoItemDto> todoList = toDoItemService.getToDoList();
        map.put("ToDoList",todoList);
        return map;
    }

    @GetMapping("/todo/{id}")
    @ResponseBody
    public HashMap<String, Object> ToDoItem(@PathVariable("id") Long id){
        HashMap<String, Object> map = new HashMap<String, Object>();
        ToDoItemDto toDoItemDto = toDoItemService.getItem(id);
        map.put("result", toDoItemDto);
        return map;
    }

    @PostMapping(value = "/createtodoitem", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, Object> createToDoItem(@RequestBody final ToDoItemRequest toDoItemRequest){
        ToDoItemDto toDoItemDto = toDoItemBuild(toDoItemRequest);
        Long new_id = toDoItemService.saveItem(toDoItemDto);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("new_id", new_id);
        return map;
    }

    @PutMapping(value = "/updatetodoitem", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<String, Object> updateTodoItem(@RequestBody final ToDoItemRequest toDoItemRequest){

        HashMap<String, Object> map = new HashMap<String, Object>();
        ToDoItemDto toDoItemDto = toDoItemBuild(toDoItemRequest);
        try{
            toDoItemService.saveItem(toDoItemDto);
            map.put("result", SUCCESS);
        }catch(Exception e){
            map.put("result", FAIL);
        }
        return map;
    }
}
