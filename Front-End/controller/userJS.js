/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let userBaseUrl = "http://localhost:8080/Back_End_war/";

<!-- Start User Section -->

manageCustomerLoadTable();
generateCustomerId();

// default submit false
$(function () {
    $("#customerSearchForm").submit(function () {
        return false;
    });
});

<!-- start added customer -->
$("#addCustomerBtn").on('click', function () {
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: userBaseUrl + "customer",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
            manageCustomerLoadTable();
            generateCustomerId();
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end added customer -->

<!-- start load customer function -->
function manageCustomerLoadTable() {
    $("#tblCustomerDetails").empty();
    $.ajax({
        url: userBaseUrl + "customer",
        method: "get",
        contentType: "application/json",
        success: function (resp) {
            for (let customerDetails of resp.data) {
                let row = `<tr><td>${customerDetails.user_Id}</td><td>${customerDetails.name.firstName}</td><td>${customerDetails.name.lastName}</td><td>${customerDetails.contact_No}</td><td>${customerDetails.address}</td><td>${customerDetails.email}</td><td>${customerDetails.nic}</td><td>${customerDetails.license_No}</td><td>${customerDetails.user.user_Name}</td><td>${customerDetails.user.password}</td></tr>`;
                $("#tblCustomerDetails").append(row);
            }
            customerBindClickEvents();
            setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

<!-- end load customer function -->

<!-- start generate customer ID function -->
function generateCustomerId() {
    $.ajax({
        url: userBaseUrl + "customer/generateCustomerId",
        method: "get",
        success: function (res) {
            $('#cusRegID').val(res.data);
        }
    })
}

<!-- end generate customer ID function -->

<!-- start search customer using search customer button -->
$("#btnSearchCustomer").on('click', function () {
    searchCustomer();
});
<!-- end search customer using search customer button -->

<!-- start search customer using press ENTER -->
$("#txtCustomerSearch").on('keyup', function (event) {
    if (event.code === "Enter") {
        searchCustomer();
    }
});
<!-- end search customer using press ENTER -->

<!-- start search customer function -->
function searchCustomer() {
    $("#tblCustomerDetails").empty();
    let searchCustomer = $("#txtCustomerSearch").val();
    $.ajax({
        url: userBaseUrl + "customer",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            for (var customerDetails of res.data) {
                if (searchCustomer.trim() === customerDetails.user_Id) {
                    $("#tblCustomerDetails").append(`<tr><td>${customerDetails.user_Id}</td><td>${customerDetails.name.firstName}</td><td>${customerDetails.name.lastName}</td><td>${customerDetails.contact_No}</td><td>${customerDetails.address}</td><td>${customerDetails.email}</td><td>${customerDetails.nic}</td><td>${customerDetails.license_No}</td><td>${customerDetails.user.user_Name}</td><td>${customerDetails.user.password}</td></tr>`);
                    customerBindClickEvents();
                    setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
                    return;
                }
            }
            if (searchCustomer.trim() !== customerDetails.user_Id) {
                manageCustomerLoadTable();
                $("#txtCustomerSearch").val("");
                setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
                alert("There is no item available for that " + searchCustomer);
            }
        }
    });
}
<!-- end search customer function -->

<!-- start bind click events to the table rows function -->
function customerBindClickEvents() {
    $("#tblCustomerDetails>tr").on('click', function () {
        //Get values from the selected row
        let userID = $(this).children().eq(0).text();
        let userFirstName = $(this).children().eq(1).text();
        let userLastName = $(this).children().eq(2).text();
        let customerContactNo = $(this).children().eq(3).text();
        let customerAddress = $(this).children().eq(4).text();
        let customerDriverEmail = $(this).children().eq(5).text();
        let customerNic = $(this).children().eq(6).text();
        let customerLicence = $(this).children().eq(7).text();
        let customerUserName = $(this).children().eq(8).text();
        let customerPassword = $(this).children().eq(9).text();

        //Set values to the text-fields
        $("#userID").val(userID);
        $("#userFirstName").val(userFirstName);
        $("#userLastName").val(userLastName);
        $("#customerContactNo").val(customerContactNo);
        $("#customerAddress").val(customerAddress);
        $("#customerDriverEmail").val(customerDriverEmail);
        $("#customerNic").val(customerNic);
        $("#customerLicence").val(customerLicence);
        $("#customerUserName").val(customerUserName);
        $("#customerPassword").val(customerPassword);
    });
}
<!-- end bind click events to the table rows function -->

<!-- start set text fields values function -->
function setTextFieldValuesCustomer(userID, userFirstName, userLastName, customerContactNo, customerAddress, customerDriverEmail, customerNic, customerLicence, customerUserName, customerPassword) {
    $("#userID").val(userID);
    $("#userFirstName").val(userFirstName);
    $("#userLastName").val(userLastName);
    $("#customerContactNo").val(customerContactNo);
    $("#customerAddress").val(customerAddress);
    $("#customerDriverEmail").val(customerDriverEmail);
    $("#customerNic").val(customerNic);
    $("#customerLicence").val(customerLicence);
    $("#customerUserName").val(customerUserName);
    $("#customerPassword").val(customerPassword);
}
<!-- end set text fields values function -->

<!-- start customer delete -->
$("#deleteCustomer").on('click', function () {
    let userID = $("#userID").val();
    $.ajax({
        url: userBaseUrl + "customer?user_Id=" + userID,
        method: "DELETE",
        success: function (res) {
            if (res.code === 200) {
                manageCustomerLoadTable();
                setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
                alert(res.message);
            }
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end customer delete -->

<!-- start driver update -->
$("#updateCustomer").on('click', function () {
    let userID = $("#userID").val();
    let userFirstName = $("#userFirstName").val();
    let userLastName = $("#userLastName").val();
    let customerContactNo = $("#customerContactNo").val();
    let customerAddress = $("#customerAddress").val();
    let customerDriverEmail = $("#customerDriverEmail").val();
    let customerNic = $("#customerNic").val();
    let customerLicence = $("#customerLicence").val();
    let customerUserName = $("#customerUserName").val();
    let customerPassword = $("#customerPassword").val();

    var CustomerOb = {
        user_Id: userID,
        name: {
            firstName: userFirstName,
            lastName: userLastName
        },
        contact_No: customerContactNo,
        address: customerAddress,
        email: customerDriverEmail,
        nic: customerNic,
        license_No: customerLicence,
        user: {
            user_Id: userID,
            user_Name: customerUserName,
            password: customerPassword
        }
    }

    $.ajax({
        url: userBaseUrl + "customer",
        method: "put",
        contentType: "application/json",
        data: JSON.stringify(CustomerOb),
        dataType: "json",
        success: function (res) {
            manageCustomerLoadTable();
            alert(res.message);
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end driver update -->

<!-- End User Section -->
