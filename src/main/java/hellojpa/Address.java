package hellojpa;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable // 값 타입을 정의
public class Address {
    private String city;
    private String street;
    private String zipcode;

//    private Member member; // 임베디드 타입으로 엔티티를 가질 수 있다

    public Address() {

    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }

    //setter 삭제하거나 private으로 선언


    // 오버라이드

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(street, address.street) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, zipcode);
    }
}