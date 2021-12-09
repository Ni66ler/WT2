package by.bsuir.factory.impl;

import by.bsuir.entity.Appliance;
import by.bsuir.entity.Material;
import by.bsuir.entity.VacuumCleaner;
import by.bsuir.entity.criteria.SearchCriteria;
import by.bsuir.factory.AbstractApplianceFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Vacuum cleaner factory
 */

public class VacuumCleanerFactory extends AbstractApplianceFactory {
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        VacuumCleaner.VacuumCleanerBuilder vacuumCleanerBuilder = VacuumCleaner.builder();
        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String xmlValue = nodeList.item(i).getTextContent();

                SearchCriteria.VacuumCleanerCriteria vacuumCleanerCriteria = SearchCriteria
                        .VacuumCleanerCriteria
                        .valueOf(nodeList.item(i).getNodeName().toUpperCase());

                if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.MATERIAL)) {
                    vacuumCleanerBuilder.withMaterial(Material.valueOf(xmlValue));
                } else if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.POWER_CONSUMPTION)) {
                    vacuumCleanerBuilder.withPowerConsumption(Integer.parseInt(xmlValue));
                } else if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.WEIGHT)){
                    vacuumCleanerBuilder.withWeight(Integer.parseInt(xmlValue));
                } else if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.COST)) {
                    vacuumCleanerBuilder.withCost(Integer.parseInt(xmlValue));
                }
            }
        }
        return vacuumCleanerBuilder.build();
    }
}
