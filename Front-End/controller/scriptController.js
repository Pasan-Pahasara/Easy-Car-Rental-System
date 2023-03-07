/**
 * @author : Pasan Pahasara
 * @since : 0.1.0
 **/

/**
 * Reviews Section Swiper Start
 */
var swiper = new Swiper(".slide-content", {
    slidesPerView: 3,
    spaceBetween: 25,
    loop: true,
    centerSlide: 'true',
    fade: 'true',
    grabCursor: 'true',
    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
        dynamicBullets: true,
    },
    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },

    breakpoints: {
        0: {
            slidesPerView: 1,
        },
        520: {
            slidesPerView: 2,
        },
        950: {
            slidesPerView: 3,
        },
    },
});
/**
 * Reviews Section Swiper End
 */

let indexBaseUrl = "http://localhost:8080/Back_End_war/";

loadAllCars();
function loadAllCars() {
    $("#carSection").empty();
    $.ajax({
        url: indexBaseUrl + "car/getAvailableCars",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (res) {
            let count = 0;
            for (let car of res.data) {
                let url = car.image.front_View;
                console.log(car);
                if (count%3==0){
                    $("#carSection").append(`<div class="swiper-slide"></div>`);
                }
                $("#carSection>div:last-child").append(`<div class="featured-car-card">
                                <figure class="card-banner">
                                    <img src="${indexBaseUrl + url}" alt="${car.car_name}" loading="lazy"
                                         width="440" height="300"
                                         class="w-100">
                                </figure>

                                <div class="card-content">

                                    <div class="card-title-wrapper">
                                        <h3 class="h3 card-title">
                                            <a href="#">${car.car_name}</a>
                                        </h3>

                                        <data class="year" value="${new Date().getFullYear()}">${new Date().getFullYear()}</data>
                                    </div>

                                    <ul class="card-list">

                                        <li class="card-list-item">
                                            <ion-icon name="people-outline"></ion-icon>

                                            <span class="card-item-text">${car.number_Of_Passengers} People</span>
                                        </li>

                                        <li class="card-list-item">
                                            <ion-icon name="flash-outline"></ion-icon>

                                            <span class="card-item-text">${car.fuel_Type}</span>
                                        </li>

                                        <li class="card-list-item">
                                            <ion-icon name="speedometer-outline"></ion-icon>

                                            <span class="card-item-text">6.1km / 1-litre</span>
                                        </li>

                                        <li class="card-list-item">
                                            <ion-icon name="hardware-chip-outline"></ion-icon>

                                            <span class="card-item-text">${car.transmission_Type}</span>
                                        </li>

                                    </ul>

                                    <div class="card-price-wrapper">

                                        <p class="card-price">
                                            <strong>Rs: ${car.rent_Duration_Price.monthly_Rate}</strong> / month
                                        </p>

                                        <button class="btn fav-btn" aria-label="Add to favourite list">
                                            <ion-icon name="heart-outline"></ion-icon>
                                        </button>

                                        <button class="btn">Rent now</button>

                                    </div>
                                </div>
                                </div>`);
                count++;
            }
        }
    });
}
