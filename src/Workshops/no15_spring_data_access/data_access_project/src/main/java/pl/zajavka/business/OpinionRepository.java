package pl.zajavka.business;

import pl.zajavka.domain.Opinion;

import java.util.List;

public interface OpinionRepository {

    List<Opinion> findAll(String email);

    Opinion create(Opinion opinion);

    void removeAll();

    void remove(String email);

    List<Opinion> findAll();

    List<Opinion> findUnwantedOpinions();

    void removeUnwantedOpinions();

    boolean customerGivesUnwantedOpinions(String email);

    List<Opinion> findAllByProductCode(String productCode);

    void removeAllByProductCode(String productCode);

    void removeAllByProduct(String productCode);
}
