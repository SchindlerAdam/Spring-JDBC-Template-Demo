package com.schindler.springjdbcdemo.entitiy;

import lombok.Data;

@Data
public class Developer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String programmingLanguage;
}
