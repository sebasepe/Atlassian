package com.atlassian.platform.pc24363u202220783.requests.domain.model.entities;

import com.atlassian.platform.pc24363u202220783.requests.domain.model.valueobjects.AccessLevels;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

/**
 * AccessLevel entity
 * <p>
 *     This entity represents the accessLevel of a user in the system.
 *     It is used to define the permissions of a user.
 * </p>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class AccessLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private AccessLevels name;

    public AccessLevel(AccessLevels name) {
        this.name = name;
    }

    /**
     * Get the name of the accessLevel as a string
     * @return the name of the accessLevel as a string
     */
    public String getStringName() {
        return name.name();
    }

    /**
     * Get the default accessLevel
     * @return the default accessLevel
     */
    public static AccessLevel getDefaultAccessLevel() {
        return new AccessLevel(AccessLevels.READ);
    }

    /**
     * Get the accessLevel from its name
     * @param name the name of the accessLevel
     * @return the accessLevel
     */
    public static AccessLevel toAccessLevelFromName(String name) {
        return new AccessLevel(AccessLevels.valueOf(name));
    }

    /**
     * Validate the accessLevel set
     * <p>
     *     This method validates the accessLevel set and returns the default accessLevel if the set is empty.
     * </p>
     * @param accessLevels the accessLevel set
     * @return the accessLevel set
     */
    public static List<AccessLevel> validateAccessLevelSet(List<AccessLevel> accessLevels) {
        if (accessLevels == null || accessLevels.isEmpty()) {
            return List.of(getDefaultAccessLevel());
        }
        return accessLevels;
    }

}


