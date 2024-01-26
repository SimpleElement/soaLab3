package org.example.soa_lab3_LabService.ws.lab.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.math.NumberUtils;
import org.example.soa_lab3_LabService.common.util.ConstraintUtil;
import org.example.soa_lab3_LabService.model.enm.ColorEnum;
import org.example.soa_lab3_LabService.model.enm.CountryEnum;
import org.example.soa_lab3_LabService.model.enm.DifficultyEnum;
import org.example.soa_lab3_LabService.ws.lab.dto.LabDto;
import org.example.soa_lab3_LabService.ws.lab.validation.constraint.LabDtoConstraint;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Objects;

public class LabDtoValidator implements ConstraintValidator<LabDtoConstraint, LabDto> {

    @Override
    public boolean isValid(LabDto labDto, ConstraintValidatorContext context) {
        boolean res = true;

        res = labDtoValidation(labDto, context);

        if (Objects.nonNull(labDto.getCoordinates()))
            res = coordinatesDtoValidation(labDto, context) && res;

        if (Objects.nonNull(labDto.getAuthor())) {
            res = personDtoValidation(labDto, context) && res;

            if (Objects.nonNull(labDto.getAuthor().getLocation()))
                res = personLocationDtoValidation(labDto, context) && res;
        }
        return res;
    }

