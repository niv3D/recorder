package com.nvd.recorder.core.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Long id,
        @NotEmpty
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive
        Integer miles
) {

    public Run {
        if (completedOn.isBefore(startedOn)) {
            throw new IllegalArgumentException("completedOn must be after startedOn");
        }
    }

}
