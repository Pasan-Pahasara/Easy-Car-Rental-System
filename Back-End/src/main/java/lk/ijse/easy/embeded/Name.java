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
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Name {
    private String fistName;
    private String lastName;
}
