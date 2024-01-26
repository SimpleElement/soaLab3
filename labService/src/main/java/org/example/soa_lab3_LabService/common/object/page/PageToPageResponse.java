package org.example.soa_lab3_LabService.common.object.page;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageToPageResponse<T> implements Converter<Page<T>, PageResponse<T>> {

    @Override
    public PageResponse<T> convert(Page source) {
        PageResponse<T> res = new PageResponse<>();

        res.setTotalPages(source.getTotalPages());
        res.setPageNumber(source.getNumber());
        res.setPageSize(source.getSize());
        res.setTotalElements(source.getTotalElements());
        return res;
    }
}
