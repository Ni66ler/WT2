package by.bsuir.util;

import by.bsuir.entity.Appliance;
import lombok.extern.log4j.Log4j2;

/**
 * Util class for print appliances info
 */

@Log4j2
public final class PrintApplianceInfo {

    private PrintApplianceInfo() {
    }

    /**
     * Print info about appliances
     *
     * @param appliances appliances
     */

    public static void printInfo(Appliance... appliances) {
        if (appliances == null) {
            log.error("Appliances may not be null");
        } else if (appliances.length == 0) {
            log.info("No appliances found");
        } else {
            for (Appliance appliance : appliances) {
                System.out.println(appliance);
            }
        }
    }
}
