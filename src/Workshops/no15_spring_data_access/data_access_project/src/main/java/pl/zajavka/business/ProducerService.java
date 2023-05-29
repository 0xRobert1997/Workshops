package pl.zajavka.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.domain.Producer;

import java.util.List;

@Service
@AllArgsConstructor
public class ProducerService {
    private final ProducerRepository producerRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Producer create(Producer producer) {
        return producerRepository.create(producer);
    }

    @Transactional
    public void removeAll() {
        productRepository.removeAll();
        producerRepository.removeAll();
    }

    public List<Producer> findAll() {
        return producerRepository.findAll();
    }
}
