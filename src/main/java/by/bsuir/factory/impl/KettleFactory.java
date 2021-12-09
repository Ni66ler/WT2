package by.bsuir.factory.impl;

import by.bsuir.entity.Appliance;
import by.bsuir.entity.Kettle;
import by.bsuir.entity.Material;
import by.bsuir.entity.criteria.SearchCriteria;
import by.bsuir.factory.AbstractApplianceFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Kettle factory
 */
public class KettleFactory extends AbstractApplianceFactory {
    @Override
    public Appliance createAppliance(NodeList nodeList) {
        Kettle.KettleBuilder kettleBuilder = Kettle.builder();
        for (int i = 0; i < nodeList.getLength(); i++) {

            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                String xmlValue = nodeList.item(i).getTextContent();

                SearchCriteria.KettleCriteria kettleCriteria = SearchCriteria
                        .KettleCriteria
                        .valueOf(nodeList.item(i).getNodeName().toUpperCase());

                if (kettleCriteria.equals(SearchCriteria.KettleCriteria.POWER_CONSUMPTION)) {
                    kettleBuilder.withPowerConsumption(Integer.parseInt(xmlValue));
                } else if (kettleCriteria.equals(SearchCriteria.KettleCriteria.MATERIAL)) {
                    kettleBuilder.withMaterial(Material.valueOf(xmlValue));
                } else if (kettleCriteria.equals(SearchCriteria.KettleCriteria.VOLUME)){
                    kettleBuilder.withVolume(Integer.parseInt(xmlValue));
                } else if (kettleCriteria.equals(SearchCriteria.KettleCriteria.COST)) {
                    kettleBuilder.withCost(Integer.parseInt(xmlValue));
                }
            }
        }
        return kettleBuilder.build();
    }
}
