package com.sra.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import com.sra.config.Config;
import com.sra.service.spaceoperations.SpacePriceSelector;
import com.sra.service.spaceoperations.SpaceTypeSelector;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "space")
public class Space implements Describable, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name",length=20, unique=true, nullable = false)
    private String name;

    @Column(name = "type_of_space", nullable = false)
    private TypeOfSpace typeOfSpace;

    @Column(name = "price", nullable = false)
    private int price;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(TypeOfSpace type) {
        this.typeOfSpace = type;
    }

    public int getPrice() {
        return this.price;
    }

    public void setType(String typeName) {
        switch (typeName) {
            case "open_space" : {
                this.setType(TypeOfSpace.OPEN_SPACE);
                break;
            }
            case "private_room" : {
                this.setType(TypeOfSpace.PRIVATE_ROOM);
                break;
            }
            case "conference_room" : {
                this.setType(TypeOfSpace.CONFERENCE_ROOM);
                break;
            }
            default: {
                System.out.println(Config.RED_COLOUR + "SetType method in " + this.getClass() + "failed to choose from types of space!" + Config.RESET_COLOUR);
                throw new UnsupportedOperationException();
            }
        }

    }

    public void initialize(String nameOfNewSpace, SpaceTypeSelector spaceTypeSelector, SpacePriceSelector spacePriceSelector) throws IOException {
        this.setName(nameOfNewSpace);
        spaceTypeSelector.selectType(this);
        spacePriceSelector.start(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void printDescription() {
        System.out.println(Config.YELLOW_COLOUR + String.format(" - Space named %s, space type: %s, price per hour: USD %d.",
                this.name,
                this.getTypeAsString(),
                this.price) + Config.RESET_COLOUR);
    }

    public String getTypeAsString() {
        switch (this.typeOfSpace) {
            case TypeOfSpace.CONFERENCE_ROOM : {
                return "conference_room";
            }
            case TypeOfSpace.PRIVATE_ROOM: {
                return "private_room";
            }
            case TypeOfSpace.OPEN_SPACE: {
                return "open_space";
            }
        }
        return null;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Space other = (Space) object;
        return (this.name.equals(other.getName()));
    }

    public int hashCode () {
        return Objects.hash(name);
    }


}
