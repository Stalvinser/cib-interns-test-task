package socks.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;


@Entity(name="socks")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SocksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @NotNull
    private String color;
    @Min(0)
    @Max(100)
    private int cottonPart;
    @Min(0)
    private int quantity;

    public SocksEntity(String color, int cottonPart, int quantity) {
        this.color = color.toLowerCase().trim();
        this.cottonPart = cottonPart;
        this.quantity = quantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SocksEntity that = (SocksEntity) o;
        return Id != null && Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
