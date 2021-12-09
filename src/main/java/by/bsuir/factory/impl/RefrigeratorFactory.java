package by.bsuir.factory.impl;

import by.bsuir.entity.Appliance;
import by.bsuir.entity.Refrigerator;
import by.bsuir.entity.criteria.SearchCriteria;
import by.bsuir.factory.AbstractApplianceFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Refrigerator factory
 */

public class RefrigeratorFactory extends AbstractApplianceFactory {
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        Refrigerator.RefrigeratorBuilder refrigeratorBuilder = Refrigerator.builder();
        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String xmlValue = nodeList.item(i).getTextContent();

                SearchCriteria.RefrigeratorCriteria refrigeratorCriteria = SearchCriteria
                        .RefrigeratorCriteria
                        .valueOf(nodeList.item(i).getNodeName().toUpperCase());
                if (refrigeratorCriteria.equals(SearchCriteria.RefrigeratorCriteria.OVERALL_CAPACITY)) {
                    refrigeratorBuilder.withOverallCapacity(Integer.parseInt(xmlValue));
                } else if (refrigeratorCriteria.equals(SearchCriteria.RefrigeratorCriteria.HEIGHT)) {
                    refrigeratorBuilder.withHeight(Integer.parseInt(xmlValue));
                } else if (refrigeratorCriteria.equals(SearchCriteria.RefrigeratorCriteria.WEIGHT)){
                    refrigeratorBuilder.withWeight(Integer.parseInt(xmlValue));
                } else if (refrigeratorCriteria.equals(SearchCriteria.RefrigeratorCriteria.WIDTH)) {
                    refrigeratorBuilder.withWidth(Integer.parseInt(xmlValue));
                } else if (refrigeratorCriteria.equals(SearchCriteria.RefrigeratorCriteria.COST)) {
                    refrigeratorBuilder.withCost(Integer.parseInt(xmlValue));
                }
            }
        }
        return refrigeratorBuilder.build();
    }
}
