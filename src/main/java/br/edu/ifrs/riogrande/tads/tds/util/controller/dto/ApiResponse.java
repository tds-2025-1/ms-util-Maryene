package br.edu.ifrs.riogrande.tads.tds.util.controller.dto;

public class ApiResponse<T> {

    private final T data;

    public ApiResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}