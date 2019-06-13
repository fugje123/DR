package org.tensorflow.lite.examples.classification.models;

import java.io.Serializable;

public class City implements Serializable {
    String name;
    String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
