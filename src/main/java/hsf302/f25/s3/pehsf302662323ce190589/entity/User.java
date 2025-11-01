package hsf302.f25.s3.pehsf302662323ce190589.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Integer userId;

    @Column(columnDefinition = "VARCHAR(100)", unique = true, nullable = false)
    @NotBlank(message = "required")
    String email;

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    @NotBlank(message = "required")
    String password;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    String role;
}
