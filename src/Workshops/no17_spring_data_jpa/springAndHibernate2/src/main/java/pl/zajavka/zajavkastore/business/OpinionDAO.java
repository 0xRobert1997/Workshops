package pl.zajavka.zajavkastore.business;

import pl.zajavka.zajavkastore.infrastructure.database.entity.OpinionEntity;

public interface OpinionDAO {

    OpinionEntity getOpinion(final Integer opinionId);

    void saveOpinion(final OpinionEntity opinionEntity);

    void deleteOpinion(final Integer opinionId);
}
