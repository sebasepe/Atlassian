package com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources;

import java.time.LocalDateTime;

/**
 * Resource for creating an access request.
 */
public record CreateAccessRequestResource(
        String systemName,
        String accessLevel,
        String justification,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
    /**
     * Validates the resource.
     *
     * @throws IllegalArgumentException if the resource is invalid.
     */
    public CreateAccessRequestResource {
        if (systemName == null || systemName.isBlank()) throw new IllegalArgumentException("System name is required");
        if (accessLevel == null || accessLevel.isBlank()) throw new IllegalArgumentException("Access Level is required");
        if (justification == null || justification.isBlank()) throw new IllegalArgumentException("Justification is required");
        if (startDate == null) throw new IllegalArgumentException("Start date is required");
        if (endDate == null) throw new IllegalArgumentException("End date is required");
    }

}
