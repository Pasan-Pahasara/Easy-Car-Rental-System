package lk.ijse.easy.embeded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
public class ImageDTO {
    private MultipartFile front_View;
    private MultipartFile back_View;
    private MultipartFile side_View;
    private MultipartFile interior;
}
