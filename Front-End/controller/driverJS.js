/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

let driverBaseUrl = "http://localhost:8080/Back_End_war/";

driverLoadTable();
<!-- Start Driver Section -->

// default submit false
$(function () {
    $("#driverSearchForm").submit(function () {
        return false;
    });
});

<!-- start driver add -->
$("#addDriverBtn").on('click', function () {
    let driverNicNo = $("#driverNicNo").val();
    let driverFirstName = $("#driverFirstName").val();
    let driverLastName = $("#driverLastName").val();
    let contactNo = $("#contactNo").val();
    let address = $("#address").val();
    let driverEmail = $("#driverEmail").val();
    let availability = $("#availability").val();
    let role_Type = $("#role_Type").val();
    let driverUserName = $("#driverUserName").val();
    let driverPassword = $("#driverPassword").val();

    if (driverNicNo) var driverOb = {
        user_Id: driverNicNo,
        name: {
            firstName: driverFirstName,
            lastName: driverLastName
        },
        contact_No: contactNo,
        address: address,
        email: driverEmail,
        driver_Availability: availability,
        user: {
            user_Id: driverNicNo,
            role_Type: role_Type,
            user_Name: driverUserName,
            password: driverPassword
        }
    }

    $.ajax({
        url: driverBaseUrl + "driver",
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(driverOb),
        dataType: "json",
        success: function (resp) {
                driverLoadTable();
                alert(resp.message);
                setTextFieldValuesDriver("","","","","","","","","","");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver add -->

<!-- start driver update -->
$("#updateDriver").on('click', function () {
    let driverNicNo = $("#driverNicNo").val();
    let driverFirstName = $("#driverFirstName").val();
    let driverLastName = $("#driverLastName").val();
    let contactNo = $("#contactNo").val();
    let address = $("#address").val();
    let driverEmail = $("#driverEmail").val();
    let availability = $("#availability").val();
    let role_Type = $("#role_Type").val();
    let driverUserName = $("#driverUserName").val();
    let driverPassword = $("#driverPassword").val();

    var driverOb = {
        user_Id: driverNicNo,
        name: {
            firstName: driverFirstName,
            lastName: driverLastName
        },
        contact_No: contactNo,
        address: address,
        email: driverEmail,
        driver_Availability: availability,
        user: {
            user_Id: driverNicNo,
            role_Type: role_Type,
            user_Name: driverUserName,
            password: driverPassword
        }
    }

    $.ajax({
        url: driverBaseUrl + "driver",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(driverOb),
        dataType: "json",
        success: function (res) {
            driverLoadTable();
            alert(res.message);
            setTextFieldValuesDriver("","","","","","","","","","");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver update -->

<!-- start driver delete -->
$("#deleteDriver").on('click', function () {
    let driverNicNo = $("#driverNicNo").val();
    $.ajax({
        url: driverBaseUrl + "driver?user_Id=" + driverNicNo,
        method: "DELETE",
        dataType: "json",
        success: function (res) {
                driverLoadTable();
                alert(res.message);
                setTextFieldValuesDriver("","","","","","","","","","");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver delete -->

<!-- start search driver using search driver button -->
$("#btnSearchDriver").on('click', function () {
    searchDriver();
});
<!-- end search driver using search driver button -->

<!-- start search driver using press ENTER -->
$("#txtDriverSearch").on('keyup', function (event) {
    if (event.code === "Enter") {
        searchDriver();
    }
});
<!-- end search item using press ENTER -->

<!-- start search driver function -->
function searchDriver() {
    $("#tblDriver").empty();
    let searchDriver = $("#txtDriverSearch").val();
    $.ajax({
        url: driverBaseUrl + "driver",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            for (var driver of res.data) {
                if (searchDriver.trim() === driver.user_Id) {
                    $("#tblDriver").append(`<tr><td>${driver.user_Id}</td><td>${driver.name.firstName}</td><td>${driver.name.lastName}</td><td>${driver.contact_No}</td><td>${driver.address}</td><td>${driver.email}</td><td>${driver.driver_Availability}</td><td>${driver.user.role_Type}</td><td>${driver.user.user_Name}</td><td>${driver.user.password}</td></tr>`);
                    driverBindClickEvents();
                    setTextFieldValuesDriver("","","","","","","","","","");
                    return;
                }
            }
            if (searchDriver.trim() !== driver.user_Id) {
                driverLoadTable();
                $("#txtDriverSearch").val("");
                setTextFieldValuesDriver("","","","","","","","","","");
                alert("There is no item available for that " + searchDriver);
            }
        }
    });
}
<!-- end search driver function -->

<!-- start load driver function -->
function driverLoadTable() {
    $("#tblDriver").empty();
    $.ajax({
        url: driverBaseUrl + "driver",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            for (let driver of resp.data) {
                let row = `<tr><td>${driver.user_Id}</td><td>${driver.name.firstName}</td><td>${driver.name.lastName}</td><td>${driver.contact_No}</td><td>${driver.address}</td><td>${driver.email}</td><td>${driver.driver_Availability}</td><td>${driver.user.role_Type}</td><td>${driver.user.user_Name}</td><td>${driver.user.password}</td></tr>`;
                $("#tblDriver").append(row);
            }
            driverBindClickEvents();
            setTextFieldValuesDriver("","","","","","","","","","");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}
<!-- end load driver function -->

<!-- start bind click events to the table rows function -->
function driverBindClickEvents() {
    $("#tblDriver>tr").on('click', function () {
        //Get values from the selected row
        let driverNicNo = $(this).children().eq(0).text();
        let driverFirstName = $(this).children().eq(1).text();
        let driverLastName = $(this).children().eq(2).text();
        let contactNo = $(this).children().eq(3).text();
        let address = $(this).children().eq(4).text();
        let driverEmail = $(this).children().eq(5).text();
        let availability = $(this).children().eq(6).text();
        let role_Type = $(this).children().eq(7).text();
        let driverUserName = $(this).children().eq(8).text();
        let driverPassword = $(this).children().eq(9).text();

        //Set values to the text-fields
        $("#driverNicNo").val(driverNicNo);
        $("#driverFirstName").val(driverFirstName);
        $("#driverLastName").val(driverLastName);
        $("#contactNo").val(contactNo);
        $("#address").val(address);
        $("#driverEmail").val(driverEmail);
        $("#availability").val(availability);
        $("#role_Type").val(role_Type);
        $("#driverUserName").val(driverUserName);
        $("#driverPassword").val(driverPassword);
    });
}
<!-- end bind click events to the table rows function -->

<!-- start set text fields values function -->
function setTextFieldValuesDriver(driverNicNo, driverFirstName, driverLastName, contactNo, address, driverEmail, availability, role_Type, driverUserName, driverPassword) {
    $("#driverNicNo").val(driverNicNo);
    $("#driverFirstName").val(driverFirstName);
    $("#driverLastName").val(driverLastName);
    $("#contactNo").val(contactNo);
    $("#address").val(address);
    $("#driverEmail").val(driverEmail);
    $("#availability").val(availability);
    $("#role_Type").val(role_Type);
    $("#driverUserName").val(driverUserName);
    $("#driverPassword").val(driverPassword);
}
<!-- end set text fields values function -->

<!-- End Driver Section -->