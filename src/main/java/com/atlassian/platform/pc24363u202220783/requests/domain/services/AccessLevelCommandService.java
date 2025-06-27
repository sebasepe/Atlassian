package com.atlassian.platform.pc24363u202220783.requests.domain.services;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedAccessLevelsCommand;

/**
 * AccessLevel command service
 * <p>
 *     This interface represents the service to handle accessLevel commands.
 * </p>
 */
public interface AccessLevelCommandService {
    /**
     * Handle seed accessLevels command
     * @param command the {@link SeedAccessLevelsCommand} command
     *
     */
    void handle(SeedAccessLevelsCommand command);
}


