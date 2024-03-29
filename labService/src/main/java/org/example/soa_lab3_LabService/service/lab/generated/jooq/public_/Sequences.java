/*
 * This file is generated by jOOQ.
 */
package org.example.soa_lab3_LabService.service.lab.generated.jooq.public_;


import org.jooq.Sequence;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * Convenience access to all sequences in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.discipline_seq</code>
     */
    public static final Sequence<Long> DISCIPLINE_SEQ = Internal.createSequence("discipline_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, 50, null, null, false, null);

    /**
     * The sequence <code>public.lab_seq</code>
     */
    public static final Sequence<Long> LAB_SEQ = Internal.createSequence("lab_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false), null, 50, null, null, false, null);
}
