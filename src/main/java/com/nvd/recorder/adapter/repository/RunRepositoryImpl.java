package com.nvd.recorder.adapter.repository;

import com.nvd.recorder.adapter.repository.tables.records.RunRecord;
import com.nvd.recorder.core.run.Run;
import com.nvd.recorder.core.run.RunRepository;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

import static com.nvd.recorder.adapter.repository.Tables.RUN;

@Repository
public class RunRepositoryImpl implements RunRepository {

    private final DSLContext dslContext;

    private final RecordMapper<RunRecord, Run> runMapper = (record) -> new Run(
            record.getId(),
            record.getTitle(),
            record.getStartedOn(),
            record.getCompletedOn(),
            record.getMiles()
    );

    private final BiConsumer<Run, RunRecord> runRecordUnMapper = (run, runRecord) -> {
        runRecord.setTitle(run.title());
        runRecord.setStartedOn(run.startedOn());
        runRecord.setCompletedOn(run.completedOn());
        runRecord.setMiles(run.miles());
    };

    public RunRepositoryImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Run> findAll() {
        return dslContext.fetch(RUN).map(runMapper);
    }

    @Override
    public Optional<Run> findById(Long id) {
        return dslContext.fetchOptional(RUN, RUN.ID.eq(id)).map(runMapper);
    }

    @Override
    public Run create(Run run) {
        RunRecord runRecord = dslContext.newRecord(RUN);
        runRecordUnMapper.accept(run, runRecord);
        runRecord.store();
        return runMapper.map(runRecord);
    }

    @Override
    public Run update(Long id, Run run) {
        Optional<RunRecord> optionalRunRecord = dslContext.fetchOptional(RUN, RUN.ID.eq(id));
        RunRecord runRecord = optionalRunRecord.orElseThrow();
        runRecordUnMapper.accept(run, runRecord);
        runRecord.store();
        return runMapper.map(runRecord);
    }

    @Override
    public Run delete(Long id) {
        Optional<RunRecord> optionalRunRecord = dslContext.fetchOptional(RUN, RUN.ID.eq(id));
        RunRecord runRecord = optionalRunRecord.orElseThrow();
        runRecord.delete();
        return runMapper.map(runRecord);
    }
}
