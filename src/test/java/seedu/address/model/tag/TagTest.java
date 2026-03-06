package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "friend, family";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));

        // invalid tag names
        assertFalse(Tag.isValidTagName("friend,family")); // contains comma
        assertFalse(Tag.isValidTagName("thisTagIsWayTooLongOverThirtyCharacters")); // over 30 char

        // valid tag names
        assertTrue(Tag.isValidTagName("friend")); // alphanumeric
        assertTrue(Tag.isValidTagName("hr team #2")); // contains special char
        assertTrue(Tag.isValidTagName("12345")); // numbers
        assertTrue(Tag.isValidTagName("")); // empty string
    }

}
