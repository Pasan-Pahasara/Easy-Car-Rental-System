/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let carBaseUrl = "http://localhost:8080/Back_End_war/";
<!-- Start Car Section -->
carLoadTable();

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
        url: carBaseUrl + "car",
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
        url: carBaseUrl + "car",
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

<!-- start load car function -->
function carLoadTable() {
    $("#tblCar").empty();
    $.ajax({
        url: carBaseUrl + "car",
        method: "get",
        contentType: "application/json",
        success: function (resp) {
            for (let car of resp.data) {
                let row = `<tr><td>${car.car_Id}</td><td>${car.car_name}</td><td>${car.car_brand}</td><td>${car.type}</td><td>${car.image.front_View}</td><td>${car.image.back_View}</td><td>${car.image.side_View}</td><td>${car.image.interior}</td><td>${car.number_Of_Passengers}</td><td>${car.transmission_Type}</td><td>${car.fuel_Type}</td><td>${car.rent_Duration_Price.daily_Rate}</td><td>${car.rent_Duration_Price.monthly_Rate}</td><td>${car.price_Extra_KM}</td><td>${car.registration_Number}</td><td>${car.free_Mileage}</td><td>${car.color}</td><td>${car.car_Availability}</td></tr>`;
                $("#tblCar").append(row);
            }
            carBindClickEvents();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}
<!-- end load car function -->

<!-- start bind click events to the table rows function -->
function carBindClickEvents() {
    $("#tblCar>tr").on('click',function () {
        //Get values from the selected row
        let carId = $(this).children().eq(0).text();
        let carName = $(this).children().eq(1).text();
        let carBrand = $(this).children().eq(2).text();
        let carType = $(this).children().eq(3).text();
        let frontView = $(this).children().eq(4).text();
        let backView= $(this).children().eq(5).text();
        let sideView = $(this).children().eq(6).text();
        let interiorImage = $(this).children().eq(7).text();
        let numberOfPassengers = $(this).children().eq(8).text();
        let transmissionType = $(this).children().eq(9).text();
        let fuelType = $(this).children().eq(10).text();
        let dailyRate = $(this).children().eq(11).text();
        let monthlyRate = $(this).children().eq(12).text();
        let priceExtraKM = $(this).children().eq(13).text();
        let registrationNumber = $(this).children().eq(14).text();
        let freeMileage = $(this).children().eq(15).text();
        let color = $(this).children().eq(16).text();
        let carAvailability = $(this).children().eq(17).text();

        //Set values to the text-fields
        $("#carId").val(carId);
        $("#carName").val(carName);
        $("#carBrand").val(carBrand);
        $("#carType").val(carType);
        $("#frontView").val(frontView);
        $("#backView").val(backView);
        $("#sideView").val(sideView);
        $("#interiorImage").val(interiorImage);
        $("#numberOfPassengers").val(numberOfPassengers);
        $("#transmissionType").val(transmissionType);
        $("#fuelType").val(fuelType);
        $("#dailyRate").val(dailyRate);
        $("#monthlyRate").val(monthlyRate);
        $("#priceExtraKM").val(priceExtraKM);
        $("#registrationNumber").val(registrationNumber);
        $("#freeMileage").val(freeMileage);
        $("#color").val(color);
        $("#carAvailability").val(carAvailability);
    });
}
<!-- end bind click events to the table rows function -->

<!-- End Car Section -->
