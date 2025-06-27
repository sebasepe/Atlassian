package com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Justification value object
 * @summary
 * This value object represents the justification for an access request.
 * The justification must be at least 25 characters and max. 500 characters long.
 * @see IllegalArgumentException
 * @since 1.0
 */
@Embeddable
public record Justification(
        @Column(name = "justification") String value
) {
}
