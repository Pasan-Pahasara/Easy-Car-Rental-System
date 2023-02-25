package lk.ijse.easy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : ShEnUx
 * @time : 3:30 PM
 * @date : 2/25/2023
 * @since : 0.1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomDTO {
    private String value;
    private int count;

    public CustomDTO(String lastIndex) {
        this.value=lastIndex;
    }

    public CustomDTO(int count) {
        this.count=count;
    }
}
