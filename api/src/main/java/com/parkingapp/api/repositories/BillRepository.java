package com.parkingapp.api.repositories;

import com.parkingapp.api.models.Bill;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static com.parkingapp.api.queries.BillQuery.*;

public interface BillRepository extends CrudRepository <Bill, String> {

    @Query(value = countActive, nativeQuery = true)
    int countActive();

    @Query(value = getByPlate, nativeQuery = true)
    Iterable<Bill> getByPlate(@Param("plate") String plate);

    @Query(value = getByActive, nativeQuery = true)
    Iterable<Bill> getByActive();

    @Query(value = getByPlateAndActive, nativeQuery = true)
    Bill getByPlateAndActive(@Param("plate") String plate);

    @Modifying
    @Transactional
    @Query(value = updateByPlate, nativeQuery = true)
    int updateByPlate(@Param("plate") String plate, @Param("price") Float price, @Param("departure") Date departure);
}
