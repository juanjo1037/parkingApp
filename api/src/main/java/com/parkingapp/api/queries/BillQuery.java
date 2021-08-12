package com.parkingapp.api.queries;

public class BillQuery {

    public static final String countActiveBills = "SELECT count(*) FROM parkingapp.bill WHERE departure_time IS null";

    public static final String findByPlateAndActive = "SELECT * FROM parkingapp.bill WHERE plate = :plate AND departure_time IS null";
}
