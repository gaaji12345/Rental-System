$('#rentCarDeBG').hide();
loadCarDetails();
generateRentID();
$('#loginBG').hide();

let userName = localStorage.getItem("username");

console.log(userName);

getCusDetail();



function loadCarDetails() {
    $("#carViewSection").empty();

    $.ajax({
        url: "http://localhost:8080/rental/car/view",
        method: "GET",
        dataType: "json",
        success: function (res) {
            generateRentID();

            console.log(res)

            for (let i of res) {

                console.log(i);

                let carDiv = $(`<div class="col-md-3 carViewDiv bg-white shadow rounded-2" >
          <div class="slideshow-container mt-3">
            <div class="slide fade">
              <img src="../${i.frontImage}" alt="Image 1" id="loadFrontImage" class="slideImg" width="100%">
            </div>
            <div class="slide fade">
              <img src="../${i.rearImage}" id="loadRearImage" class="slideImg" width="100%">
            </div>
            <div class="slide fade">
              <img src="../${i.sideImage}" id="loadSideImage" class="slideImg" width="100%">
            </div>
            <div class="slide fade">
              <img src="../${i.interiorImage}" id="loadInteriorImage" class="slideImg" width="100%">
            </div>
        </div>

        <div class="text-center bg-primary text-white rounded">
          <h5 id="loadCarBrand">${i.brand}</h5>
        </div>
        
        <p class="visually-hidden" id="txtCarId2">${i.carID}</p>

        <div class="d-flex w-100 mb-0">

          <div class="w-50" >
            <ul>
              <li id="loadCarPassengers">${i.passenger} Passengers</li>
              <li id="loadTransmissionType">${i.transmissionType} Gear</li>
            </ul>
          </div>

          <div class="w-50 mb-0">
            <ul class="mb-0">
              <li id="loadCarColor">${i.color} Color</li>
              <li id="loadFuelType">${i.fuelType}</li>
            </ul>
          </div>

        </div>

        <p class="text-center text-secondary mt-0 mb-0" id="loadExtraMileagePrice">Rs.${i.extraMileagePrice} for Extra Km</p>


        <p class="text-center bg-secondary-subtle text-muted mt-0" id="loadwaiverAmount">Wavier Payment is Rs.${i.wavierPayment}</p>

        <div class="d-flex w-100">
          <div class="w-50 text-center bg-secondary rounded text-white me-2">
            <p class="m-0">Daily</p>
            <h5 class="m-0 bg-dark" id="loadDailyMilleagePrice">Rs.${i.freeMileageDailyPrice}</h5>
            <p class="m-0" id="loadDailyMilleage">for ${i.freeMileageDaily}km</p>
          </div>
          <div class="w-50 text-center bg-secondary rounded text-white">
            <p class="m-0">Monthly</p>
            <h5 class="m-0 bg-dark" id="loadMonthlyMilleagePrrice">Rs.${i.freeMileageMonthlyPrice}</h5>
            <p class="m-0" id="loadMonthlyMilleage">for ${i.freeMileageMonthly}km</p>
          </div>

        </div>

        <div class="d-flex w-100 mt-5">
          <button class="btn w-50 bg-primary me-2 text-white" id="btnBookNowView" onclick="btnBookNowView()"><i class="fa-solid fa-receipt me-2"></i>Book Now</button>
          <button class="btn w-50 bg-dark text-white btnAddToCart"><i class="fa-solid fa-list me-2"></i>Add To List</button>
        </div>

      </div>`);
                // let url1 = i.image.front_View;
                $("#carViewSection").append(carDiv)

                let currentSlide = 0;
                const slides = document.querySelectorAll('.slide');

                function showSlide(index) {
                    if (index < 0) {
                        index = slides.length - 1;
                    } else if (index >= slides.length) {
                        index = 0;
                    }

                    slides[currentSlide].style.display = 'none';
                    slides[index].style.display = 'block';

                    currentSlide = index;
                }

                function nextSlide() {
                    showSlide(currentSlide + 1);
                }

                function startSlideshow() {
                    setInterval(nextSlide, 3000); // Change the interval as needed (e.g., 3000 milliseconds = 3 seconds)
                }

// Initial display of the first slide
                showSlide(currentSlide);
                startSlideshow();


            }
            $(".btnAddToCart").click(function () {
                let carIdClicked = $(this).parent().parent().children(":eq(2)").text();
                console.log(carIdClicked);


                for (let k= 0; k < res.length; k++) {
                    if (res[k].carID == carIdClicked) {
                        let carId = res[k].carID;
                        // let reg = cars[k].regNo;
                        let brand = res[k].brand;
                        let transmissionType = res[k].transmissionType;
                        let passenger = res[k].passenger;
                        let fuel = res[k].fuelType;
                        let wavier = res[k].wavierPayment;
                        let price = res[k].freeMileageDailyPrice;


                        let row = `<tr><td class="visually-hidden">${carId}</td><td>${brand}</td><td>${wavier}</td>    
                                         <td><input class="form-check-input form-check form-switch border rounded" type="checkbox" id="flexSwitchCheckDefault"></td>
                                         <td><input type="file" class="form-control" id="inputSlipImg"></td> 
                                         <td><button type="button" class="btn btn-danger cartDeleteBtn">Remove</button></td>
                                        </tr>`;

                        $('#tblCart').append(row);

                        removeRow();
                    }
                }
            });

        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });

}

function btnBookNowView() {
    console.log("clicked")
    $('#rentCarDeBG').show();

}

$('#btnCloseRentDetail').click(function () {
    $('#rentCarDeBG').hide();
});



$('#btnViewCart').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});


