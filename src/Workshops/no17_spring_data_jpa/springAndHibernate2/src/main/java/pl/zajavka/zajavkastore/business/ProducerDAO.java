package pl.zajavka.zajavkastore.business;

import pl.zajavka.zajavkastore.infrastructure.database.entity.ProducerEntity;

public interface ProducerDAO {

    ProducerEntity getProducer(final Integer producerId);

    void saveProducer(final ProducerEntity producerEntity);

    void deleteProducer(final Integer producerId);
}
