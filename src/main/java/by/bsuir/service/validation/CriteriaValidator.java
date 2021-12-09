package by.bsuir.service.validation;

/**
 * Interface of validator for criteria.
 */

@FunctionalInterface
public interface CriteriaValidator {

    /**
     * Check criteria value for valid.
     *
     * @param value value of criteria
     * @return true if value is valid
     */
    boolean isCriteriaValueValid(Object value);
}
