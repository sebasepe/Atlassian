package com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.AccessLevel;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.AccessLevels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This interface is responsible for providing the AccessLevel entity related operations.
 * It extends the JpaRepository interface.
 */
@Repository
public interface AccessLevelRepository extends JpaRepository<AccessLevel, Long> {

    /**
     * This method is responsible for finding the accessLevel by name.
     * @param name The accessLevel name.
     * @return The accessLevel object.
     */
    Optional<AccessLevel> findByName(AccessLevels name);

    /**
     * This method is responsible for checking if the accessLevel exists by name.
     * @param name The accessLevel name.
     * @return True if the accessLevel exists, false otherwise.
     */
    boolean existsByName(AccessLevels name);

}