package seedu.address.model.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.cert.CertExpiry;
import seedu.address.model.cert.CertName;
import seedu.address.model.cert.Certificate;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Salary;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagColour;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    private record Pair<T, U>(T t, U u) {}

    private static Person[] getSamplePersons() {
        return new Person[] {
            new Person(
                    new Name("John Kler"),
                    new Phone("+65 81234567"),
                    new Email("johnkler@example.co"),
                    new Address("123D Pine Road, #12-345, Singapore 123456"),
                    getTagSet(new Pair<>("Pentester", "red"), new Pair<>("AD", "blue")),
                    new Salary("6500"),
                    getCertificateArrayList(new Pair<>("OSCP Plus", "2028-12-31"))),
            new Person(
                    new Name("John Doe"),
                    new Phone("+65 87654321"),
                    new Email("johndoe@example.co"),
                    new Address("321D Einp Road, #54-321, Singapore 654321"),
                    getTagSet(new Pair<>("Pentester", "red"), new Pair<>("Web", "green")),
                    new Salary("6500"),
                    getCertificateArrayList(new Pair<>("Burp Suite Certified Practitioner", "2027-06-21"))),
            new Person(
                    new Name("Jane Do"),
                    new Phone("+65 84321765"),
                    new Email("janedo@example.co"),
                    new Address("987A Nepi Road, #21-543, Singapore 321654"),
                    getTagSet(new Pair<>("Intern", "yellow")),
                    new Salary("1300")),
            new Person(
                    new Name("Johny Doeh"),
                    new Phone("+65 81357246"),
                    new Email("johnydoeh@example.co"),
                    new Address("654B Enpi Road, #45-123, Singapore 246135"),
                    getTagSet(new Pair<>("Intern", "yellow")),
                    new Salary("1300"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given, with the default colour for all.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a tag set containing the list of strings given, with the given colour for each.
     */
    private static Set<Tag> getTagSet(Pair<String, String>... pairs) {
        return Arrays.stream(pairs)
                .map(p -> new Tag(p.t(), convertToTagColour(p.u())))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the TagColour representation of the colour.
     */
    private static TagColour convertToTagColour(String userColourName) {
        switch (userColourName) {
        case "red":
            return TagColour.RED;
        case "yellow":
            return TagColour.YELLOW;
        case "green":
            return TagColour.GREEN;
        default:
            return TagColour.BLUE;
        }
    }

    /**
     * Returns a certificate array list containing the list of strings given.
     */
    private static ArrayList<Certificate> getCertificateArrayList(Pair<String, String>... pairs) {
        ArrayList<Certificate> certs = new ArrayList<>();
        for (Pair<String, String> p : pairs) {
            certs.add(new Certificate(
                   new CertName(p.t()),
                   new CertExpiry(LocalDate.parse(p.u()))));
        }
        return certs;
    }
}
