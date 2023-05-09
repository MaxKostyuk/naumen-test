package com.kmv.naumentest.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameAge {

    @NotBlank(message = "Name should not be empty or contain only spaces")
    @Size(min = 3, max = 15, message = "Name should contain more than 2 and less than 16 characters")
    private String name;
    private Integer age;
    private Integer count;
}
