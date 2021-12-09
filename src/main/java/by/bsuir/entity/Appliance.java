package by.bsuir.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Single object of appliance
 */

@Getter
@AllArgsConstructor
@ToString(includeFieldNames = false)
public abstract class Appliance {

    protected final int cost;

    /**
     * Check if the entity matches the criteria
     *
     * @param criteriaField the criteria field name
     * @param value value of criteria
     * @return true if matched
     */
    public abstract boolean isApplianceMatchedCriteria(String criteriaField, Object value);
}
