package com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.RequestStatus;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.RequestStatuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the RequestStatus entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface RequestStatusRepository extends JpaRepository<RequestStatus, Long> {

    /**
     * This method is responsible for finding the requestStatus by name.
     * @param name The requestStatus name.
     * @return The requestStatus object.
     */
    Optional<RequestStatus> findByName(RequestStatuses name);

    /**
     * This method is responsible for checking if the requestStatus exists by name.
     * @param name The requestStatus name.
     * @return True if the requestStatus exists, false otherwise.
     */
    boolean existsByName(RequestStatuses name);

}


