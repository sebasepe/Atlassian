package com.atlassian.platform.pc24363u202220783.requests.domain.model.aggregates;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.AccessLevel;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.RequestStatus;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.entities.SystemName;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.EmployeeId;
import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.Justification;
import com.atlassian.platform.pc24363u202220783.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.atlassian.platform.pc24363u202220783.shared.domain.model.valueobjects.DateRange;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Profile AccessRequest Root
 */
@Entity
@NoArgsConstructor
public class AccessRequest extends AuditableAbstractAggregateRoot<AccessRequest> {

    @Getter
    @Embedded
    private EmployeeId employeeId;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "requested_system_id", nullable = false, unique = false)
    private SystemName requestedSystem;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "access_level_id", nullable = false, unique = false)
    private AccessLevel accessLevel;

    @Getter
    @Embedded
    private Justification justification;

    @Getter
    @Embedded
    private DateRange accessPeriod;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "status_id", nullable = false, unique = false)
    private RequestStatus status;

    @Getter
    private LocalDateTime requestedAt;

    /**
     * Constructor from the CreateAccessRequestCommand
     * @param command create access request command
     */
    public AccessRequest(
            CreateAccessRequestCommand command
            ) {
        this.employeeId = new EmployeeId(command.employeeId());
        this.justification = new Justification(command.justification());
        this.accessPeriod = new DateRange(command.startDate(), command.endDate());
        this.requestedAt = LocalDateTime.now();
    }

    public void AssignSystemName(SystemName requestedSystem) {
        this.requestedSystem = requestedSystem;
    }

    public void AssignAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public void AssignRequestStatus(RequestStatus status) {
        this.status = status;
    }
}
