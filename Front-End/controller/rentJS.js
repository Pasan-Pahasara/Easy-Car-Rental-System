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

$("#carID").on('click',function () {
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


