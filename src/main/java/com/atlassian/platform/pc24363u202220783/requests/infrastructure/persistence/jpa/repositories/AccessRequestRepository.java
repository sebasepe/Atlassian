package com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.RequestStatus;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.SystemName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * AccessRequest Repository
 */
@Repository
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    /**
     * Check if an AccessRequest exists by status and the requested system
     *
     * @param status the status of the access request
     * @param requestedSystem the name of the system requested to be accessed on the access request
     * @return true if there's already an access request with the provided status for the indicated system
     */
    boolean existsByStatusAndRequestedSystem(
            RequestStatus status,
            SystemName requestedSystem
    );
}


