package com.parkingapp.api.services;

import com.parkingapp.api.models.Bill;
import com.parkingapp.api.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

import static com.parkingapp.api.constants.GeneralConstants.PARKING_CAPACITY;
import static com.parkingapp.api.constants.GeneralConstants.PRICE_PER_MINUTE;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Iterable<Bill> getAll() {
        return billRepository.findAll();
    }

    public Bill createBill(Bill bill) {

        Bill createdBill = null;
        int activeBills = billRepository.countActiveBills();

        if (activeBills <= PARKING_CAPACITY) {
            createdBill = billRepository.save(bill);
        }

        return createdBill;
    }

    public Bill checkOutBill(String plate) {

        Bill bill = billRepository.findByPlateAndActive(plate);

        if (bill != null) {

            bill.setDepartureTime(new Date());

            // TODO REDONDEAR
            float price = ((bill.getDepartureTime().getTime() - bill.getEntryTime().getTime()) / 60000) * PRICE_PER_MINUTE;

            bill.setPrice(price);
        }

        return bill;
    }
}
