package by.bsuir.factory;

import by.bsuir.entity.criteria.ApplianceCriteria;
import by.bsuir.factory.impl.KettleFactory;
import by.bsuir.factory.impl.LaptopFactory;
import by.bsuir.factory.impl.RefrigeratorFactory;
import by.bsuir.factory.impl.VacuumCleanerFactory;
import org.w3c.dom.NodeList;
import by.bsuir.entity.Appliance;

/**
 * Abstract factory for all {@link Appliance}
 */

public abstract class AbstractApplianceFactory {

    /**
     * Create new appliance
     *
     * @param nodeList the node list
     * @return new appliance
     */

    public abstract Appliance createAppliance(NodeList nodeList);

    /**
     * Gets appliance factory by appliance name.
     *
     * @param applianceName name of appliance
     * @return factory of new appliance
     */

    public static AbstractApplianceFactory getFactory(String applianceName) {
        AbstractApplianceFactory result;
        switch (applianceName) {
            case "refrigerator": {
                result = new RefrigeratorFactory();
                break;
            }
            case "laptop" :{
                result = new LaptopFactory();
                break;
            }
            case "kettle" :{
                result = new KettleFactory();
                break;
            }
            case "vacuumCleaner" : {
                result = new VacuumCleanerFactory();
                break;
            }
            default : throw new IllegalArgumentException("No such appliance creator exists");
        };
        return result;
    }
}
