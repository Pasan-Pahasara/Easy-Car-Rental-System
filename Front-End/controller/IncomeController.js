let baseUrlIncome = "http://localhost:8080/Back_End_war/";

dailyIncome();
monthlyIncome();
yearlyIncome();

<!-- Start Daily Income function -->
function dailyIncome() {
    $.ajax({
        url: baseUrlIncome + "income/dailyIncome",
        method: "GET",
        dataType: "json",
        success: function (res) {
            for (let i=0; i<res.length; i++) {
                $("#tblDaily").append(`<tr><td>${res[i][0]}</td><td>${res[i][1]}</td><td>${res[i][2]}</td></tr>`);
            }
        }

    });
}
<!-- End Daily Income function -->

<!-- Start Monthly Income function -->
function monthlyIncome() {
    $.ajax({
        url: baseUrlIncome + "income/monthlyIncome",
        method: "GET",
        dataType: "json",
        success: function (res) {
            for (let i=0; i<res.length; i++) {
                $("#tblMonthly").append(`<tr><td>${res[i][0]}</td><td>${res[i][1]}</td><td>${res[i][2]}</td></tr>`);
            }
        }

    });
}
<!-- End Monthly Income function -->

<!-- Start Monthly Income function -->
function yearlyIncome() {
    $.ajax({
        url: baseUrlIncome + "income/AnnuallyIncome",
        method: "GET",
        dataType: "json",
        success: function (res) {
            for (let i=0; i<res.length; i++) {
                $("#tblYearly").append(`<tr><td>${res[i][0]}</td><td>${res[i][1]}</td><td>${res[i][2]}</td></tr>`);
            }
        }

    });
}
<!-- End Monthly Income function -->
