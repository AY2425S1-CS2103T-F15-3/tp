package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

//@@author {tayxuenye}-reused
// From Week 6 tp CS2103T tutorial 2 sample code from j-lum
/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {

    public static final String MESSAGE_CONSTRAINTS = "Addresses can take any values, and it should not be blank";

    public final String value;

    /**
     * Constructs a {@code Remark}.
     *
     * @param remark A remark.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }
    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
//@@author
