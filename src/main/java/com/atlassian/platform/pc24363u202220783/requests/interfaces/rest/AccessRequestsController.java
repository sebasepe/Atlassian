package com.atlassian.platform.pc24363u202220783.requests.interfaces.rest;

import com.atlassian.platform.pc24363u202220783.requests.domain.services.AccessRequestCommandService;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources.AccessRequestResource;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.resources.CreateAccessRequestResource;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.transform.AccessRequestResourceFromEntityAssembler;
import com.atlassian.platform.pc24363u202220783.requests.interfaces.rest.transform.CreateAccessRequestCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AccessRequestsController
 */
@RestController
@RequestMapping(value = "/api/v1/employees", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "AccessRequests", description = "Available AccessRequest Endpoints")
public class AccessRequestsController {
    private final AccessRequestCommandService accessRequestCommandService;

    /**
     * Constructor
     * @param accessRequestCommandService The {@link AccessRequestCommandService} instance
     */
    public AccessRequestsController(AccessRequestCommandService accessRequestCommandService) {
        this.accessRequestCommandService = accessRequestCommandService;
    }

    /**
     * Create a new accessRequest
     * @param resource The {@link CreateAccessRequestResource} instance
     * @return A {@link AccessRequestResource} resource for the created accessRequest, or a bad request response if the accessRequest could not be created.
     */
    @PostMapping("/{employeeId}/access-requests")
    @Operation(summary = "Create a new accessRequest")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "AccessRequest created"),
            @ApiResponse(responseCode = "400", description = "Bad request")})
    public ResponseEntity<AccessRequestResource> createAccessRequest(
            @PathVariable Long employeeId,
            @RequestBody CreateAccessRequestResource resource
    ) {
        var createAccessRequestCommand = CreateAccessRequestCommandFromResourceAssembler.toCommandFromResource(resource, employeeId);

        var accessRequest = accessRequestCommandService.handle(createAccessRequestCommand);

        if (accessRequest.isEmpty()) return ResponseEntity.badRequest().build();

        var createdAccessRequest = accessRequest.get();
        var accessRequestResource = AccessRequestResourceFromEntityAssembler.toResourceFromEntity(createdAccessRequest);
        return new ResponseEntity<>(accessRequestResource, HttpStatus.CREATED);
    }
}


