package hsf302.f25.s3.pehsf302662323ce190589.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Table(name = "manufacturers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    Integer manufacturerId;

    @Column(name = "manufacturer_name", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    String manufacturerName;

    @Column(columnDefinition = "VARCHAR(100)")
    String country;

    @OneToMany(mappedBy = "manufacturer", fetch = FetchType.LAZY)
    List<Computer> computers = new ArrayList<>();
}
