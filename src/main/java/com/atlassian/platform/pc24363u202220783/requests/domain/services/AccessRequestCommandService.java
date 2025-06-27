package com.atlassian.platform.pc24363u202220783.requests.domain.services;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.CreateAccessRequestCommand;

import java.util.Optional;

/**
 * AccessRequest Command Service
 */
public interface AccessRequestCommandService {
    /**
     * Handle Create AccessRequest Command
     *
     * @param command The {@link CreateAccessRequestCommand} Command
     * @return A {@link AccessRequest} instance if the command is valid, otherwise empty
     * @throws IllegalArgumentException if the email address already exists
     */
    Optional<AccessRequest> handle(CreateAccessRequestCommand command);
}
