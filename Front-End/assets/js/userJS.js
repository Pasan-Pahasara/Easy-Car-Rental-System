/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let baseUrl = "http://localhost:8080/Back_End_war/";
manageCustomerLoadTable();

$("#addCustomerBtn").on('click', function () {
    let formData = new FormData($("#customerForm")[0]);
    console.log(formData);
    $.ajax({
        url: baseUrl + "customer",
        method: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function (res) {
            manageCustomerLoadTable();
        }, error: function (error) {

        }
    });
});


<!-- start load customer function -->
function manageCustomerLoadTable() {
    $("#tblCustomerDetails").empty();
    $.ajax({
        url: baseUrl + "customer",
        method: "get",
        contentType: "application/json",
        success: function (resp) {
            for (let customerDetails of resp.data) {
                let row = `<tr><td>${customerDetails.user_Id}</td><td>${customerDetails.name.firstName}</td><td>${customerDetails.name.lastName}</td><td>${customerDetails.contact_No}</td><td>${customerDetails.address}</td><td>${customerDetails.email}</td><td>${customerDetails.nic}</td><td>${customerDetails.license_No}</td><td>${customerDetails.user.user_Name}</td><td>${customerDetails.user.password}</td></tr>`;
                $("#tblCustomerDetails").append(row);
            }
            carBindClickEvents();
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}
<!-- end load customer function -->