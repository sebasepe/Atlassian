package com.atlassian.platform.pc24363u202220783.requests.domain.services;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedSystemNamesCommand;

/**
 * SystemName command service
 * <p>
 *     This interface represents the service to handle systemName commands.
 * </p>
 */
public interface SystemNameCommandService {
    /**
     * Handle seed systemNames command
     * @param command the {@link SeedSystemNamesCommand} command
     *
     */
    void handle(SeedSystemNamesCommand command);
}


