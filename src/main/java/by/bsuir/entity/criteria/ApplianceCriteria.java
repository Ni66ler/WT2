package by.bsuir.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * The Appliance criteria class encapsulates all criteria.
 */

public class ApplianceCriteria {

    private final Map<String, Object> ALL_CRITERIA = new HashMap<>();
    private String applianceName;

    public ApplianceCriteria(String applianceName) {
        this.applianceName = applianceName;
    }

    public ApplianceCriteria(){
    }

    /**
     * Add criteria
     *
     * @param searchCriteria the search criteria name
     * @param value value
     */

    public void addCriteria(String searchCriteria, Object value) {
        ALL_CRITERIA.put(searchCriteria, value);
    }

    /**
     * Gets appliance name
     *
     * @return appliance name
     */

    public String getApplianceName() {
        return applianceName;
    }

    /**
     * Gets criteria
     *
     * @return criteria
     */

    public Map<String, Object> getCriteria() {
        return new HashMap<>(ALL_CRITERIA);
    }
}
