package io.obel.model;


import io.vavr.control.Option;
import lombok.Value;

@Value
public class Person {
    private String firstName;
    private String lastName;
    private Address address;

    public Option<Address> getAddressOpt() {
        return Option.of(address);
    }
}
