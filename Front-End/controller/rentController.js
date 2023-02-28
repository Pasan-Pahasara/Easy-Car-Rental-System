/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let rentBaseUrl = "http://localhost:8080/Back_End_war/";

let customer;

generateRentId();

<!-- start generate rent ID function -->
function generateRentId() {
    $.ajax({
        url: rentBaseUrl + "rent/generateRentId",
        method: "get",
        dataType: "json",
        success: function (res) {
            $('#rentId').val(res.data);
        }
    })
}

<!-- end generate rent ID function -->

$("#fuelType").on('click', function () {
    let carType = $("#carType").val();
    let fuel_Type = $("#fuelType").val();
    console.log(carType);
    console.log(fuel_Type);
    // $("#carID").empty();
    $.ajax({
        url: rentBaseUrl + "car/filterCarDetails/?type=" + carType + "&fuel_Type=" + fuel_Type,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res) {
                let car_Id = i.car_Id;

                $("#carID").append(`<option>${car_Id}</option>`);
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    })
});

$("#carID").on('click', function () {
    var search = $("#carID").val();
    $.ajax({
        url: rentBaseUrl + "car/searchCar/?car_Id=" + search,
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            console.log(res);
            $("#carModel").val(res.car_name);
            $("#carBrand").val(res.car_brand);
            $("#noOfPassengers").val(res.number_Of_Passengers);
            let frontUrl = res.image.front_View;
            let interiorUrl = res.image.interior;
            let sideUrl = res.image.side_View;
            $("#frontImage").css({
                "background": `url(${rentBaseUrl + frontUrl})`,
                "background-size": "cover",
                "height": "11rem",
                "padding": "1rem",
                "border-radius": "1rem"
            });
            $("#interiorImage").css({
                "background": `url(${rentBaseUrl + interiorUrl})`,
                "background-size": "cover",
                "height": "11rem",
                "padding": "1rem",
                "border-radius": "1rem"
            });
            $("#sideImage").css({
                "background": `url(${rentBaseUrl + sideUrl})`,
                "background-size": "cover",
                "height": "11rem",
                "padding": "1rem",
                "border-radius": "1rem"
            });

        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            console.log(message);
        }
    })
});

let tableRow = [];
let carID;
let rentPickFromDate;
let rentPickFromTime;
let rentReturnFromDate;
let rentReturnFromTime;
let driverAvailability;
let rentLocation;

$("#addCartBtn").on("click", function () {
    let duplicate = false;
    for (let i = 0; i < $("#tblRentCart tr").length; i++) {
        if ($("#carID option:selected").text() === $("#tblRentCart tr").children(':nth-child(1)')[i].innerText) {
            duplicate = true;
        }
    }
    if (duplicate !== true) {
        loadCartTableDetail();
        $('#carID,#rentPickFromDate,#carModel,#carBrand,#noOfPassengers,#rentPickFromTime,#rentReturnFromDate,#rentReturnFromTime,#driverAvailability,#rentLocation').val("");
        $("#tblRentCart").attr('disabled', true);

    } else if (duplicate === true) {
        $(tableRow).children(':nth-child(2)').text($("#rentPickFromDate").val());
        $(tableRow).children(':nth-child(3)').text($("#rentPickFromTime").val())
        $(tableRow).children(':nth-child(4)').text($("#rentReturnFromDate").val());
        $(tableRow).children(':nth-child(5)').text($("#rentReturnFromTime").val());
        $(tableRow).children(':nth-child(6)').text($("#driverAvailability").val());
        $(tableRow).children(':nth-child(7)').text($("#rentLocation").val());

    }

    $("#tblRentCart>tr").on('click', function () {
        tableRow = $(this);
        carID = $(this).children(":eq(0)").text();
        rentPickFromDate = $(this).children(":eq(1)").text();
        rentPickFromTime = $(this).children(":eq(2)").text();
        rentReturnFromDate = $(this).children(":eq(3)").text();
        rentReturnFromTime = $(this).children(":eq(4)").text();
        driverAvailability = $(this).children(":eq(5)").text();
        rentLocation = $(this).children(":eq(6)").text();

        $("#carID").val(carID);
        $("#rentPickFromDate").val(rentPickFromDate);
        $("#rentPickFromTime").val(rentPickFromTime);
        $("#rentReturnFromDate").val(rentReturnFromDate);
        $("#rentReturnFromTime").val(rentReturnFromTime);
        $("#driverAvailability").val(driverAvailability);
        $("#rentLocation").val(rentLocation);
    });
});

$("#tblRentCart").empty();

function loadCartTableDetail() {
    carID = $("#carID").val();
    rentPickFromDate = $("#rentPickFromDate").val();
    rentPickFromTime = $("#rentPickFromTime").val();
    rentReturnFromDate = $("#rentReturnFromDate").val();
    rentReturnFromTime = $("#rentReturnFromTime").val();
    driverAvailability = $('#driverAvailability').is(':checked') ? "YES" : "NO";
    rentLocation = $("#rentLocation").val();

    let row = `<tr><td>${carID}</td><td>${rentPickFromDate}</td><td>${rentPickFromTime}</td><td>${rentReturnFromDate}</td><td>${rentReturnFromTime}</td><td>${driverAvailability}</td><td>${rentLocation}</td></tr>`;

    $("#tblRentCart").append(row);
}

$('#driverAvailability').on('click', function () {
    if ($('#driverAvailability').is(':checked')) {
        // alert('Expensive')
    } else {

    }
});

$("#reservationBtn").on('click', function () {
    let rentDetails = [];
    for (let i = 0; i < $("#tblRentCart tr").length; i++) {
        var rentDetail = {
            carID: $("#tblRentCart").children(`:eq(${i})`).children(":eq(0)").text(),
            rentID: $("#rentId").val(),
            driverID: null
        }
        rentDetails.push(rentDetail);
    }

    for (let i = 0; i < $("#tblRentCart tr").length; i++) {
        let rentID = $("#rentId").val();
        let pickUpDate = $("#tblRentCart").children(`:eq(${i})`).children(":eq(1)").text();
        let pickUpTime = $("#tblRentCart").children(`:eq(${i})`).children(":eq(2)").text();
        let returnDate = $("#tblRentCart").children(`:eq(${i})`).children(":eq(3)").text();
        let returnTime = $("#tblRentCart").children(`:eq(${i})`).children(":eq(4)").text();
        let requestType = $('#driverAvailability').is(':checked') ? "YES" : "NO";
        let rentType = "PENDING";
        let location = $("#tblRentCart").children(`:eq(${i})`).children(":eq(6)").text();
        let userID = $("#userID").val();

        let rentOB = {
            rentID: rentID,
            pickUpDate: pickUpDate,
            pickUpTime: pickUpTime,
            returnDate: returnDate,
            returnTime: returnTime,
            driverRequestType: requestType,
            rentType: rentType,
            location: location,
            regUser: {
                user_Id: userID},
            rentDetails: rentDetails
        }
        console.log(rentDetails)
        console.log(rentOB)

        $.ajax({
            url: rentBaseUrl + "rent",
            method: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(rentOB),
            success: function (res) {
                generateRentId();
                alert(res.message);
            },
            error: function (error) {
                let message = JSON.parse(error.responseText).message;
                // alert(message);
            }
        });
    }
});
