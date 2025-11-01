package hsf302.f25.s3.pehsf302662323ce190589.config;

import hsf302.f25.s3.pehsf302662323ce190589.entity.Computer;
import hsf302.f25.s3.pehsf302662323ce190589.entity.Manufacturer;
import hsf302.f25.s3.pehsf302662323ce190589.entity.User;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ComputerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ManufacturerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataIntializer implements CommandLineRunner {
    ComputerRepository computerRepository;
    UserRepository userRepository;
    ManufacturerRepository manufacturerRepository;
    @Override
    public void run(String... args) throws Exception {
        // --- Users ---
        userRepository.save(User.builder()
                .email("admin@laptopshop.com")
                .password("@1")
                .role("Admin")
                .build());
        userRepository.save(User.builder()
                .email("staff@laptopshop.com")
                .password("@2")
                .role("Staff")
                .build());
        userRepository.save(User.builder()
                .email("member@laptopshop.com")
                .password("@3")
                .role("Member")
                .build());

        // --- Manufacturers ---
        manufacturerRepository.save(Manufacturer.builder()
                .manufacturerName("Dell")
                .country("USA")
                .build());
        manufacturerRepository.save(Manufacturer.builder()
                .manufacturerName("Lenovo")
                .country("China")
                .build());
        manufacturerRepository.save(Manufacturer.builder()
                .manufacturerName("HP")
                .country("USA")
                .build());

        // --- Computers ---
        computerRepository.save(Computer.builder()
                .computerModel("XPS 13")
                .type("Ultrabook")
                .productionYear(2023)
                .price(BigDecimal.valueOf((1299.99)))
                .manufacturer(manufacturerRepository.findById(1).orElse(null))
                .build());
        computerRepository.save(Computer.builder()
                .computerModel("ThinkPad X1 Carbon")
                .type("Business Laptop")
                .productionYear(2023)
                .price(BigDecimal.valueOf((1499.99)))
                .manufacturer(manufacturerRepository.findById(2).orElse(null))
                .build());
        computerRepository.save(Computer.builder()
                .computerModel("Pavilion 15")
                .type("Consumer Laptop")
                .productionYear(2022)
                .price(BigDecimal.valueOf((699.99)))
                .manufacturer(manufacturerRepository.findById(3).orElse(null))
                .build());
        computerRepository.save(Computer.builder()
                .computerModel("Inspiron 14")
                .type("Budget Laptop")
                .productionYear(2023)
                .price(BigDecimal.valueOf((549.99)))
                .manufacturer(manufacturerRepository.findById(1).orElse(null))
                .build());
    }
}
