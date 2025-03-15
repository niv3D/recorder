/*
 * This file is generated by jOOQ.
 */
package com.nvd.recorder.adapter.repository;


import com.nvd.recorder.adapter.repository.tables.Run;
import com.nvd.recorder.adapter.repository.tables.records.RunRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * runners.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<RunRecord> KEY_RUN_PRIMARY = Internal.createUniqueKey(Run.RUN, DSL.name("KEY_run_PRIMARY"), new TableField[] { Run.RUN.ID }, true);
}
