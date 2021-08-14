package com.parkingapp.api.queries;

public class BillQuery {

    public static final String countActive = "SELECT count(*) FROM parkingapp.bill WHERE departure_time IS null";

    public static final String getByPlate = "SELECT * FROM parkingapp.bill WHERE plate = :plate";

    public static final String getByActive = "SELECT * FROM parkingapp.bill WHERE departure_time IS null";

    public static final String getByPlateAndActive = "SELECT * FROM parkingapp.bill WHERE plate = :plate AND departure_time IS null";

    public static final String updateByPlate = "UPDATE parkingapp.bill SET price = :price, departure_time = :departure WHERE plate = :plate AND departure_time IS null";

}
