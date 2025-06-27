package com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * EmployeeId value object
 * @summary
 * This value object represents the unique identifier of a employee.
 * The employeeId must be greater than 0. It throws an IllegalArgumentException if the employeeId is null or less than or equal to 0.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record EmployeeId(Long employeeId) {

    public EmployeeId {
        if (employeeId == null || employeeId < 0) {
            throw new IllegalArgumentException("EmployeeId cannot be null or less than or equal to 0");
        }
    }
}


