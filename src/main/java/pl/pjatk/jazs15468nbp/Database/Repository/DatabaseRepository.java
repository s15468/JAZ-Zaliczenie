package pl.pjatk.jazs15468nbp.Database.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.pjatk.jazs15468nbp.Database.Model.GoldInfo;
import java.time.LocalDate;
import java.time.LocalDateTime;

public interface DatabaseRepository extends JpaRepository<GoldInfo, Integer>
{
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO gold_info(mineraltype, startdate, enddate, mineralvalue, requestdate)" +
            "values (:mineralType, :startDate, :endDate, :mineralValue, :requestDate)", nativeQuery = true)
    void InsertGoldInfo(@Param("mineralType")String mineralType,
                        @Param("startDate")LocalDate startDate,
                        @Param("endDate")LocalDate endDate,
                        @Param("mineralValue") double mineralValue,
                        @Param("requestDate")LocalDateTime requestDate);
}
