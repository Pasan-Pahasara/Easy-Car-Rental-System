package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author : ShEnUx
 * @time : 10:36 AM
 * @date : 2/14/2023
 * @since : 0.1.0
 **/
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rate {
    private double daily_Rate;
    private double monthly_Rate;
}
