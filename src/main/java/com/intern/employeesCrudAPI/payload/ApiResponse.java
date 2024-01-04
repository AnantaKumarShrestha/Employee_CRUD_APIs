package com.intern.employeesCrudAPI.payload;

import com.intern.employeesCrudAPI.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private Status status;
}
