package com.atlassian.platform.pc24363u202220783.requests.application.internal.commandservices;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.AccessLevel;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.RequestStatus;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.SystemName;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.AccessLevels;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.RequestStatuses;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.SystemNames;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.AccessRequestCommandService;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.AccessLevelRepository;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.AccessRequestRepository;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.RequestStatusRepository;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.SystemNameRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * AccessRequest Command Service Implementation
 */
@Service
public class AccessRequestCommandServiceImpl implements AccessRequestCommandService {
    private final AccessRequestRepository accessRequestRepository;
    private final AccessLevelRepository accessLevelRepository;
    private final SystemNameRepository systemNameRepository;
    private final RequestStatusRepository requestStatusRepository;

    /**
     * Constructor
     *
     * @param accessRequestRepository The {@link AccessRequestRepository} instance
     */
    public AccessRequestCommandServiceImpl(
            AccessRequestRepository accessRequestRepository,
            AccessLevelRepository accessLevelRepository,
            SystemNameRepository systemNameRepository,
            RequestStatusRepository requestStatusRepository
            ) {
        this.accessRequestRepository = accessRequestRepository;
        this.accessLevelRepository = accessLevelRepository;
        this.systemNameRepository = systemNameRepository;
        this.requestStatusRepository = requestStatusRepository;
    }

    // inherited javadoc
    @Override
    public Optional<AccessRequest> handle(CreateAccessRequestCommand command) {
        // Loads the default request status pending
        RequestStatus pendingStatus = this.requestStatusRepository.findByName(
                RequestStatuses.PENDING
        ).orElseThrow(()-> new IllegalArgumentException("Failed to load the PENDING status from the database."));

        SystemName systemName = this.systemNameRepository.findByName(
                SystemNames.valueOf(command.systemName())
        ).orElseThrow(()-> new IllegalArgumentException("The requested system with the name " + command.systemName() + " does not exist."));

        // Validates if the is a PENDING Access Request for the indicated System
        if(this.accessRequestRepository.existsByStatusAndRequestedSystem(
                pendingStatus, systemName
        )) throw new IllegalArgumentException("There is a PENDING Access Request for the " +  command.systemName() + " system already.");

        AccessLevel accessLevel = this.accessLevelRepository.findByName(
                AccessLevels.valueOf(command.accessLevel())
        ).orElseThrow(()-> new IllegalArgumentException("The requested access level " + command.accessLevel() + " does not exist."));

        var accessRequest = new AccessRequest(
                command
        );

        accessRequest.AssignAccessLevel(accessLevel);
        accessRequest.AssignRequestStatus(pendingStatus);
        accessRequest.AssignSystemName(systemName);

        accessRequestRepository.save(accessRequest);

        return Optional.of(accessRequest);
    }
}


