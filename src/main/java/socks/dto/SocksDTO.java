package socks.dto;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Validated
public class SocksDTO {
    @Size(min =2 ,max = 30, message = "Size can`t be less than 2 characters or greater than 30")
    @NotBlank(message = "Please provide a color")
    private String color;
    @Min(value = 0, message = "Cotton part can't be less than 1 or bigger than 100")
    @Max(value = 100, message = "Cotton part can't be less than 1 or bigger than 100")
    private int cottonPart;
    @Positive(message = "Quantity cannot be Zero or negative")
    private int quantity;

}
