package uz.pdp.springframeworkcore.dto;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookCreateDTO {
    private String title;
    private String overview;
    private MultipartFile[] files;
}
