package com.atlassian.platform.pc24363u202220783.requests.application.internal.commandservices;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedAccessLevelsCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.AccessLevel;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.AccessLevels;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.AccessLevelCommandService;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.AccessLevelRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link AccessLevelCommandService} to handle {@link SeedAccessLevelsCommand}
 */
@Service
public class AccessLevelCommandServiceImpl implements AccessLevelCommandService {

    private final AccessLevelRepository accessLevelRepository;

    public AccessLevelCommandServiceImpl(AccessLevelRepository accessLevelRepository) {
        this.accessLevelRepository = accessLevelRepository;
    }

    /**
     * This method will handle the {@link SeedAccessLevelsCommand} and will create the accessLevels if not exists
     * @param command {@link SeedAccessLevelsCommand}
     * @see SeedAccessLevelsCommand
     */
    @Override
    public void handle(SeedAccessLevelsCommand command) {
        Arrays.stream(AccessLevels.values()).forEach(accessLevel -> {
            if(!accessLevelRepository.existsByName(accessLevel)) {
                accessLevelRepository.save(new AccessLevel(AccessLevels.valueOf(accessLevel.name())));
            }
        } );
    }
}


