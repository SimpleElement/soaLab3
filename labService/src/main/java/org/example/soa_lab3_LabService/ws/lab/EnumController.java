package org.example.soa_lab3_LabService.ws.lab;

import lombok.RequiredArgsConstructor;
import org.example.soa_lab3_LabService.model.enm.ColorEnum;
import org.example.soa_lab3_LabService.model.enm.CountryEnum;
import org.example.soa_lab3_LabService.model.enm.DifficultyEnum;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/lab/enum")
@RequiredArgsConstructor
public class EnumController {

    @GetMapping("/color")
    public List<String> getColor() {
        return Arrays.stream(ColorEnum.values()).map(Enum::name).collect(Collectors.toList());
    }

    @GetMapping("/country")
    public List<String> getCountry() {
        return Arrays.stream(CountryEnum.values()).map(Enum::name).collect(Collectors.toList());
    }

    @GetMapping("/difficulty")
    public List<String> getDifficulty() {
        return Arrays.stream(DifficultyEnum.values()).map(Enum::name).collect(Collectors.toList());
    }
}
