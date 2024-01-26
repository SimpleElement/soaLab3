package org.example.soa_lab3_LabService.service.lab.generated.converter;

import org.example.soa_lab3_LabService.model.entity.LabEntity;

import org.example.soa_lab3_LabService.ws.lab.dto.CoordinatesDto;
import org.example.soa_lab3_LabService.ws.lab.dto.LabDto;
import org.example.soa_lab3_LabService.ws.lab.dto.LocationDto;
import org.example.soa_lab3_LabService.ws.lab.dto.PersonDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class LabToLabDto implements Converter<LabEntity, LabDto> {

    @Override
    public LabDto convert(LabEntity source) {
        LabDto res = new LabDto();
        res.setId(source.getId());
        res.setName(source.getName());
        res.setCreationDate(source.getCreationDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "Z");
        res.setMinimalPoint(source.getMinimalPoint().toString());
        res.setDifficulty(source.getDifficulty() != null ? source.getDifficulty().name() : null);

        if (source.getCoordinates() != null) {
            CoordinatesDto coordinates = new CoordinatesDto();
            coordinates.setX(source.getCoordinates().getX().toString());
            coordinates.setY(source.getCoordinates().getY().toString());

            res.setCoordinates(coordinates);
        }

        if (source.getAuthor() != null) {
            PersonDto author = new PersonDto();
            author.setName(source.getAuthor().getName());
            author.setBirthday(source.getAuthor().getBirthday().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "Z");
            author.setEyeColor(source.getAuthor().getEyeColor() != null ? source.getAuthor().getEyeColor().name() : null);
            author.setHairColor(source.getAuthor().getHairColor() != null ? source.getAuthor().getHairColor().name() : null);
            author.setNationality(source.getAuthor().getNationality() != null ? source.getAuthor().getNationality().name() : null);

            if (source.getAuthor().getLocation() != null) {
                LocationDto location = new LocationDto();
                location.setName(source.getAuthor().getLocation().getName());
                location.setX(source.getAuthor().getLocation().getX().toString());
                location.setY(source.getAuthor().getLocation().getY().toString());

                author.setLocation(location);
            }
            res.setAuthor(author);
        }

        return res;
    }
}
