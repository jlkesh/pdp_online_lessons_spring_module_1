package uz.pdp.springframeworkcore.domains;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthRole {
    private Long id;
    private String name;
    private String code;

    private List<AuthPermission> permissions;
}
