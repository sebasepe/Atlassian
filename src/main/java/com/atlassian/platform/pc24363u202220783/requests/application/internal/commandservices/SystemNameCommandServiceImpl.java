package com.atlassian.platform.pc24363u202220783.requests.application.internal.commandservices;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedSystemNamesCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.SystemName;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.SystemNames;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.SystemNameCommandService;
import com.atlassian.platform.pc24363u202220783.requests.infrastructure.persistence.jpa.repositories.SystemNameRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Implementation of {@link SystemNameCommandService} to handle {@link SeedSystemNamesCommand}
 */
@Service
public class SystemNameCommandServiceImpl implements SystemNameCommandService {

    private final SystemNameRepository systemNameRepository;

    public SystemNameCommandServiceImpl(SystemNameRepository systemNameRepository) {
        this.systemNameRepository = systemNameRepository;
    }

    /**
     * This method will handle the {@link SeedSystemNamesCommand} and will create the systemNames if not exists
     * @param command {@link SeedSystemNamesCommand}
     * @see SeedSystemNamesCommand
     */
    @Override
    public void handle(SeedSystemNamesCommand command) {
        Arrays.stream(SystemNames.values()).forEach(systemName -> {
            if(!systemNameRepository.existsByName(systemName)) {
                systemNameRepository.save(new SystemName(SystemNames.valueOf(systemName.name())));
            }
        } );
    }
}


