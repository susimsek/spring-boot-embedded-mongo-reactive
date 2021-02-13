package com.spring.reactive.service;

import com.spring.reactive.model.read.CityReadDto;
import com.spring.reactive.model.write.CityWriteDto;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CityService {

    Mono<CityReadDto> createCity(CityWriteDto cityWriteDto);
    Flux<CityReadDto> listCities(Pageable page);
    Mono<CityReadDto> updateCity(String id,CityWriteDto cityWriteDto);
    Mono<CityReadDto> getCity(String id);
    Mono<Boolean> deleteCity(String id);
}
