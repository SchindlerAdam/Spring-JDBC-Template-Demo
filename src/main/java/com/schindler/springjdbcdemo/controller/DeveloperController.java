package com.schindler.springjdbcdemo.controller;

import com.schindler.springjdbcdemo.dto.DeveloperCreatedDto;
import com.schindler.springjdbcdemo.entitiy.Developer;
import com.schindler.springjdbcdemo.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/developer")
@RequiredArgsConstructor
@RestController
public class DeveloperController {

    private final DeveloperService developerService;

    @PostMapping("/save")
    public ResponseEntity<DeveloperCreatedDto> save(@RequestBody final Developer developer) {
        final boolean saved = developerService.save(developer);
        if (saved) {
            return new ResponseEntity<>(new DeveloperCreatedDto(developer), HttpStatus.CREATED);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/developer/{id}")
    public ResponseEntity<Developer> getDeveloper(@PathVariable final long id) {
        return ResponseEntity.ok(developerService.findById(id));
    }

    @GetMapping("/developers")
    public ResponseEntity<List<Developer>> getDevelopers() {
        return ResponseEntity.ok(developerService.findAll());
    }
}
