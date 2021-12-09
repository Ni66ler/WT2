package by.bsuir.entity;

import by.bsuir.entity.criteria.SearchCriteria;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Laptop appliance
 */

@Getter
@ToString(callSuper = true)
public class Laptop extends Appliance{

    private final int batteryCapacity;
    private final String operatingSystem;
    private final int ram;
    private final int systemMemory;

    /**
     * Constructor for new laptop
     *
     * @param cost cost of new laptop
     * @param batteryCapacity battery capacity of new laptop
     * @param operatingSystem operating system of new laptop
     * @param ram ram of new laptop
     * @param systemMemory system memory of new laptop
     */

    @Builder(setterPrefix = "with")
    public Laptop(int cost, int batteryCapacity, String operatingSystem, int ram, int systemMemory) {
        super(cost);
        this.batteryCapacity = batteryCapacity;
        this.operatingSystem = operatingSystem;
        this.ram = ram;
        this.systemMemory = systemMemory;
    }

    @Override
    public boolean isApplianceMatchedCriteria(String criteriaField, Object value) {
        SearchCriteria.LaptopCriteria laptopCriteria = SearchCriteria.LaptopCriteria.valueOf(criteriaField);
        if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.RAM)) {
            return (int) value == ram;
        }
        if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.BATTERY_CAPACITY)) {
            return (int) value == batteryCapacity;
        }
        if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.OPERATING_SYSTEM)) {
            return operatingSystem.equals(value);
        }
        if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.COST)) {
            return (int) value == cost;
        }
        if (laptopCriteria.equals(SearchCriteria.LaptopCriteria.SYSTEM_MEMORY)) {
            return (int) value == systemMemory;
        }
        return false;
    }
}