    private boolean labDtoValidation(LabDto labDto, ConstraintValidatorContext context) {
        boolean res = true;

        // Null constraints
        if (Objects.isNull(labDto.getName()) || labDto.getName().trim().equals(""))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Name не может быть не может быть пустым");

        if (!(Objects.isNull(labDto.getName()) || labDto.getName().trim().equals("")) && labDto.getName().length() > 45)
            res = ConstraintUtil.addConstraintViolation(context, "Поле Name не может быть не может быть больше 45 символа");

        if (Objects.isNull(labDto.getMinimalPoint()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле MinimalPoint не может быть пустым");
        else {
            try {
                Integer.parseInt(labDto.getMinimalPoint());

                if (NumberUtils.isCreatable(labDto.getMinimalPoint())) {
                    if (Integer.parseInt(labDto.getMinimalPoint()) <= 0)
                        res = ConstraintUtil.addConstraintViolation(context, "Значение поля MinimalPoint должно быть больше 0");
                }
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле MinimalPoint не соответствует типу Integer");
            }
        }

        if (Objects.isNull(labDto.getDifficulty()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Difficulty не может быть пустым");
        else {
            boolean isCorrect = false;

            for (String enm: Arrays.stream(DifficultyEnum.values()).map(Enum::name).toArray(String[]::new)) {
                if (labDto.getDifficulty().equals(enm))
                    isCorrect = true;
            }
            if (!isCorrect)
                res = ConstraintUtil.addConstraintViolation(context, "Значение поля Difficulty выбрано некорректно");
        }

        if (Objects.isNull(labDto.getCoordinates()))
            res = ConstraintUtil.addConstraintViolation(context, "Объект coordinates не может быть null");

        if (Objects.isNull(labDto.getAuthor()))
            res = ConstraintUtil.addConstraintViolation(context, "Объект author не может быть null");

        return res;
    }

    private boolean coordinatesDtoValidation(LabDto labDto, ConstraintValidatorContext context) {
        boolean res = true;

        if (Objects.nonNull(labDto.getCoordinates().getX())) {
            try {
                Long.parseLong(labDto.getCoordinates().getX());
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле Coordinates -> X не соответствует типу Long");
            }
        }

        if (Objects.isNull(labDto.getCoordinates().getY()))
            res = ConstraintUtil.addConstraintViolation(context, "Значение поля Coordinates -> Y не может быть пустым");
        else {
            try {
                Double.parseDouble(labDto.getCoordinates().getY());
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле Coordinates -> Y не соответствует типу Double");
            }

            if (NumberUtils.isCreatable(labDto.getCoordinates().getY())) {
                if (Double.parseDouble(labDto.getCoordinates().getY()) > 395)
                    res = ConstraintUtil.addConstraintViolation(context, "Максимальное значение поля Coordinates -> Y 395");
            }
        }

        return res;
    }

    private boolean personDtoValidation(LabDto labDto, ConstraintValidatorContext context) {
        boolean res = true;

        if (Objects.isNull(labDto.getAuthor().getName()) || labDto.getAuthor().getName().trim().equals(""))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Name не может быть пустым");

        if (!(Objects.isNull(labDto.getAuthor().getName()) || labDto.getAuthor().getName().trim().equals("")) && labDto.getAuthor().getName().length() > 45)
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Name не может быть больше 45 символа");

        if (Objects.isNull(labDto.getAuthor().getBirthday()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Birthday не может быть пустым");
        else {
            try {
                LocalDateTime.parse(labDto.getAuthor().getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Birthday введено некорркетно");
            }
        }

        if (Objects.isNull(labDto.getAuthor().getEyeColor()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> EyeColor не может быть пустым");
        else {
            boolean isCorrect = false;

            for (String enm: Arrays.stream(ColorEnum.values()).map(Enum::name).toArray(String[]::new)) {
                if (labDto.getAuthor().getEyeColor().equals(enm))
                    isCorrect = true;
            }
            if (!isCorrect)
                res = ConstraintUtil.addConstraintViolation(context, "Значение поля Author -> EyeColor выбрано некорректно");
        }

        if (Objects.isNull(labDto.getAuthor().getHairColor()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> HairColor не может быть пустым");
        else {
            boolean isCorrect = false;

            for (String enm: Arrays.stream(ColorEnum.values()).map(Enum::name).toArray(String[]::new)) {
                if (labDto.getAuthor().getHairColor().equals(enm))
                    isCorrect = true;
            }
            if (!isCorrect)
                res = ConstraintUtil.addConstraintViolation(context, "Значение поля Author -> HairColor выбрано некорректно");
        }

        if (Objects.isNull(labDto.getAuthor().getNationality()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Nationality не может быть пустым");
        else {
            boolean isCorrect = false;

            for (String enm: Arrays.stream(CountryEnum.values()).map(Enum::name).toArray(String[]::new)) {
                if (labDto.getAuthor().getNationality().equals(enm))
                    isCorrect = true;
            }
            if (!isCorrect)
                res = ConstraintUtil.addConstraintViolation(context, "Значение поля Author -> Nationality выбрано некорректно");
        }

        if (Objects.isNull(labDto.getAuthor().getLocation()))
            res = ConstraintUtil.addConstraintViolation(context, "Объект Author -> Location не может быть null");

        return res;
    }

    private boolean personLocationDtoValidation(LabDto labDto, ConstraintValidatorContext context) {
        boolean res = true;

        if (Objects.isNull(labDto.getAuthor().getLocation().getName()) || labDto.getAuthor().getLocation().getName().trim().equals(""))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Location -> Name не может быть пустым");

        if (!(Objects.isNull(labDto.getAuthor().getLocation().getName()) || labDto.getAuthor().getLocation().getName().trim().equals("")) && labDto.getAuthor().getLocation().getName().length() > 254)
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Location -> Name не может быть больше 254 символа");

        if (Objects.isNull(labDto.getAuthor().getLocation().getX()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Location -> X не может быть пустым");
        else {
            try {
                Float.parseFloat(labDto.getAuthor().getLocation().getX());
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> Location -> X не соответствует типу Float");
            }
        }

        if (Objects.isNull(labDto.getAuthor().getLocation().getY()))
            res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> location -> Y не может быть пустым");
        else {
            try {
                Double.parseDouble(labDto.getAuthor().getLocation().getY());
            } catch (Exception e) {
                res = ConstraintUtil.addConstraintViolation(context, "Поле Author -> location -> Y не соответствует типу Double");
            }
        }

        return res;
    }
}
