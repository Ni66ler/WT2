package by.bsuir.entity;

import by.bsuir.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Vacuum cleaner appliance
 */

@Getter
@ToString(callSuper = true)
public class VacuumCleaner extends Appliance{

    private final int powerConsumption;
    private final Material bodyMaterial;
    private final int weight;

    /**
     * Constructor for new vacuum cleaner
     *
     * @param cost cost of new vacuum cleaner
     * @param powerConsumption power consumption of new vacuum cleaner
     * @param material body material of new vacuum cleaner
     * @param weight weight of new vacuum cleaner
     */

    @Builder(setterPrefix = "with")
    public VacuumCleaner(int cost, int powerConsumption, Material material, int weight) {
        super(cost);
        this.powerConsumption = powerConsumption;
        this.bodyMaterial = material;
        this.weight = weight;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.VacuumCleanerCriteria vacuumCleanerCriteria = SearchCriteria.VacuumCleanerCriteria.valueOf(criteriaField);
        if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.POWER_CONSUMPTION)) {
            return (int) value == powerConsumption;
        }
        if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.MATERIAL)) {
            return bodyMaterial.equals(Material.valueOf((String) value));
        }
        if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.WEIGHT)) {
            return (int) value == weight;
        }
        if (vacuumCleanerCriteria.equals(SearchCriteria.VacuumCleanerCriteria.COST)) {
            return (int) value == cost;
        }
        return false;
    }
}