package com.nocode.util.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonMerge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private String phone;
    @JsonMerge
    private Address address;
    @JsonMerge
    private Map<String, String> hobbies;
}
