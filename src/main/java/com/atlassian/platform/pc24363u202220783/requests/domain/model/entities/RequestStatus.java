package com.atlassian.platform.pc24363u202220783.requests.domain.model.entities;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.RequestStatuses;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * RequestStatus entity
 * <p>
 *     This entity represents the role of a user in the system.
 *     It is used to define the permissions of a user.
 * </p>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class RequestStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RequestStatuses name;

    public RequestStatus(RequestStatuses name) {
        this.name = name;
    }

    /**
     * Get the name of the role as a string
     * @return the name of the role as a string
     */
    public String getStringName() {
        return name.name();
    }

    /**
     * Get the default role
     * @return the default role
     */
    public static RequestStatus getDefaultRequestStatus() {
        return new RequestStatus(RequestStatuses.PENDING);
    }

    /**
     * Get the role from its name
     * @param name the name of the role
     * @return the role
     */
    public static RequestStatus toRequestStatusFromName(String name) {
        return new RequestStatus(RequestStatuses.valueOf(name));
    }

    /**
     * Validate the role set
     * <p>
     *     This method validates the role set and returns the default role if the set is empty.
     * </p>
     * @param roles the role set
     * @return the role set
     */
    public static List<RequestStatus> validateRequestStatusSet(List<RequestStatus> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRequestStatus());
        }
        return roles;
    }

}

