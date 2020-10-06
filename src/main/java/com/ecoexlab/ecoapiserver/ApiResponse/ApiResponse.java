package com.ecoexlab.ecoapiserver.ApiResponse;


import lombok.*;

import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public abstract class ApiResponse<T> {
    private T data;
    private int ret_code;
    private List<String> errors;
}
