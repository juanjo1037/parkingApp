package com.parkingapp.api.repositories;

import com.parkingapp.api.models.Bill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import static com.parkingapp.api.queries.BillQuery.countActiveBills;
import static com.parkingapp.api.queries.BillQuery.findByPlateAndActive;

public interface BillRepository extends CrudRepository <Bill, String> {

    @Query(value = countActiveBills, nativeQuery = true)
    int countActiveBills();

    @Query(value = findByPlateAndActive, nativeQuery = true)
    Bill findByPlateAndActive(@Param("plate") String plate);


}
