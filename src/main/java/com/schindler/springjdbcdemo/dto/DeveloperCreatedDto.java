package com.schindler.springjdbcdemo.dto;

import com.schindler.springjdbcdemo.entitiy.Developer;
import lombok.Data;

@Data
public class DeveloperCreatedDto {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String programmingLanguage;

    public DeveloperCreatedDto(final Developer developer) {
        this.firstName = developer.getFirstName();
        this.lastName = developer.getLastName();
        this.email = developer.getEmail();
        this.programmingLanguage = developer.getProgrammingLanguage();
    }
}
