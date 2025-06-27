package com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.SystemName;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.SystemNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the SystemName entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface SystemNameRepository extends JpaRepository<SystemName, Long> {

    /**
     * This method is responsible for finding the systemName by name.
     * @param name The systemName name.
     * @return The systemName object.
     */
    Optional<SystemName> findByName(SystemNames name);

    /**
     * This method is responsible for checking if the systemName exists by name.
     * @param name The systemName name.
     * @return True if the systemName exists, false otherwise.
     */
    boolean existsByName(SystemNames name);

}

