package com.parkingapp.api.services;

import com.parkingapp.api.models.Bill;
import com.parkingapp.api.repositories.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.parkingapp.api.constants.ErrorMessagesConstants.NON_PARKED;
import static com.parkingapp.api.constants.ErrorMessagesConstants.PLATE_NOT_NULL;
import static com.parkingapp.api.constants.ErrorMessagesConstants.NO_MORE_CAPACITY;
import static com.parkingapp.api.constants.ErrorMessagesConstants.VEHICLE_ALREADY_PARKED;
import static com.parkingapp.api.constants.ErrorMessagesConstants.VEHICLE_COULD_NOT_REMOVED;

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

        if (!bill.getPlate().isEmpty()) {

            if (billRepository.getByPlateAndActive(bill.getPlate()) == null) {

                int vehiclesParked = billRepository.countActive();

                if (vehiclesParked < PARKING_CAPACITY) {

                    return billRepository.save(bill);
                }

                throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, NO_MORE_CAPACITY);
            }

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, VEHICLE_ALREADY_PARKED);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PLATE_NOT_NULL);
    }

    public Bill checkOut(String plate) {

        if (!plate.isEmpty()) {

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

                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, VEHICLE_COULD_NOT_REMOVED);
            }

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, NON_PARKED);
        }

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, PLATE_NOT_NULL);
    }
}
