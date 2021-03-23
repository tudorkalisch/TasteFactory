package ro.backend.tastefactory.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ingredient_id")
    UUID id;
    String name;
    int serving;
    int calories;
    String type;
    String measureUnit;


    public Ingredient() {
    }

    public Ingredient(@JsonProperty("id") UUID id,
                      @JsonProperty("name") String name,
                      @JsonProperty("type") String type,
                      @JsonProperty("serving") int serving,
                      @JsonProperty("calories") int calories,
                      @JsonProperty("measureUnit") String measureUnit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.serving = serving;
        this.calories = calories;
        this.measureUnit = measureUnit;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serving=" + serving +
                ", calories=" + calories +
                ", type='" + type + '\'' +
                ", measureUnit='" + measureUnit + '\'' +
                '}';
    }
}
