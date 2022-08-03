package socks.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;



@Entity(name="socks")
@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String color;
    private int cottonPart;
    @Min(0)
    private int quantity;

    public Socks(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }
}
