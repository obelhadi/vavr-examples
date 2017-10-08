package io.obel;


import io.obel.model.Address;
import io.obel.model.Person;
import io.vavr.control.Option;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class OptionTest {

    @Test
    public void should_create_simple_person_option() {
        final Person person = new Person("John", "Doe", null);
        final Option<Person> personOption = Option.of(person);
        assertThat(personOption.isDefined()).isTrue();
        assertThat(personOption.get()).isEqualTo(person);
    }

    @Test
    public void should_not_fail_when_creating_option_of_null() {
        final Option<Object> nullOption = Option.of(null);
        assertThat(nullOption.isDefined()).isFalse();
        assertThat(nullOption).isEqualTo(Option.none());
    }

    @Test
    public void should_return_person_city_name() {
        final String vavrCity = "Vavr City";
        final Address address = new Address(vavrCity, "Option St");
        final Person person = new Person("John", "Doe", address);

        final String city = Option.of(person)
                            .flatMap(Person::getAddressOpt)
                            .map(Address::getCity)
                            .getOrElse("Uknown City");

        assertThat(city).isEqualTo(vavrCity);
    }


}
