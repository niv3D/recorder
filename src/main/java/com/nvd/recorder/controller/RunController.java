package com.nvd.recorder.controller;

import com.nvd.recorder.core.run.Run;
import com.nvd.recorder.core.run.RunService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class RunController {

    private final RunService runService;

    public RunController(RunService runService) {
        this.runService = runService;
    }

    @GetMapping("/api/runs")
    List<Run> findAll() {
        return runService.findAll();
    }

    @GetMapping("/api/runs/{id}")
    Run findById(@PathVariable Long id) {
        Optional<Run> run = runService.findById(id);
        return run.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/api/runs")
    @ResponseStatus(HttpStatus.CREATED)
    Run create(@RequestBody @Valid Run run) {
        return runService.create(run);
    }

    @PutMapping("/api/runs/{id}")
    Run update(@RequestBody @Valid Run run, @PathVariable Long id) {
        return runService.update(id, run);
    }

    @DeleteMapping("/api/runs/{id}")
    Run delete(@PathVariable Long id) {
        return runService.delete(id);
    }
}
