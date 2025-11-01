package hsf302.f25.s3.pehsf302662323ce190589.service;

import hsf302.f25.s3.pehsf302662323ce190589.entity.Manufacturer;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }
}
