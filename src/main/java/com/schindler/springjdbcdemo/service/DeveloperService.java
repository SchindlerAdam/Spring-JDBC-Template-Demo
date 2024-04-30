package com.schindler.springjdbcdemo.service;

import com.schindler.springjdbcdemo.entitiy.Developer;
import com.schindler.springjdbcdemo.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public boolean save(final Developer developer) {
        final int affectedRows = developerRepository.save(developer);
        return affectedRows > 0;
    }

    public List<Developer> findAll() {
        return developerRepository.findAll();
    }

    public Developer findById(final long id) {
        return developerRepository.findById(id);
    }
}
