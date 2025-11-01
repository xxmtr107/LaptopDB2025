package hsf302.f25.s3.pehsf302662323ce190589.service;

import hsf302.f25.s3.pehsf302662323ce190589.entity.Computer;
import hsf302.f25.s3.pehsf302662323ce190589.entity.Manufacturer;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ComputerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.repository.ManufacturerRepository;
import hsf302.f25.s3.pehsf302662323ce190589.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputerService {
    private final ComputerRepository computerRepository;
    private final ManufacturerRepository manufacturerRepository;

    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    public Computer findById(Integer id) {
        return computerRepository.findById(id).orElse(null);
    }

    public void save(Computer computer) {
         computerRepository.save(computer);
    }

    public void deleteById(Integer id) {

        computerRepository.deleteById(id);
    }

}
