package com.nvd.recorder.core.run;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunService {

    private final RunRepository runRepository;

    public RunService(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    public List<Run> findAll() {
        return runRepository.findAll();
    }

    public Optional<Run> findById(Long id) {
        return runRepository.findById(id);
    }

    public Run create(@Valid Run run) {
        return runRepository.create(run);
    }

    public Run update(Long id, @Valid Run run) {
        return runRepository.update(id, run);
    }

    public Run delete(Long id) {
        return runRepository.delete(id);
    }
}
