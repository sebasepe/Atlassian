package com.atlassian.platform.pc24363u202220783.shared.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

/**
 * DateRange Value Object
 */
@Embeddable
public record DateRange(
        LocalDateTime startDate,
        LocalDateTime endDate
) {
    /**
     * Default constructor
     */
    public DateRange() {
        this(null, null);
    }
}
