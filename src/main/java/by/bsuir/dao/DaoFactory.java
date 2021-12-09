package by.bsuir.dao;

import by.bsuir.dao.impl.ApplianceDaoImpl;

/**
 * Factory class for {@link ApplianceDao}
 */

public final class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private final ApplianceDao applianceDAO = new ApplianceDaoImpl();

    private DaoFactory() {
    }

    /**
     * Gets instance of {@link ApplianceDao}
     *
     * @return instance of appliance dao
     */
    public ApplianceDao getApplianceDAO() {
        return applianceDAO;
    }

    /**
     * Gets instance of {@link DaoFactory}
     *
     * @return instance of dao factory
     */
    public static DaoFactory getInstance() {
        return instance;
    }
}
