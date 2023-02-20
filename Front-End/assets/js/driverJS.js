/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

let baseUrl = "http://localhost:8080/Back_End_war/";

<!-- Start Driver Section -->

driverLoadTable();

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
        url: baseUrl + "driver",
        method: "post",
        contentType: "application/json",
        data: JSON.stringify(driverOb),
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
        url: baseUrl + "driver",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(driverOb),
        dataType: "json",
        success: function (res) {
            alert(res.message);
            driverLoadTable();
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
        url: baseUrl + "driver?user_Id=" + driverNicNo,
        method: "DELETE",
        success: function (res) {
            if (res.code === 200) {
                alert(res.message);
                driverLoadTable();
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver delete -->


//Search driver Event
$("#driver-search").on("keypress", function (e) {
    if (e.key == "Enter") {
        searchDriver();
    }
});

//Search Driver
function searchDriver() {
    let driverNicNo = $("#driverNicNo").val();
    $.ajax({
        url: baseUrl + "/" + driverNicNo,
        method: "GET",
        success: function (res) {
            if (res.code = 200) {
                var driver = res.data;
                $("#driverNicNo").val(driver.user_Id);
                $("#driverFirstName").val(driver.firstName);
                $("#driverLastName").val(driver.driverLastName);
                $("#contactNo").val(driver.contactNo);
                $("#address").val(driver.address);
                $("#driverEmail").val(driver.driverEmail);
                $("#availability").val(driver.availability);
                $("#role_Type").val(driver.role_Type);
                $("#driverUserName").val(driver.driverUserName);
                $("#driverPassword").val(driver.driverPassword);
            } else {
            }
        },
        error:function (ob){
        }
    });
}

<!-- start load driver function -->
function driverLoadTable() {
    $("#tblDriver").empty();
    $.ajax({
        url: baseUrl + "driver",
        method: "GET",
        contentType: "application/json",
        success: function (resp) {
            for (let driver of resp.data) {
                let row = `<tr><td>${driver.user_Id}</td><td>${driver.name.firstName}</td><td>${driver.name.lastName}</td><td>${driver.contact_No}</td><td>${driver.address}</td><td>${driver.email}</td><td>${driver.driver_Availability}</td><td>${driver.user.role_Type}</td><td>${driver.user.user_Name}</td><td>${driver.user.password}</td></tr>`;
                $("#tblDriver").append(row);
            }
            bindClickEvents();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}
<!-- end load driver function -->

<!-- start bind click events to the table rows function -->
function bindClickEvents() {
    $("#tblDriver>tr").on('click',function () {
        //Get values from the selected row
        let driverNicNo = $(this).children().eq(0).text();
        let driverFirstName = $(this).children().eq(1).text();
        let driverLastName = $(this).children().eq(2).text();
        let contactNo = $(this).children().eq(3).text();
        let address = $(this).children().eq(4).text();
        let driverEmail= $(this).children().eq(5).text();
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

<!-- End Driver Section -->