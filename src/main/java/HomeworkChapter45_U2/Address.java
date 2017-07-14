package HomeworkChapter45_U2;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Access(AccessType.PROPERTY)
public class Address {

    private int id;
    private String country;
    private String postcode;
    private String district;
    private String city;
    private String street;
    private String houseno;
    private String flat;


    // ******************************************************************************************************  constructors
    public Address() {
    }

    public Address(String country, String postcode, String district, String city,
                   String street, String houseno, String flat ) {
        this.country = country;
        this.postcode = postcode;
        this.district = district;
        this.city = city;
        this.street = street;
        this.houseno = houseno;
        this.flat = flat;

    }
    // ******************************************************************************************************  getters
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq",
            sequenceName = "address_seq",
            initialValue = 1,
            allocationSize = 1)
    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getDistrict() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseno() {
        return houseno;
    }

    public String getFlat() {
        return flat;
    }

    // ******************************************************************************************************  setters

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouseno(String houseno) {
        this.houseno = houseno;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }


}