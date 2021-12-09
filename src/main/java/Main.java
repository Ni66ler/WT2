import by.bsuir.entity.Appliance;
import by.bsuir.entity.criteria.ApplianceCriteria;
import by.bsuir.service.ApplianceService;
import by.bsuir.service.ServiceFactory;
import by.bsuir.util.PrintApplianceInfo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Vlad Kostyan
 */

public class Main {

    public static void main(String[] args) {
        Appliance[] appliance;
        ServiceFactory factory = ServiceFactory.getInstance();
        ApplianceService service = factory.getApplianceService();
        ApplianceCriteria allKettlesCriteria = new ApplianceCriteria("kettle");
        appliance = service.findByCriteria(allKettlesCriteria);
        PrintApplianceInfo.printInfo(appliance);
        System.out.println();
        ApplianceCriteria allAppliancesCriteria = new ApplianceCriteria();
        appliance = service.findByCriteria(allAppliancesCriteria);
        PrintApplianceInfo.printInfo(
                Arrays.stream(appliance)
                        .min(Comparator.comparing(Appliance::getCost))
                        .get()
        );
    }
}