$("#btnRequestRentr").click(function () {
    let formData = new FormData($("#rentReqForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/rental/rent",
        method: "post",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
            loadAllCustomers();
        },
        error: function (error) {
            // alert(error.responseJSON.message);
        }
    });


});


function removeRow() {
    $('.cartDeleteBtn').off('click');
    $('.cartDeleteBtn').click(function () {
        $(this).closest('tr').remove();
    });
}


$("#btnRequestRent").click(function () {
    console.log("Clicked");
    let rentDetails = [];
    for (let i = 0; i < $("#tblCart tr").length; i++) {

        let plusOne=i+1;
        let rentID=$("#txtRentID2").val();

        let payment = {
            paymentID : "PAY-"+rentID+"-"+plusOne,
            waiverDeductions : 0,
            waiverSlip : null,
            extraMileagePayment : 0
        }
        var rentDetail = {
            carID: $("#tblCart").children(`:eq(${i})`).children(":eq(0)").text(),
            rentID: $("#txtRentID2").val(),
            driverID: "DRI-001",
            payment:payment
        }
        rentDetails.push(rentDetail);
    }

    // for (let i = 0; i < $("#tblCart tr").length; i++) {
    let rentID = $("#txtRentID2").val();
    let pickUpDate = $("#txtPickupDate2").val();
    let pickUpTime = $("#txtPickupTime2").val();
    let duration = $("#txtDuration2").val();
    let rentType = "PENDING";
    let customerID = $('#txtLoggedCusID').text();

    console.log(customerID);

    let rentOB = {
        rentID: rentID,
        pickupDate: pickUpDate,
        pickupTime: pickUpTime,
        duration: duration,
        status: rentType,
        customerID: customerID,
        rentDetails: rentDetails
    }
    // console.log(rentDetails)
    console.log(rentOB)


    $.ajax({
        url: "http://localhost:8080/rental/rent/manyRents",
        method: "POST",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(rentOB),
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            console.log(error);
            // let message = JSON.parse(error.responseText).message;
            // unSuccessUpdateAlert("Rent", message);
        }

    });
    // }
    // $("#cartTable").empty();
});


function generateRentID() {
    // $("#txtRentID2").val("R00-001");
    // $("#txtRentID").val("R00-001");
    // $.ajax({
    //     url: "http://localhost:8080/rental/rent/IdGenerate",
    //     method: "GET",
    //     contentType: "application/json",
    //     dataType: "json",
    //     success: function (resp) {
    //         let id = resp.value;
    //         console.log("id" + id);
    //         let tempId = parseInt(id.split("-")[1]);
    //         tempId = tempId + 1;
    //         if (tempId <= 9) {
    //             $("#txtRentID2").val("R00-00" + tempId);
    //             $("#txtRentID").val("R00-00" + tempId);
    //         } else if (tempId <= 99) {
    //             $("#txtRentID2").val("R00-0" + tempId);
    //             $("#txtRentID").val("R00-0" + tempId);
    //         } else {
    //             $("#txtRentID2").val("R00-" + tempId);
    //             $("#txtRentID").val("R00-" + tempId);
    //         }
    //     },
    //     error: function (error) {
    //         console.log(error);
    //     }
    // });
    $("#txtRentID2").val("R00-001");
    $("#txtRentID").val("R00-001");

    // Perform the AJAX request to get the current ID from the server
    $.ajax({
        url: "http://localhost:8080/rental/rent/IdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("Current ID: " + id);

            // Ensure the ID is in the correct format and split properly
            let parts = id.split("-");
            if (parts.length !== 2) {
                console.error("Unexpected ID format: " + id);
                return;
            }

            let numericPart = parts[1];
            let tempId = parseInt(numericPart, 10);

            // Increment the numeric part
            tempId = tempId + 1;

            // Format the new ID with leading zeros
            let newId = "R00-" + String(tempId).padStart(3, '0');
            $("#txtRentID2").val(newId);
            $("#txtRentID").val(newId);
        },
        error: function (error) {
            console.log("Error fetching the ID: ", error);
        }
    });
}

function getCusDetail(){
    let userNameSend= userName;

    $.ajax({
        url: "http://localhost:8080/rental/customer?userName="+userNameSend,
        method:"post",

        success:function (res) {
            console.log(res);
            let id = res.data.customerID;
            let name = res.data.name;

            $('#txtLoggedCusName').text(name);
            $('#txtLoggedCusID').text(id);


            console.log(name);
            console.log(id);


        },

        error:function (error) {

        }

    })

}
