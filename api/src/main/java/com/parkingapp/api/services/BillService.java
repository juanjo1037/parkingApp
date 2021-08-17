package com.parkingapp.api.services;

import com.parkingapp.api.models.Bill;
import com.parkingapp.api.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    @Value("${parking.capacity}")
    private int PARKING_CAPACITY;

    @Value("${price.per.minute}")
    private int PRICE_PER_MINUTE;

    public Iterable<Bill> getAll(String plate) {

        if (!plate.isEmpty()) {
            return billRepository.getByPlate(plate);
        } else {
            return billRepository.findAll();
        }
    }

    public Iterable<Bill> getParked(String plate) {

        if (!plate.isEmpty()) {
            List<Bill> list = new ArrayList<>();
            Bill bill = billRepository.getByPlateAndActive(plate);
            if (bill != null) {
                list.add(bill);
            }
            return list;
        } else {
            return billRepository.getByActive();
        }
    }

    public Bill checkIn(Bill bill) {

        Bill createdBill = null;
        if (!bill.getPlate().isEmpty()) {

            if (billRepository.getByPlateAndActive(bill.getPlate()) == null) {
                int vehiclesParked = billRepository.countActive();

                if (vehiclesParked < PARKING_CAPACITY) {
                    createdBill = billRepository.save(bill);
                }
            }
        }

        return createdBill;
    }

    public Bill checkOut(String plate) {

        Bill bill = billRepository.getByPlateAndActive(plate);

        if (bill != null) {

            bill.setDepartureTime(new Date());
            float difference = bill.getDepartureTime().getTime() - bill.getEntryTime().getTime();
            difference = difference < 60000 ? 60000 : difference;
            float price = (float) Math.ceil(difference / 60000) * PRICE_PER_MINUTE;
            bill.setPrice(price);

            int confirm = billRepository.updateByPlate(bill.getPlate(), bill.getPrice(), bill.getDepartureTime());
            if (confirm == 0) {
                return bill;
            }
        }

        return null;
    }
}
