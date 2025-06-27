package com.atlassian.platform.pc24363u202220783.requests.application.internal.commandservices;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedRequestStatusesCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.RequestStatus;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.RequestStatuses;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.RequestStatusCommandService;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.RequestStatusRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link RequestStatusCommandService} to handle {@link SeedRequestStatusesCommand}
 */
@Service
public class RequestStatusCommandServiceImpl implements RequestStatusCommandService {

    private final RequestStatusRepository requestStatusRepository;

    public RequestStatusCommandServiceImpl(RequestStatusRepository requestStatusRepository) {
        this.requestStatusRepository = requestStatusRepository;
    }

    /**
     * This method will handle the {@link SeedRequestStatusesCommand} and will create the requestStatuses if not exists
     * @param command {@link SeedRequestStatusesCommand}
     * @see SeedRequestStatusesCommand
     */
    @Override
    public void handle(SeedRequestStatusesCommand command) {
        Arrays.stream(RequestStatuses.values()).forEach(requestStatus -> {
            if(!requestStatusRepository.existsByName(requestStatus)) {
                requestStatusRepository.save(new RequestStatus(RequestStatuses.valueOf(requestStatus.name())));
            }
        } );
    }
}

