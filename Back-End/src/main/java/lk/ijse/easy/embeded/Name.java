package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

/**
 * @author : ShEnUx
 * @time : 3:13 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@Embeddable
@Data
public class Name {
    private String firstName;
    private String lastName;
}
