package com.atlassian.platform.pc24363u202220783.requests.domain.model.entities;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.SystemNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * SystemName entity
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
public class SystemName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private SystemNames name;

    public SystemName(SystemNames name) {
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
    public static SystemName getDefaultSystemName() {
        return new SystemName(SystemNames.JIRA);
    }

    /**
     * Get the role from its name
     * @param name the name of the role
     * @return the role
     */
    public static SystemName toSystemNameFromName(String name) {
        return new SystemName(SystemNames.valueOf(name));
    }

    /**
     * Validate the role set
     * <p>
     *     This method validates the role set and returns the default role if the set is empty.
     * </p>
     * @param roles the role set
     * @return the role set
     */
    public static List<SystemName> validateSystemNameSet(List<SystemName> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultSystemName());
        }
        return roles;
    }

}

