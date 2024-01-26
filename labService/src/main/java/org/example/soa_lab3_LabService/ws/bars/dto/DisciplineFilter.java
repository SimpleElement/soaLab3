package org.example.soa_lab3_LabService.ws.bars.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.soa_lab3_LabService.common.object.page.Page;

@Getter
@Setter
public class DisciplineFilter extends Page {
    private String name;
}
