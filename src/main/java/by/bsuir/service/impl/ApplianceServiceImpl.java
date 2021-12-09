package by.bsuir.service.impl;

import by.bsuir.dao.DaoFactory;
import by.bsuir.entity.Appliance;
import by.bsuir.entity.criteria.ApplianceCriteria;
import by.bsuir.service.ApplianceService;
import by.bsuir.service.validation.Validator;

/**
 * The type Appliance service.
 */

public class ApplianceServiceImpl implements ApplianceService {
    @Override
    public Appliance[] findByCriteria(ApplianceCriteria applianceCriteria) {
        if (!Validator.isCriteriaValid(applianceCriteria)) {
            throw new IllegalArgumentException("Criteria is not valid");
        }

        return DaoFactory.getInstance().getApplianceDAO().find(applianceCriteria);
    }
}
