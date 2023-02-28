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
        dataType: "json",
        success: function (res) {
            alert(res.message);
            manageCustomerLoadTable();
            setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
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
        dataType: "json",
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
        dataType: "json",
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
    $("#userFirstName,#cusFirstName").val(userFirstName);
    $("#userLastName,#cusLastName").val(userLastName);
    $("#customerContactNo,#contactNo").val(customerContactNo);
    $("#customerAddress,#address").val(customerAddress);
    $("#customerDriverEmail,#cusEmail").val(customerDriverEmail);
    $("#customerNic,#nicNo").val(customerNic);
    $("#customerLicence,#cusLicence").val(customerLicence);
    $("#customerUserName,#cusUserName").val(customerUserName);
    $("#customerPassword,#cusPassword").val(customerPassword);
    $(".form-control").css({
        "border": "1px solid #dee2e6"
    });
}

<!-- end set text fields values function -->

<!-- start customer delete -->
$("#deleteCustomer").on('click', function () {
    let userID = $("#userID").val();
    $.ajax({
        url: userBaseUrl + "customer?user_Id=" + userID,
        method: "DELETE",
        dataType: "json",
        success: function (res) {
            manageCustomerLoadTable();
            alert(res.message);
            setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end customer delete -->

<!-- start customer update -->
$("#updateCustomer").on('click', function () {
    let formData = new FormData($("#customerDetailsForm")[0]);
    console.log(formData);
    $.ajax({
        url: userBaseUrl + "customer/update",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        dataType: "json",
        success: function (res) {
            alert(res.message);
            setTextFieldValuesCustomer("", "", "", "", "", "", "", "", "", "");
            manageCustomerLoadTable();
        }, error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
});
<!-- end customer update -->

//<!------------------------------------ RegEx Customer ------------------------------------>

<!-- start regex patterns -->
const regExCusFirstName = /^[A-z ]{3,20}$/;
const regExCusLastName = /^[A-z ]{3,20}$/;
const regExCusContactNumber = /^(07(0|1|2|4|5|6|7|8)[0-9]{7})$/;
const regExCusAddress = /^[A-z0-9/ ]{4,30}$/;
const regExCusEmailAddress = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
const regExCusNic = /^([0-9]{12}|[0-9V]{10}|[0-9v]{10})$/;
const regExCusLicense = /^([0-9]{12})$/;
const regExCusUserName = /^[A-z0-9/ ]{4,30}$/;
const regExCusPassword = /^([A-Z a-z]{5,15}[0-9]{1,10})$/;
<!-- end regex patterns -->

// customer validation array
let cusValidations = [];

cusValidations.push({
    cusReg: regExCusFirstName,
    cusField: $('#cusFirstName')
});
cusValidations.push({
    cusReg: regExCusLastName,
    cusField: $('#cusLastName')
});
cusValidations.push({
    cusReg: regExCusContactNumber,
    cusField: $('#contactNo')
});
cusValidations.push({
    cusReg: regExCusAddress,
    cusField: $('#address')
});
cusValidations.push({
    cusReg: regExCusEmailAddress,
    cusField: $('#cusEmail')
});
cusValidations.push({
    cusReg: regExCusNic,
    cusField: $('#nicNo')
});
cusValidations.push({
    cusReg: regExCusLicense,
    cusField: $('#cusLicence')
});
cusValidations.push({
    cusReg: regExCusUserName,
    cusField: $('#cusUserName')
});
cusValidations.push({
    cusReg: regExCusPassword,
    cusField: $('#cusPassword')
});

// disable tab key of all four text fields using grouping selector in CSS
$("#cusFirstName, #cusLastName, #contactNo, #address,#cusEmail, #nicNo, #cusLicence, #cusUserName,#cusPassword").on('keydown', function (event) {
    if (event.key === "Tab") {
        event.preventDefault();
    }
});

// grouping all fields keyup event using and call check validity function
$("#cusFirstName, #cusLastName, #contactNo, #address,#cusEmail, #nicNo, #cusLicence, #cusUserName,#cusPassword").on('keyup', function (event) {
    checkCusValidity();
});

// grouping all fields blur event using and call check validity function
$("#cusFirstName, #cusLastName, #contactNo, #address,#cusEmail, #nicNo, #cusLicence, #cusUserName,#cusPassword").on('blur', function (event) {
    checkCusValidity();
});

// customer-first-name focus event
$("#cusFirstName").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusFirstName, $("#cusFirstName"))) {
        $("#cusLastName").focus();
    } else {
        focusCusText($("#cusFirstName"));
    }
});

// customer-last-name focus event
$("#cusLastName").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusLastName, $("#cusLastName"))) {
        focusCusText($("#contactNo"));
    }
});

// customer-contact focus event
$("#contactNo").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusContactNumber, $("#contactNo"))) {
        focusCusText($("#address"));
    }
});

// customer-address focus event
$("#address").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusAddress, $("#address"))) {
        focusCusText($("#cusEmail"));
    }
});

// customer-email focus event
$("#cusEmail").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusEmailAddress, $("#cusEmail"))) {
        focusCusText($("#nicNo"));
    }
});

// customer-nic focus event
$("#nicNo").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusNic, $("#nicNo"))) {
       $("#imgNiC").focus();
    }
});

// customer-nic-img focus event
$("#imgNiC").on('keydown', function (event) {
    if (event.key === "Enter") {
        focusCusText($("#cusLicence"));
    }
});

// customer-licence focus event
$("#cusLicence").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusLicense, $("#cusLicence"))) {
        $("#imgLicence").focus();
    }
});

// customer-licence-img focus event
$("#imgLicence").on('keydown', function (event) {
    if (event.key === "Enter") {
        focusCusText($("#cusUserName"));
    }
});

// customer-user-name focus event
$("#cusUserName").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusUserName, $("#cusUserName"))) {
        focusCusText($("#cusPassword"));
    }
});

// customer-password focus event
$("#cusPassword").on('keydown', function (event) {
    if (event.key === "Enter" && cusCheck(regExCusPassword, $("#cusPassword"))) {
        $("#addCustomerBtn").focus();
    }
});

// check validity function
function checkCusValidity() {
    let cusErrorCount = 0;
    for (let cusValidation of cusValidations) {
        if (cusCheck(cusValidation.cusReg, cusValidation.cusField)) {
            textItemSuccess(cusValidation.cusField, "");
        } else {
            cusErrorCount = cusErrorCount + 1;
            setItemTextError(cusValidation.cusField);
        }
    }
    setItemButtonState(cusErrorCount);
}

// check regex pattern function
function cusCheck(regex, txtField) {
    let cusInputValue = txtField.val();
    return regex.test(cusInputValue) ? true : false;
}

// error text fields function
function setItemTextError(txtField) {
    if (txtField.val().length <= 0) {
        defaultItemText(txtField, "");
    } else {
        txtField.css('border', '2px solid red');
    }
}

// success text fields function
function textItemSuccess(txtField) {
    if (txtField.val().length <= 0) {
        defaultItemText(txtField, "");
    } else {
        txtField.css('border', '2px solid green');
    }
}

// default text fields function
function defaultItemText(txtField) {
    txtField.css("border", "1px solid #ced4da");
}

// focus texts function
function focusCusText(txtField) {
    txtField.focus();
}

// button state function
function setItemButtonState(value) {
    if (value > 0) {
        $("#addCustomerBtn").attr('disabled', true);
    } else {
        $("#addCustomerBtn").attr('disabled', false);
    }
}

// Regex Patterns End

<!-- End User Section -->
