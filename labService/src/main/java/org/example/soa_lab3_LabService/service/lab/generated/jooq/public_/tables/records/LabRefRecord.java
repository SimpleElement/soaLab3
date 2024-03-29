/*
 * This file is generated by jOOQ.
 */
package org.example.soa_lab3_LabService.service.lab.generated.jooq.public_.tables.records;


import java.time.LocalDateTime;

import org.example.soa_lab3_LabService.service.lab.generated.jooq.public_.tables.LabRef;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LabRefRecord extends UpdatableRecordImpl<LabRefRecord> implements Record15<Double, Integer, Float, Double, Long, LocalDateTime, Long, LocalDateTime, String, String, String, String, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.lab_ref.coordinates_y</code>.
     */
    public void setCoordinatesY(Double value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.lab_ref.coordinates_y</code>.
     */
    public Double getCoordinatesY() {
        return (Double) get(0);
    }

    /**
     * Setter for <code>public.lab_ref.minimal_point</code>.
     */
    public void setMinimalPoint(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.lab_ref.minimal_point</code>.
     */
    public Integer getMinimalPoint() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.lab_ref.person_location_x</code>.
     */
    public void setPersonLocationX(Float value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_location_x</code>.
     */
    public Float getPersonLocationX() {
        return (Float) get(2);
    }

    /**
     * Setter for <code>public.lab_ref.person_location_y</code>.
     */
    public void setPersonLocationY(Double value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_location_y</code>.
     */
    public Double getPersonLocationY() {
        return (Double) get(3);
    }

    /**
     * Setter for <code>public.lab_ref.coordinates_x</code>.
     */
    public void setCoordinatesX(Long value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.lab_ref.coordinates_x</code>.
     */
    public Long getCoordinatesX() {
        return (Long) get(4);
    }

    /**
     * Setter for <code>public.lab_ref.creation_date</code>.
     */
    public void setCreationDate(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.lab_ref.creation_date</code>.
     */
    public LocalDateTime getCreationDate() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>public.lab_ref.id</code>.
     */
    public void setId(Long value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.lab_ref.id</code>.
     */
    public Long getId() {
        return (Long) get(6);
    }

    /**
     * Setter for <code>public.lab_ref.person_birthday</code>.
     */
    public void setPersonBirthday(LocalDateTime value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_birthday</code>.
     */
    public LocalDateTime getPersonBirthday() {
        return (LocalDateTime) get(7);
    }

    /**
     * Setter for <code>public.lab_ref.difficulty</code>.
     */
    public void setDifficulty(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.lab_ref.difficulty</code>.
     */
    public String getDifficulty() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.lab_ref.name</code>.
     */
    public void setName(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.lab_ref.name</code>.
     */
    public String getName() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.lab_ref.person_eye_color</code>.
     */
    public void setPersonEyeColor(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_eye_color</code>.
     */
    public String getPersonEyeColor() {
        return (String) get(10);
    }

    /**
     * Setter for <code>public.lab_ref.person_hair_color</code>.
     */
    public void setPersonHairColor(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_hair_color</code>.
     */
    public String getPersonHairColor() {
        return (String) get(11);
    }

    /**
     * Setter for <code>public.lab_ref.person_location_name</code>.
     */
    public void setPersonLocationName(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_location_name</code>.
     */
    public String getPersonLocationName() {
        return (String) get(12);
    }

    /**
     * Setter for <code>public.lab_ref.person_name</code>.
     */
    public void setPersonName(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_name</code>.
     */
    public String getPersonName() {
        return (String) get(13);
    }

    /**
     * Setter for <code>public.lab_ref.person_nationality</code>.
     */
    public void setPersonNationality(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>public.lab_ref.person_nationality</code>.
     */
    public String getPersonNationality() {
        return (String) get(14);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Long> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record15 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row15<Double, Integer, Float, Double, Long, LocalDateTime, Long, LocalDateTime, String, String, String, String, String, String, String> fieldsRow() {
        return (Row15) super.fieldsRow();
    }

    @Override
    public Row15<Double, Integer, Float, Double, Long, LocalDateTime, Long, LocalDateTime, String, String, String, String, String, String, String> valuesRow() {
        return (Row15) super.valuesRow();
    }

    @Override
    public Field<Double> field1() {
        return LabRef.LAB_REF.COORDINATES_Y;
    }

    @Override
    public Field<Integer> field2() {
        return LabRef.LAB_REF.MINIMAL_POINT;
    }

    @Override
    public Field<Float> field3() {
        return LabRef.LAB_REF.PERSON_LOCATION_X;
    }

    @Override
    public Field<Double> field4() {
        return LabRef.LAB_REF.PERSON_LOCATION_Y;
    }

    @Override
    public Field<Long> field5() {
        return LabRef.LAB_REF.COORDINATES_X;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return LabRef.LAB_REF.CREATION_DATE;
    }

    @Override
    public Field<Long> field7() {
        return LabRef.LAB_REF.ID;
    }

    @Override
    public Field<LocalDateTime> field8() {
        return LabRef.LAB_REF.PERSON_BIRTHDAY;
    }

    @Override
    public Field<String> field9() {
        return LabRef.LAB_REF.DIFFICULTY;
    }

    @Override
    public Field<String> field10() {
        return LabRef.LAB_REF.NAME;
    }

    @Override
    public Field<String> field11() {
        return LabRef.LAB_REF.PERSON_EYE_COLOR;
    }

    @Override
    public Field<String> field12() {
        return LabRef.LAB_REF.PERSON_HAIR_COLOR;
    }

    @Override
    public Field<String> field13() {
        return LabRef.LAB_REF.PERSON_LOCATION_NAME;
    }

    @Override
    public Field<String> field14() {
        return LabRef.LAB_REF.PERSON_NAME;
    }

    @Override
    public Field<String> field15() {
        return LabRef.LAB_REF.PERSON_NATIONALITY;
    }

    @Override
    public Double component1() {
        return getCoordinatesY();
    }

    @Override
    public Integer component2() {
        return getMinimalPoint();
    }

    @Override
    public Float component3() {
        return getPersonLocationX();
    }

    @Override
    public Double component4() {
        return getPersonLocationY();
    }

    @Override
    public Long component5() {
        return getCoordinatesX();
    }

    @Override
    public LocalDateTime component6() {
        return getCreationDate();
    }

    @Override
    public Long component7() {
        return getId();
    }

    @Override
    public LocalDateTime component8() {
        return getPersonBirthday();
    }

    @Override
    public String component9() {
        return getDifficulty();
    }

    @Override
    public String component10() {
        return getName();
    }

    @Override
    public String component11() {
        return getPersonEyeColor();
    }

    @Override
    public String component12() {
        return getPersonHairColor();
    }

    @Override
    public String component13() {
        return getPersonLocationName();
    }

    @Override
    public String component14() {
        return getPersonName();
    }

    @Override
    public String component15() {
        return getPersonNationality();
    }

    @Override
    public Double value1() {
        return getCoordinatesY();
    }

    @Override
    public Integer value2() {
        return getMinimalPoint();
    }

    @Override
    public Float value3() {
        return getPersonLocationX();
    }

    @Override
    public Double value4() {
        return getPersonLocationY();
    }

    @Override
    public Long value5() {
        return getCoordinatesX();
    }

    @Override
    public LocalDateTime value6() {
        return getCreationDate();
    }

    @Override
    public Long value7() {
        return getId();
    }

    @Override
    public LocalDateTime value8() {
        return getPersonBirthday();
    }

    @Override
    public String value9() {
        return getDifficulty();
    }

    @Override
    public String value10() {
        return getName();
    }

    @Override
    public String value11() {
        return getPersonEyeColor();
    }

    @Override
    public String value12() {
        return getPersonHairColor();
    }

    @Override
    public String value13() {
        return getPersonLocationName();
    }

    @Override
    public String value14() {
        return getPersonName();
    }

    @Override
    public String value15() {
        return getPersonNationality();
    }

    @Override
    public LabRefRecord value1(Double value) {
        setCoordinatesY(value);
        return this;
    }

    @Override
    public LabRefRecord value2(Integer value) {
        setMinimalPoint(value);
        return this;
    }

    @Override
    public LabRefRecord value3(Float value) {
        setPersonLocationX(value);
        return this;
    }

    @Override
    public LabRefRecord value4(Double value) {
        setPersonLocationY(value);
        return this;
    }

    @Override
    public LabRefRecord value5(Long value) {
        setCoordinatesX(value);
        return this;
    }

    @Override
    public LabRefRecord value6(LocalDateTime value) {
        setCreationDate(value);
        return this;
    }

    @Override
    public LabRefRecord value7(Long value) {
        setId(value);
        return this;
    }

    @Override
    public LabRefRecord value8(LocalDateTime value) {
        setPersonBirthday(value);
        return this;
    }

    @Override
    public LabRefRecord value9(String value) {
        setDifficulty(value);
        return this;
    }

    @Override
    public LabRefRecord value10(String value) {
        setName(value);
        return this;
    }

    @Override
    public LabRefRecord value11(String value) {
        setPersonEyeColor(value);
        return this;
    }

    @Override
    public LabRefRecord value12(String value) {
        setPersonHairColor(value);
        return this;
    }

    @Override
    public LabRefRecord value13(String value) {
        setPersonLocationName(value);
        return this;
    }

    @Override
    public LabRefRecord value14(String value) {
        setPersonName(value);
        return this;
    }

    @Override
    public LabRefRecord value15(String value) {
        setPersonNationality(value);
        return this;
    }

    @Override
    public LabRefRecord values(Double value1, Integer value2, Float value3, Double value4, Long value5, LocalDateTime value6, Long value7, LocalDateTime value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached LabRefRecord
     */
    public LabRefRecord() {
        super(LabRef.LAB_REF);
    }

    /**
     * Create a detached, initialised LabRefRecord
     */
    public LabRefRecord(Double coordinatesY, Integer minimalPoint, Float personLocationX, Double personLocationY, Long coordinatesX, LocalDateTime creationDate, Long id, LocalDateTime personBirthday, String difficulty, String name, String personEyeColor, String personHairColor, String personLocationName, String personName, String personNationality) {
        super(LabRef.LAB_REF);

        setCoordinatesY(coordinatesY);
        setMinimalPoint(minimalPoint);
        setPersonLocationX(personLocationX);
        setPersonLocationY(personLocationY);
        setCoordinatesX(coordinatesX);
        setCreationDate(creationDate);
        setId(id);
        setPersonBirthday(personBirthday);
        setDifficulty(difficulty);
        setName(name);
        setPersonEyeColor(personEyeColor);
        setPersonHairColor(personHairColor);
        setPersonLocationName(personLocationName);
        setPersonName(personName);
        setPersonNationality(personNationality);
        resetChangedOnNotNull();
    }
}
