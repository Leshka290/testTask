package ru.mytask.testtask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mytask.testtask.model.FrameworkModel;
import ru.mytask.testtask.service.FrameworkService;

import java.util.Collection;

@RestController
@RequestMapping("/frameworks")
public class FrameworkController {

    @Autowired
    private final FrameworkService frameworkService;

    public FrameworkController(FrameworkService frameworkService) {
        this.frameworkService = frameworkService;
    }

    @GetMapping
    public ResponseEntity<?> getFrameworks() {
        Collection<FrameworkModel> modelCollection = frameworkService.findAll();

        return ResponseEntity.ok(modelCollection);
    }

    @GetMapping("/{language}")
    public ResponseEntity<?> findAllByLanguage(@PathVariable String language) {
        Collection<FrameworkModel> modelCollection = frameworkService.findAllByLanguage(language);

        return ResponseEntity.ok(modelCollection);
    }
}
