package com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.transform;


import com.atlassian.platform.pc24363u202220783.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources.AccessRequestResource;

/**
 * Assembler to convert a AccessRequest entity to a AccessRequestResource.
 */
public class AccessRequestResourceFromEntityAssembler {
    /**
     * Converts a AccessRequest entity to a AccessRequestResource.
     * @param entity The {@link AccessRequest} entity to convert.
     * @return The {@link AccessRequestResource} resource.
     */
    public static AccessRequestResource toResourceFromEntity(AccessRequest entity) {
        return new AccessRequestResource(
                entity.getEmployeeId().employeeId(),
                entity.getRequestedSystem().getStringName(),
                entity.getAccessLevel().getStringName(),
                entity.getJustification().value(),
                entity.getAccessPeriod().startDate(),
                entity.getAccessPeriod().endDate(),
                entity.getStatus().getStringName(),
                entity.getRequestedAt()
        );
    }
}
