package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author : ShEnUx
 * @time : 10:22 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    private String front_View;
    private String back_View;
    private String side_View;
    private String interior;
}
