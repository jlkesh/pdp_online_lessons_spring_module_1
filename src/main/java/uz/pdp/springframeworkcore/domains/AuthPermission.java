package uz.pdp.springframeworkcore.domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthPermission {
    private Long id;
    private String name;
    private String code;
}
