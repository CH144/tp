package seedu.address.model.person;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's salary in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSalary(String)}
 */
public class Salary {


    public static final String MESSAGE_CONSTRAINTS =
            "Salaries should only contain digits";
    public static final String VALIDATION_REGEX = "\\d+";
    public final int value;

    /**
     * Constructs a {@code Salary}.
     *
     * @param salary A valid salary.
     */
    public Salary(int salary) {
        checkArgument(isValidSalary(String.valueOf(salary)), MESSAGE_CONSTRAINTS);
        value = salary;
    }

    /**
     * Returns true if a given salary is a valid salary.
     */
    public static boolean isValidSalary(String test) {
        return test.isEmpty() || test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Salary)) {
            return false;
        }

        Salary otherSalary = (Salary) other;
        return value == otherSalary.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

}
