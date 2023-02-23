/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/
let rentBaseUrl = "http://localhost:8080/Back_End_war/";

$("#fuelType").on('click',function () {
    let carType = $("#carType").val();
    let fuel_Type = $("#fuelType").val();
    console.log(carType);
    console.log(fuel_Type);
    $("#carID").empty();
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


