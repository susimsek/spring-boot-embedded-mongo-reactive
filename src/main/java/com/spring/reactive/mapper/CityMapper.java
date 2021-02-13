package com.spring.reactive.mapper;

import com.spring.reactive.domain.City;
import com.spring.reactive.model.read.CityReadDto;
import com.spring.reactive.model.write.CityWriteDto;
import org.mapstruct.Mapper;

@Mapper
public interface CityMapper {

    CityReadDto cityToCityReadDto(City city);
    City cityWriteDtoToCity(CityWriteDto cityWriteDto);

}
