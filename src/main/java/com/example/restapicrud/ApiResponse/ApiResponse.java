package com.example.restapicrud.ApiResponse;

import lombok.*;

import java.util.List;

// T => todoitem
public abstract class ApiResponse<T> {
    @NonNull private T data;
    private List<String> errors;
}
