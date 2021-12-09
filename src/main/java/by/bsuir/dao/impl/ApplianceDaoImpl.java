package by.bsuir.dao.impl;

import by.bsuir.dao.ApplianceDao;
import by.bsuir.entity.Appliance;
import by.bsuir.entity.criteria.ApplianceCriteria;
import by.bsuir.factory.AbstractApplianceFactory;
import lombok.extern.log4j.Log4j2;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link ApplianceDao} for parse xml file
 */

@Log4j2
public class ApplianceDaoImpl implements ApplianceDao {
    private static final String RESOURCE_APPLIANCES_FILE_NAME = "appliances.xml";

    @Override
    public Appliance[] find(ApplianceCriteria applianceCriteria) {
        List<Appliance> applianceList = new ArrayList<>();

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(getClass()
                    .getClassLoader()
                    .getResource(RESOURCE_APPLIANCES_FILE_NAME)
                    .getFile()
            );

            NodeList appliances = doc.getDocumentElement().getChildNodes();
            for (int i = 0; i < appliances.getLength(); i++) {
                Node applianceNode = appliances.item(i);
                if (applianceNode.getNodeType() == Node.ELEMENT_NODE) {
                    AbstractApplianceFactory applianceFactory = AbstractApplianceFactory.getFactory(applianceNode.getNodeName());
                    if (applianceCriteria.getApplianceName() == null
                            || applianceCriteria.getApplianceName().equals(applianceNode.getNodeName())) {
                        Appliance appliance = applianceFactory.createAppliance(applianceNode.getChildNodes());
                        if (applianceCriteria.getCriteria()
                                .entrySet()
                                .stream()
                                .allMatch(entry -> appliance.isApplianceMatchedCriteria(entry.getKey(), entry.getValue()))) {
                            applianceList.add(appliance);
                        }
                    }
                }
            }

        }catch (IllegalArgumentException e) {
            log.error("Cannot define search criteria field name. Error message: {}", e.getMessage());

            return null;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            log.error("Cannot parse appliances file. Error message: {}", e.getMessage());

            return null;
        }
        return applianceList.toArray(new Appliance[0]);
    }
}
