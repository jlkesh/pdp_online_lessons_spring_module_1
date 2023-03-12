package uz.pdp.springframeworkcore.domains;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Uploads {
    private Integer id;
    private String originalName;
    private String generatedName;
    private String mimeType;
    private long size;
}
