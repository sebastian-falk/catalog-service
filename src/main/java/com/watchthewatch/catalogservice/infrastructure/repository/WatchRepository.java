package com.watchthewatch.catalogservice.infrastructure.repository;

import com.watchthewatch.catalogservice.infrastructure.model.Watch;
import org.springframework.data.repository.CrudRepository;

public interface WatchRepository extends CrudRepository<Watch, String> {

}
