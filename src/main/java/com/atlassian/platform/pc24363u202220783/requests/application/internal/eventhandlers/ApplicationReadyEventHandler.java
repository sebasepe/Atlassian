package com.atlassian.platform.pc24363u202220783.requests.application.internal.eventhandlers;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedAccessLevelsCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedRequestStatusesCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.SeedSystemNamesCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.AccessLevelCommandService;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.RequestStatusCommandService;
import com.atlassian.platform.pc24363u202220783.requests.domain.services.SystemNameCommandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 */
@Service
public class ApplicationReadyEventHandler {
    private final SystemNameCommandService systemNameCommandService;
    private final RequestStatusCommandService requestStatusCommandService;
    private final AccessLevelCommandService accessLevelCommandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyEventHandler.class);

    public ApplicationReadyEventHandler(SystemNameCommandService systemNameCommandService,
                                        RequestStatusCommandService requestStatusCommandService,
                                        AccessLevelCommandService accessLevelCommandService) {
        this.systemNameCommandService = systemNameCommandService;
        this.requestStatusCommandService = requestStatusCommandService;
        this.accessLevelCommandService = accessLevelCommandService;
    }

    /**
     * Handle the ApplicationReadyEvent
     * This method is used to seed the systemNames
     * @param event the ApplicationReadyEvent the event to handle
     */
    @EventListener
    public void on(ApplicationReadyEvent event) {
        var applicationName = event.getApplicationContext().getId();
        LOGGER.info("Starting to verify if systemNames seeding is needed for {} at {}", applicationName, currentTimestamp());

        systemNameCommandService.handle(new SeedSystemNamesCommand());
        requestStatusCommandService.handle(new SeedRequestStatusesCommand());
        accessLevelCommandService.handle(new SeedAccessLevelsCommand());

        LOGGER.info("SystemNames seeding verification finished for {} at {}", applicationName, currentTimestamp());
    }

    private Timestamp currentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
}


