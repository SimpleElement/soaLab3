package org.example.soa_lab3_LabService.ws.lab.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.math.NumberUtils;
import org.example.soa_lab3_LabService.common.object.page.Page;
import org.jooq.Condition;
import org.jooq.impl.DSL;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.example.soa_lab3_LabService.service.lab.generated.jooq.public_.tables.LabRef.LAB_REF;


@Getter
@Setter
public class LabFilter extends Page {
    private String id;

    private String name;

    private LocalDateTime creationDate;

    private String minimalPoint;

    private String difficulty;

    private String coordinatesX;

    private String coordinatesY;

    private String personName;

    private LocalDateTime personBirthday;

    private String personEyeColor;

    private String personHairColor;

    private String personNationality;

    private String personLocationName;

    private String personLocationX;

    private String personLocationY;

    private String idSortType;

    private String nameSortType;

    private String creationDateSortType;

    private String minimalPointSortType;

    private String difficultySortType;

    private String authorNameSortType;

    public Condition toPredicate() {
        List<Condition> predicates = new ArrayList<>();

        if (id != null)
            predicates.add(LAB_REF.ID.eq(NumberUtils.toLong(id)));

        if (name != null)
            predicates.add(LAB_REF.NAME.startsWithIgnoreCase(name));

        if (creationDate != null)
            predicates.add(LAB_REF.CREATION_DATE.eq(creationDate));

        if (minimalPoint != null)
            predicates.add(LAB_REF.MINIMAL_POINT.eq(NumberUtils.toInt(minimalPoint)));

        if (difficulty != null)
            predicates.add(LAB_REF.DIFFICULTY.eq(difficulty));

        if (coordinatesX != null)
            predicates.add(LAB_REF.COORDINATES_X.eq(NumberUtils.toLong(coordinatesX)));

        if (coordinatesY != null)
            predicates.add(LAB_REF.COORDINATES_Y.eq(NumberUtils.toDouble(coordinatesY)));

        if (personName != null)
            predicates.add(LAB_REF.PERSON_NAME.startsWithIgnoreCase(personName));

        if (personBirthday != null)
            predicates.add(LAB_REF.PERSON_BIRTHDAY.eq(personBirthday));

        if (personEyeColor != null)
            predicates.add(LAB_REF.PERSON_EYE_COLOR.eq(personEyeColor));

        if (personHairColor != null)
            predicates.add(LAB_REF.PERSON_HAIR_COLOR.eq(personHairColor));

        if (personNationality != null)
            predicates.add(LAB_REF.PERSON_NATIONALITY.eq(personNationality));

        if (personLocationName != null)
            predicates.add(LAB_REF.PERSON_LOCATION_NAME.eq(personLocationName));

        if (personLocationX != null)
            predicates.add(LAB_REF.PERSON_LOCATION_X.eq(NumberUtils.toFloat(personLocationX)));

        if (personLocationY != null)
            predicates.add(LAB_REF.PERSON_LOCATION_Y.eq(NumberUtils.toDouble(personLocationY)));

        return DSL.and(predicates);
    }

    public Sort getSort() {
        List<Sort> sortParams = new ArrayList<>();

        if (idSortType != null) {
            if (idSortType.equals("asc")) {
                sortParams.add(Sort.by("id").ascending());
            } else if (idSortType.equals("desc")) {
                sortParams.add(Sort.by("id").descending());
            }
        }

        if (nameSortType != null) {
            if (nameSortType.equals("asc")) {
                sortParams.add(Sort.by("name").ascending());
            } else if (nameSortType.equals("desc")) {
                sortParams.add(Sort.by("name").descending());
            }
        }

        if (creationDateSortType != null) {
            if (creationDateSortType.equals("asc")) {
                sortParams.add(Sort.by("creationDate").ascending());
            } else if (creationDateSortType.equals("desc")) {
                sortParams.add(Sort.by("creationDate").descending());
            }
        }

        if (minimalPointSortType != null) {
            if (minimalPointSortType.equals("asc")) {
                sortParams.add(Sort.by("minimalPoint").ascending());
            } else if (minimalPointSortType.equals("desc")) {
                sortParams.add(Sort.by("minimalPoint").descending());
            }
        }

        if (difficultySortType != null) {
            if (difficultySortType.equals("asc")) {
                sortParams.add(Sort.by("difficulty").ascending());
            } else if (difficultySortType.equals("desc")) {
                sortParams.add(Sort.by("difficulty").descending());
            }
        }

        if (authorNameSortType != null) {
            if (authorNameSortType.equals("asc")) {
                sortParams.add(Sort.by("author.name").ascending());
            } else if (authorNameSortType.equals("desc")) {
                sortParams.add(Sort.by("author.name").descending());
            }
        }

        if (sortParams.size() == 0)
            return Sort.by("id");
        else if (sortParams.size() == 1) {
            return sortParams.get(0);
        } else {
            Sort resSort = sortParams.get(0);
            for (int i = 1; i < sortParams.size(); i++)
                resSort.and(sortParams.get(i));

            return resSort;
        }
    }
}
