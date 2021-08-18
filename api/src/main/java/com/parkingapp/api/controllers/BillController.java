package com.parkingapp.api.controllers;


import com.parkingapp.api.models.Bill;
import com.parkingapp.api.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.parkingapp.api.routes.GeneralRoutes.*;

@RestController
@RequestMapping(BILLS)
@CrossOrigin(origins = "*")
public class BillController
{
    @Autowired
    private BillService billService;

    @GetMapping(GET_ALL)
    public Iterable<Bill> getAll(@RequestParam(required = false, defaultValue = "") String plate){

        return billService.getAll(plate);
    }

    @GetMapping(GET_PARKED)
    public Iterable<Bill> getParked(@RequestParam(required = false, defaultValue = "") String plate){

        return billService.getParked(plate);
    }

    @PostMapping(CHECK_IN)
    public Bill checkIn(@RequestBody Bill bill){

        return billService.checkIn(bill);
    }

    @PutMapping(CHECK_OUT)
    public Bill checkOut(@RequestParam(defaultValue = "") String plate){

        return billService.checkOut(plate);
    }
}
