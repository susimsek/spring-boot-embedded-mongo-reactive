package com.spring.reactive.repository;

import com.spring.reactive.domain.City;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CityRepository extends ReactiveMongoRepository<City, String> {
}