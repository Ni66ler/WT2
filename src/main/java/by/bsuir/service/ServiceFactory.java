package by.bsuir.service;

import by.bsuir.service.impl.ApplianceServiceImpl;

/**
 * Factory for all {@link ApplianceService}
 */

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private static final ApplianceService applianceService = new ApplianceServiceImpl();

    private ServiceFactory() {
    }

    /**
     * Gets instance of {@link ServiceFactory}
     *
     * @return instance of {@link ServiceFactory}
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    /**
     * Gets instance of {@link ApplianceService}
     *
     * @return instance of {@link ApplianceService}
     */
    public ApplianceService getApplianceService() {
        return applianceService;
    }
}
