package com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources;

import java.time.LocalDateTime;

/**
 * Resource for an access request.
 */
public record AccessRequestResource(
        Long employeeId,
        String requestedSystem,
        String accessLevel,
        String justification,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String status,
        LocalDateTime requestedAt
) {
}
