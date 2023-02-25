/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

let dashboardBaseUrl = "http://localhost:8080/Back_End_war/";

$("#numberOfUsers").val("00");
$.ajax({
    url: dashboardBaseUrl + "customer/numberOfUsers",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#numberOfUsers").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#numberOfBookings").val("00");
$.ajax({
    url: dashboardBaseUrl + "rent/dailyBookings",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#numberOfBookings").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#activeBookings").val("00");
$.ajax({
    url: dashboardBaseUrl + "rent/dailyActiveBookings",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#activeBookings").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#availableDrivers").val("00");
$.ajax({
    url: dashboardBaseUrl + "driver/numberOfAvailableDrivers",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#availableDrivers").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#availableCars").val("00");
$.ajax({
    url: dashboardBaseUrl + "car/numberOfAvailableCars",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#availableCars").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#reservedCars").val("00");
$.ajax({
    url: dashboardBaseUrl + "car/numberOfReservedCars",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#reservedCars").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#maintenanceCars").val("00");
$.ajax({
    url: dashboardBaseUrl + "car/numberOfMaintenanceCars",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#maintenanceCars").text(num);
    },
    error: function (ob, statusText, error) {

    }
});

$("#underMaintenanceCars").val("00");
$.ajax({
    url: dashboardBaseUrl + "car/numberOfUnderMaintenanceCars",
    method: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function (resp) {
        let num = resp.data.count;
        $("#underMaintenanceCars").text(num);
    },
    error: function (ob, statusText, error) {

    }
});