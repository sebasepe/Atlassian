package com.atlassian.platform.pc24363u202220783.requests.domain.model.commands;

import java.time.LocalDateTime;
/**
 * Create Access Request Command
 */
public record CreateAccessRequestCommand(
        Long employeeId,
        String systemName,
        String accessLevel,
        String justification,
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
