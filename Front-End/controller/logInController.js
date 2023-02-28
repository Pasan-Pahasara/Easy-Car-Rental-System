/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

let loginBaseUrl = "http://localhost:8080/Back_End_war/";
<!-- Start LogIn Section -->

<!-- start login using login button -->
$("#loginBtn").on('click', function () {
    login();
});
<!-- end login using login button -->

<!-- start login function -->
function login() {
    let loginRole_Type = $("#loginRole_Type").val();
    let loginUserName = $("#loginUserName").val();
    let loginPassword = $("#loginPassword").val();

    $.ajax({
        url: loginBaseUrl + "user",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            for (var login of res.data) {
                if (loginRole_Type === login.role_Type && loginUserName === login.user_Name && loginPassword === login.password) {
                    if (loginRole_Type === "DRIVER" && loginUserName === login.user_Name && loginPassword === login.password) {
                        $.ajax({
                            url: loginBaseUrl + "user/?username=" + loginUserName + "&password=" + loginPassword,
                            data:res.data,
                            method:"get",
                            success:function (res1) {
                            }
                        })
                        window.location.href = 'driverDashboard.html';
                    } else if (loginRole_Type === "REGISTERED_USER" && loginUserName === login.user_Name && loginPassword === login.password) {
                        $.ajax({
                            url: loginBaseUrl + "user/?username=" + loginUserName + "&password=" + loginPassword,
                            data:res.data,
                            method:"get",
                            success:function (res1) {
                            }
                        })
                        window.location.href = 'customerDashboard.html';
                    } else if (loginRole_Type === "ADMIN" && loginUserName === login.user_Name && loginPassword === login.password) {
                        window.location.href = 'adminDashboard.html';
                    }
                    return;
                }
            }
        }
    });
}
<!-- end login function -->

<!-- End LogIn Section -->
