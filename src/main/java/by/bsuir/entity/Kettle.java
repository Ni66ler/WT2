package by.bsuir.entity;

import by.bsuir.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Kettle appliance
 */
@Getter
@ToString(callSuper = true)
public class Kettle extends Appliance {
    private final int powerConsumption;
    private final int volume;
    private final Material material;

    /**
     * Constructor for new kettle
     *
     * @param cost cost of new kettle
     * @param powerConsumption power consumption of new kettle
     * @param volume volume of new kettle
     * @param material material of new kettle
     */

    @Builder(setterPrefix = "with")
    public Kettle(int cost, int powerConsumption, int volume, Material material) {
        super(cost);
        this.powerConsumption = powerConsumption;
        this.volume = volume;
        this.material = material;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.KettleCriteria kettleCriteria = SearchCriteria.KettleCriteria.valueOf(criteriaField);
        if (kettleCriteria.equals(SearchCriteria.KettleCriteria.POWER_CONSUMPTION)) {
            return (int) value == powerConsumption;
        }
        if (kettleCriteria.equals(SearchCriteria.KettleCriteria.MATERIAL)) {
            return material.equals(Material.valueOf((String) value));
        }
        if (kettleCriteria.equals(SearchCriteria.KettleCriteria.VOLUME)) {
            return (int) value == volume;
        }
        if (kettleCriteria.equals(SearchCriteria.KettleCriteria.COST)) {
            return (int) value == cost;
        }
        return false;
    }
}
