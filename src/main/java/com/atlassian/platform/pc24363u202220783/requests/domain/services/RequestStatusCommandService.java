package com.atlassian.platform.pc24363u202220783.requests.domain.services;


import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedRequestStatusesCommand;

/**
 * RequestStatus command service
 * <p>
 *     This interface represents the service to handle requestStatus commands.
 * </p>
 */
public interface RequestStatusCommandService {
    /**
     * Handle seed requestStatuses command
     * @param command the {@link SeedRequestStatusesCommand} command
     *
     */
    void handle(SeedRequestStatusesCommand command);
}


