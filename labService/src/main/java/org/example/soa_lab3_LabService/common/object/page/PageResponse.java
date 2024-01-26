package org.example.soa_lab3_LabService.common.object.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> extends Page {
    private Integer totalPages;
    private Long totalElements;
    private List<T> content;
}
