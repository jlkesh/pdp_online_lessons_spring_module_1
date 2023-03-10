package uz.pdp.springframeworkcore.domains;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AuthUser {
    private Long id;
    private String username;
    private String password;
    private String role;
}
