package com.spring.reactive.service;

import com.spring.reactive.domain.City;
import com.spring.reactive.exception.ResourceNotFoundException;
import com.spring.reactive.mapper.CityMapper;
import com.spring.reactive.model.read.CityReadDto;
import com.spring.reactive.model.write.CityWriteDto;
import com.spring.reactive.repository.CityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    final CityRepository cityRepository;
    final CityMapper cityMapper;
    final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<CityReadDto> createCity(CityWriteDto cityWriteDto) {
        City city = cityMapper.cityWriteDtoToCity(cityWriteDto);
        return cityRepository.insert(city).map(cityMapper::cityToCityReadDto);
    }

    @Override
    public Flux<CityReadDto> listCities(Pageable page) {
        Query query = new Query().with(page);
        return reactiveMongoTemplate.find(query, City.class).map(cityMapper::cityToCityReadDto);
    }

    @Override
    public Mono<CityReadDto> updateCity(String id,CityWriteDto cityWriteDto) {
        return cityRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("City", "id", id)))
                .flatMap(existingCity -> {
                    existingCity.setName(cityWriteDto.getName());
                    existingCity.setPopulation(cityWriteDto.getPopulation());
                    return cityRepository.save(existingCity);
                })
                .map(cityMapper::cityToCityReadDto);
    }

    @Override
    public Mono<CityReadDto> getCity(String id) {
        return cityRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("City", "id", id)))
                .map(cityMapper::cityToCityReadDto);
    }

    @Override
    public Mono<Boolean> deleteCity(String id) {
        return cityRepository.findById(id)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException("City", "id", id)))
                .flatMap(cityRepository::delete)
                .then(Mono.just(true));
    }
}
