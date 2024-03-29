package pl.zajavka.business;

import pl.zajavka.domain.Producer;

import java.util.List;

public interface ProducerRepository {

    Producer create(Producer producer);

    void removeAll();

    List<Producer> findAll();
}
