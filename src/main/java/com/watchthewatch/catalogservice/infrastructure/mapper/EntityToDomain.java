package com.watchthewatch.catalogservice.infrastructure.mapper;

import com.watchthewatch.catalogservice.infrastructure.model.Watch;

public class EntityToDomain {

    public com.watchthewatch.catalogservice.domain.model.Watch entityWatchToDomainWatch(Watch watch) {
        if (watch == null) {
            return null;
        }

        throw new UnsupportedOperationException("Not implemented yet");

//        com.watchthewatch.catalogservice.domain.model.Watch domainWatch =
//                new com.watchthewatch.catalogservice.domain.model.Watch(
//                        watch.getWatchId(),
//                        watch.getWatchName(),
//                        watch.getUnitPrice(),
//                        )
    }
}
