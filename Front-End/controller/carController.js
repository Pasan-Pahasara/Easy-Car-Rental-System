/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let carBaseUrl = "http://localhost:8080/Back_End_war/";
<!-- Start Car Section -->
carLoadTable();
generateCarId();

// default submit false
$(function () {
    $("#carSearchForm").submit(function () {
        return false;
    });
});

<!-- start car add -->
$("#addCarBtn").on('click', function () {
    let formData = new FormData($("#carForm")[0]);
    console.log(formData);
    $.ajax({
        url: carBaseUrl + "car",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        dataType: "json",
        success: function (resp) {
            carLoadTable();
            generateCarId();
            alert(resp.message);
            setTextFieldValuesCar("", "", "", "", "", "", "", "", "", "", "", "", "", "");
            loadAllCars();
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
    let formData = new FormData($("#carForm")[0]);
    console.log(formData);
    $.ajax({
        url: carBaseUrl + "car/update",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        dataType: "json",
        success: function (res) {
            carLoadTable();
            alert(res.message);
            setTextFieldValuesCar("", "", "", "", "", "", "", "", "", "", "", "", "", "");
            loadAllCars();
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
        dataType: "json",
        success: function (resp) {
            for (let car of resp.data) {
                console.log(car);
                let row = `<tr><td>${car.car_Id}</td><td>${car.car_name}</td><td>${car.car_brand}</td><td>${car.type}</td><td>${car.number_Of_Passengers}</td><td>${car.transmission_Type}</td><td>${car.fuel_Type}</td><td>${car.rent_Duration_Price.daily_Rate}</td><td>${car.rent_Duration_Price.monthly_Rate}</td><td>${car.price_Extra_KM}</td><td>${car.registration_Number}</td><td>${car.free_Mileage}</td><td>${car.color}</td><td>${car.car_Availability}</td></tr>`;
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
    $("#tblCar>tr").on('click', function () {
        //Get values from the selected row
        let carId = $(this).children().eq(0).text();
        let carName = $(this).children().eq(1).text();
        let carBrand = $(this).children().eq(2).text();
        let carType = $(this).children().eq(3).text();
        let frontView = $(this).children().eq(4).text();
        let backView = $(this).children().eq(5).text();
        let sideView = $(this).children().eq(6).text();
        let interiorImage = $(this).children().eq(7).text();
        let numberOfPassengers = $(this).children().eq(4).text();
        let transmissionType = $(this).children().eq(5).text();
        let fuelType = $(this).children().eq(6).text();
        let dailyRate = $(this).children().eq(7).text();
        let monthlyRate = $(this).children().eq(8).text();
        let priceExtraKM = $(this).children().eq(9).text();
        let registrationNumber = $(this).children().eq(10).text();
        let freeMileage = $(this).children().eq(11).text();
        let color = $(this).children().eq(12).text();
        let carAvailability = $(this).children().eq(13).text();

        //Set values to the text-fields
        $("#carId").val(carId);
        $("#carName").val(carName);
        $("#carBrand").val(carBrand);
        $("#carType").val(carType);
        // $("#frontView").val(frontView);
        // $("#backView").val(backView);
        // $("#sideView").val(sideView);
        // $("#interiorImage").val(interiorImage);
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

<!-- start search car using search car button -->
$("#btnSearchCar").on('click', function () {
    searchCar();
});
<!-- end search car using search car button -->

<!-- start search car using press ENTER -->
$("#txtCarSearch").on('keyup', function (event) {
    if (event.code === "Enter") {
        searchCar();
    }
});
<!-- end search car using press ENTER -->

<!-- start search car function -->
function searchCar() {
    $("#tblCar").empty();
    let searchCar = $("#txtCarSearch").val();
    $.ajax({
        url: driverBaseUrl + "car",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            for (var car of res.data) {
                if (searchCar.trim() === car.car_Id) {
                    $("#tblCar").append(`<tr><td>${car.car_Id}</td><td>${car.car_name}</td><td>${car.car_brand}</td><td>${car.type}</td><td>${car.number_Of_Passengers}</td><td>${car.transmission_Type}</td><td>${car.fuel_Type}</td><td>${car.rent_Duration_Price.daily_Rate}</td><td>${car.rent_Duration_Price.monthly_Rate}</td><td>${car.price_Extra_KM}</td><td>${car.registration_Number}</td><td>${car.free_Mileage}</td><td>${car.color}</td><td>${car.car_Availability}</td></tr>`);
                    carBindClickEvents();
                    setTextFieldValuesCar("", "", "", "", "", "", "", "", "", "", "", "", "", "");
                    return;
                }
            }
            if (searchCar.trim() !== car.car_Id) {
                carLoadTable();
                $("#txtCarSearch").val("");
                setTextFieldValuesCar("", "", "", "", "", "", "", "", "", "", "", "", "", "");
                alert("There is no item available for that " + searchCar);
            }
        }
    });
}

<!-- end search car function -->

<!-- start set text fields values function -->
function setTextFieldValuesCar(carId, carName, carBrand, carType, numberOfPassengers, transmissionType, fuelType, dailyRate, monthlyRate, priceExtraKM, registrationNumber, freeMileage, color, carAvailability) {
    $("#carId").val(carId);
    $("#carName").val(carName);
    $("#carBrand").val(carBrand);
    $("#carType").val(carType);
    // $("#frontView").val(frontView);
    // $("#backView").val(backView);
    // $("#sideView").val(sideView);
    // $("#interiorImage").val(interiorImage);
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
    $(".form-control").css({
        "border": "1px solid #dee2e6"
    });
}

<!-- end set text fields values function -->

<!-- start car delete -->
$("#deleteCar").on('click', function () {
    let carID = $("#carId").val();
    $.ajax({
        url: driverBaseUrl + "car?car_Id=" + carID,
        method: "DELETE",
        dataType: "json",
        success: function (res) {
            carLoadTable();
            alert(res.message);
            setTextFieldValuesCar("", "", "", "", "", "", "", "", "", "", "", "", "", "");
            loadAllCars();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end car delete -->

<!-- start generate car ID function -->
function generateCarId() {
    $.ajax({
        url: carBaseUrl + "car/generateCarId",
        method: "get",
        dataType: "json",
        success: function (res) {
            $('#carId').val(res.data);
        }
    })
}

<!-- end generate car ID function -->

<!-- End Car Section -->
