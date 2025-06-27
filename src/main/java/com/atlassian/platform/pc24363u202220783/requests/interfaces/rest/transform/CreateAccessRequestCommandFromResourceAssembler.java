package com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.transform;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources.CreateAccessRequestResource;

/**
 * Assembler to convert a CreateAccessRequestResource to a CreateAccessRequestCommand.
 */
public class CreateAccessRequestCommandFromResourceAssembler {
    /**
     * Converts a CreateAccessRequestResource to a CreateAccessRequestCommand.
     * @param resource The {@link CreateAccessRequestResource} resource to convert.
     * @return The {@link CreateAccessRequestCommand} command.
     */
    public static CreateAccessRequestCommand toCommandFromResource(CreateAccessRequestResource resource, Long employeeId) {
        return new CreateAccessRequestCommand(
                employeeId,
                resource.systemName(),
                resource.accessLevel(),
                resource.justification(),
                resource.startDate(),
                resource.endDate()
        );
    }
}


