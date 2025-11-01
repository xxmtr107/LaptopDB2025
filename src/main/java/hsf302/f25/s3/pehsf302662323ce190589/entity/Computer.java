package hsf302.f25.s3.pehsf302662323ce190589.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Year;

@Table (name = "computers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "computer_id")
    Integer computerId;

    @Size(min = 5, max = 50, message = "from 5 to 50 characters")
    @Column(name = "computer_model", columnDefinition = "VARCHAR(100)", nullable = false)
    String computerModel;

    @Column(name = "type", columnDefinition = "VARCHAR(50)", nullable = false)
    @NotBlank(message = "required")
    String type;

    @Min(value = 1990, message = "from 1990 to 2025")
    @Max(value = 2025, message = "from 1990 to 2025")
    @Column(name = "production_year")
    Integer productionYear;

    @Min(value = 100, message = "minimum 100")
    @Column(precision = 10, scale = 2)
    BigDecimal price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "manufacturer_id")
    Manufacturer manufacturer;

}
