/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

let baseUrl = "http://localhost:8080/Back_End_war/";

<!-- Start Driver Section -->

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
        userDTO: {
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
        userDTO: {
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
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver delete -->

<!-- End Driver Section -->