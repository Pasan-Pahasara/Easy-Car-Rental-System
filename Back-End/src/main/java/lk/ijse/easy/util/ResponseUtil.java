package lk.ijse.easy.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author : ShEnUx
 * @time : 4:39 PM
 * @date : 2/13/2023
 * @since : 0.1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ResponseUtil {
    private String state;
    private String message;
    private Object data;
}
