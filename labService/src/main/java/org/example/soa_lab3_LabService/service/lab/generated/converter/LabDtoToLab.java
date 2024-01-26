package org.example.soa_lab3_LabService.service.lab.generated.converter;

import org.example.soa_lab3_LabService.model.emb.CoordinatesEmb;
import org.example.soa_lab3_LabService.model.emb.LocationEmb;
import org.example.soa_lab3_LabService.model.emb.PersonEmb;
import org.example.soa_lab3_LabService.model.enm.ColorEnum;
import org.example.soa_lab3_LabService.model.enm.CountryEnum;
import org.example.soa_lab3_LabService.model.enm.DifficultyEnum;
import org.example.soa_lab3_LabService.model.entity.LabEntity;

import org.example.soa_lab3_LabService.ws.lab.dto.LabDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class LabDtoToLab implements Converter<LabDto, LabEntity> {

    @Override
    public LabEntity convert(LabDto source) {
        LabEntity res = new LabEntity();
        res.setId(source.getId());
        res.setName(source.getName());
        res.setMinimalPoint(Integer.parseInt(source.getMinimalPoint()));
        res.setDifficulty(Arrays.stream(DifficultyEnum.values()).filter(el -> el.name().equals(source.getDifficulty())).findFirst().orElse(null));

        if (source.getCoordinates() != null) {
            CoordinatesEmb coordinates = new CoordinatesEmb();
            coordinates.setX(Long.parseLong(source.getCoordinates().getX()));
            coordinates.setY(Double.parseDouble(source.getCoordinates().getY()));

            res.setCoordinates(coordinates);
        }

        if (source.getAuthor() != null) {
            PersonEmb author = new PersonEmb();
            author.setName(source.getAuthor().getName());
            author.setBirthday(LocalDateTime.parse(source.getAuthor().getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            author.setEyeColor(Arrays.stream(ColorEnum.values()).filter(el -> el.name().equals(source.getAuthor().getEyeColor())).findFirst().orElse(null));
            author.setHairColor(Arrays.stream(ColorEnum.values()).filter(el -> el.name().equals(source.getAuthor().getHairColor())).findFirst().orElse(null));
            author.setNationality(Arrays.stream(CountryEnum.values()).filter(el -> el.name().equals(source.getAuthor().getNationality())).findFirst().orElse(null));

            if (source.getAuthor().getLocation() != null) {
                LocationEmb location = new LocationEmb();
                location.setName(source.getAuthor().getLocation().getName());
                location.setX(Float.parseFloat(source.getAuthor().getLocation().getX()));
                location.setY(Double.parseDouble(source.getAuthor().getLocation().getY()));

                author.setLocation(location);
            }
            res.setAuthor(author);
        }

        return res;
    }
}
