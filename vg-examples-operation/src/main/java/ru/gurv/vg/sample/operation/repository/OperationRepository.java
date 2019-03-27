package ru.gurv.vg.sample.operation.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import ru.gurv.vg.sample.operation.domain.Operation;
import ru.gurv.vg.sample.operation.projection.OperationExcerpt;

import java.time.LocalDateTime;

@Repository
@RepositoryRestResource(
        itemResourceRel="operation",
        collectionResourceRel = "operation",
        path = "operation",
        excerptProjection = OperationExcerpt.class)
@CrossOrigin(origins = "http://localhost:4200")
public interface OperationRepository extends PagingAndSortingRepository<Operation, Long> {

    @Query("SELECT COUNT(o) FROM Operation o")
    Long countAll();

    @Query("SELECT COUNT(o) FROM Operation o WHERE state = :state")
    Long countByState(@Param("state") Integer state);

    @Query("SELECT COUNT(o) FROM Operation o WHERE o.ts <= :ts")
    Long countByTimestampLessThanEqual(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("ts") LocalDateTime timestamp);

    @Query("SELECT COUNT(o) FROM Operation o WHERE o.ts <= :ts and state = :state")
    Long countByTimestampLessThanEqualAndState(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("ts") LocalDateTime timestamp,
            @Param("state") Integer state);
}
