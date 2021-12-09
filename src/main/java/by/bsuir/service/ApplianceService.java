package by.bsuir.service;

import by.bsuir.entity.Appliance;
import by.bsuir.entity.criteria.ApplianceCriteria;

/**
 * The interface of appliance service.
 */

public interface ApplianceService {

    /**
     * Find all appliances that matched criteria.
     *
     * @param applianceCriteria criteria of appliance
     * @return all matched appliances
     */
    Appliance[] findByCriteria(ApplianceCriteria applianceCriteria);
}
