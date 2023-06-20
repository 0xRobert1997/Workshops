package pl.zajavka.zajavkastore.infrastructure.database.jpaRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.infrastructure.database.entity.OpinionEntity;
import pl.zajavka.zajavkastore.infrastructure.database.entity.Stars;

import java.util.List;
import java.util.Set;

@Repository
public interface OpinionDatabaseRepository extends JpaRepository<OpinionEntity, Integer> {

    @Query(
            """
            SELECT opn FROM OpinionEntity opn
            JOIN FETCH opn.purchaseEntity pur
            JOIN FETCH pur.customerEntity cust
            WHERE cust.email = :email
                    """
    )
    List<OpinionEntity> findByCustomerEmail(final @Param("email") String email);

    @Query(
            """
            SELECT COUNT (opn)
            FROM OpinionEntity opn
            WHERE opn.starts <= 2
                    """
    )
    int countWrongOpinions();

    @Query(
            """
            UPDATE OpinionEntity opn
            SET opn.stars = ?1
            WHERE opn.stars IN (?2)
                    """
    )
    @Modifying(clearAutomatically = true)
    void updateWrongOpinions(final Stars correct, final Set<Stars> incorrect);

    @Query(value = "SELECT COUNT (*) FROM opinion", nativeQuery = true)
    int countOpinions();

    @Query(value = """
            DELETE FROM opinion as opn
            WHERE opn.comment LIKE %:word%
            """, nativeQuery = true)
    @Modifying(clearAutomatically = true)
    void deleteOpinionsContaining(final @Param("word") String word);

    @Query(
            value = "SELECT COUNT(*) FROM opoinion WHERE stars = 4",
            nativeQuery = true
    )
    int countMaxStars();

}
