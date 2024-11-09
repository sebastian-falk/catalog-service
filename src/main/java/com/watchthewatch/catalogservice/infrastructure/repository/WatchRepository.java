package com.watchthewatch.catalogservice.infrastructure.repository;

import com.watchthewatch.catalogservice.infrastructure.model.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchRepository extends JpaRepository<Watch, String> {
    List<Watch> findByWatchIdIn(List<String> watchIds);
}
