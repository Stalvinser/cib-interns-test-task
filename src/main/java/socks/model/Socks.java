package socks.model;

import lombok.*;
import lombok.experimental.Accessors;
import javax.persistence.*;



@Entity(name="socks")
@Getter
@Setter
@Accessors(chain = true)
@ToString
@NoArgsConstructor
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String color;
    @Column(name = "cotton_part")
    private int cottonPart;
    private int quantity;

    public Socks(String color, int cottonPart, int quantity) {
        this.color = color;
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }
}
