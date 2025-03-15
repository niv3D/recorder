package com.nvd.recorder.core.run;

import java.util.List;
import java.util.Optional;

public interface RunRepository {

    List<Run> findAll();

    Optional<Run> findById(Long id);

    Run create(Run run);

    Run update(Long id, Run run);

    Run delete(Long id);
}
