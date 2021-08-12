package com.parkingapp.api.controllers;


import com.parkingapp.api.models.Bill;
import com.parkingapp.api.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import static com.parkingapp.api.routes.GeneralRoutes.BILLS;

@RestController
@RequestMapping(BILLS)
public class BillController
{
    @Autowired
    private BillService billService;

    @GetMapping
    public Iterable<Bill> getAll(){

        return billService.getAll();
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill bill){

        return billService.createBill(bill);
    }

    @PutMapping
    public Bill checkOutBill(@RequestParam String plate){

        return billService.checkOutBill(plate);
    }
}
