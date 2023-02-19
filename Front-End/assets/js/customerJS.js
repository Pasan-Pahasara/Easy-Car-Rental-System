/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let baseUrl = "http://localhost:8080/Back_End_war/";
<!-- Start Car Section -->

<!-- start car add -->
$("#addCarBtn").on('click', function () {
    let carId = $("#carId").val();
    let carName = $("#carName").val();
    let carBrand = $("#carBrand").val();
    let carType = $("#carType").val();
    let frontView = $("#frontView").val();
    let backView = $("#backView").val();
    let sideView = $("#sideView").val();
    let interiorImage = $("#interiorImage").val();
    let numberOfPassengers = $("#numberOfPassengers").val();
    let transmissionType = $("#transmissionType").val();
    let fuelType = $("#fuelType").val();
    let dailyRate = $("#dailyRate").val();
    let monthlyRate = $("#monthlyRate").val();
    let priceExtraKM = $("#priceExtraKM").val();
    let registrationNumber = $("#registrationNumber").val();
    let freeMileage = $("#freeMileage").val();
    let color = $("#color").val();
    let carAvailability = $("#carAvailability").val();

    if (carId) var carOb = {
        car_Id: carId,
        car_name: carName,
        car_brand: carBrand,
        type: carType,
        image: {
            front_View: frontView,
            back_View: backView,
            side_View: sideView,
            interior: interiorImage
        },
        number_Of_Passengers: numberOfPassengers,
        transmission_Type: transmissionType,
        fuel_Type: fuelType,
        rent_Duration_Price: {
            daily_Rate: dailyRate,
            monthly_Rate: monthlyRate
        },
        price_Extra_KM: priceExtraKM,
        registration_Number: registrationNumber,
        free_Mileage: freeMileage,
        color: color,
        car_Availability: carAvailability
    }

    $.ajax({
        url: baseUrl + "car",
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(carOb),
        success: function (resp) {
            if (resp.data === true) {
                alert(resp.message);
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end car add -->

<!-- start car update -->
$("#updateCar").on('click', function () {
    let carId = $("#carId").val();
    let carName = $("#carName").val();
    let carBrand = $("#carBrand").val();
    let carType = $("#carType").val();
    let frontView = $("#frontView").val();
    let backView = $("#backView").val();
    let sideView = $("#sideView").val();
    let interiorImage = $("#interiorImage").val();
    let numberOfPassengers = $("#numberOfPassengers").val();
    let transmissionType = $("#transmissionType").val();
    let fuelType = $("#fuelType").val();
    let dailyRate = $("#dailyRate").val();
    let monthlyRate = $("#monthlyRate").val();
    let priceExtraKM = $("#priceExtraKM").val();
    let registrationNumber = $("#registrationNumber").val();
    let freeMileage = $("#freeMileage").val();
    let color = $("#color").val();
    let carAvailability = $("#carAvailability").val();

    var carOb = {
        car_Id: carId,
        car_name: carName,
        car_brand: carBrand,
        type: carType,
        image: {
            front_View: frontView,
            back_View: backView,
            side_View: sideView,
            interior: interiorImage
        },
        number_Of_Passengers: numberOfPassengers,
        transmission_Type: transmissionType,
        fuel_Type: fuelType,
        rent_Duration_Price: {
            daily_Rate: dailyRate,
            monthly_Rate: monthlyRate
        },
        price_Extra_KM: priceExtraKM,
        registration_Number: registrationNumber,
        free_Mileage: freeMileage,
        color: color,
        car_Availability: carAvailability
    }

    $.ajax({
        url: baseUrl + "driver",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(carOb),
        dataType: "json",
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end car update -->

<!-- End Car Section -->
