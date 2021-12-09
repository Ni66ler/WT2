package by.bsuir.factory.impl;

import by.bsuir.entity.Appliance;
import by.bsuir.entity.Laptop;
import by.bsuir.entity.criteria.SearchCriteria;
import by.bsuir.factory.AbstractApplianceFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Laptop factory
 */

public class LaptopFactory extends AbstractApplianceFactory {
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        Laptop.LaptopBuilder laptopBuilder = Laptop.builder();
        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String xmlValue = nodeList.item(i).getTextContent();

                SearchCriteria.LaptopCriteria laptopCriteria = SearchCriteria
                        .LaptopCriteria
                        .valueOf(nodeList.item(i).getNodeName().toUpperCase());
                if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.BATTERY_CAPACITY)) {
                    laptopBuilder.withBatteryCapacity(Integer.parseInt(xmlValue));
                } else if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.OPERATING_SYSTEM)) {
                    laptopBuilder.withOperatingSystem(xmlValue);
                } else if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.RAM)){
                    laptopBuilder.withRam(Integer.parseInt(xmlValue));
                } else if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.SYSTEM_MEMORY)) {
                    laptopBuilder.withSystemMemory(Integer.parseInt(xmlValue));
                } else if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.COST)) {
                    laptopBuilder.withCost(Integer.parseInt(xmlValue));
                }
            }
        }
        return laptopBuilder.build();
    }
}
