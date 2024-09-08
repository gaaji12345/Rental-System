getAllRents();


$('#rentalDetailsPopupBg').hide();
function getAllRents() {
    $("#tblRentRequests").empty();
    $.ajax({
        url: "http://localhost:8080/rental/rent/get",
        method: "GET",
        dataType: "json",
        // enctype:"multipart/form-data",
        // contentType: false,
        success: function (res) {
            let resData = res.data;


            console.log(res);

            for (let i of res.data) {
                let rentId = i.rentID;
                let cusId = i.customerID;
                let pickupDate = i.pickupDate;
                let pickupTime = i.pickupTime;
                let duration = i.duration;
                let status = i.status;
                let declineReason = i.declineReason;

                let row = "<tr><td>" + rentId + "</td><td>" + cusId + "</td><td>" + pickupDate + "</td><td>" + pickupTime + "</td><td>" + duration + "</td><td>" + status + "</td></tr>";
                $("#tblRentRequests").append(row);

                rentReqTableBindEvents();

                // console.log(forntImage);
            }
            function rentReqTableBindEvents() {
                $('#tblRentRequests>tr').click(function () {
                    $('#rentalDetailsPopupBg').show();
                    $('#tblPopupRent').empty();
                    let clickedRentId = $(this).children().eq(0).text();
                    let clickedCusId = $(this).children().eq(1).text();
                    let clickedPickupDate = $(this).children().eq(2).text();
                    let clickedPickupTime = $(this).children().eq(3).text();
                    let clickedDuration = $(this).children().eq(4).text();
                    let currentStatus = $(this).children().eq(5).text();


                    $('#lblRentId').text(clickedRentId);
                    $('#lblCusId').text(clickedCusId);
                    $('#lblPickupDate').text(clickedPickupDate);
                    $('#lblPickupTime').text(clickedPickupTime);
                    $('#lblDuration').text(clickedDuration);
                    $('#lblCurrentStatus').text(currentStatus);


                    // $('#rentIdtoHide').text(clickedRentId);

                    for(let k = 0; k < resData.length; k++){

                        if(resData[k].rentID == clickedRentId){

                            for(let u = 0; u < resData[k].rentDetails.length; u++){

                                let carID = resData[k].rentDetails[u].carID;
                                let paymentID = resData[k].rentDetails[u].payment.paymentID;
                                let wavier = resData[k].rentDetails[u].payment.waiverSlip;;
                                let driverID = resData[k].rentDetails[u].driverID

                                let row =`<tr><td>${carID}</td><td>${driverID}</td><td>${paymentID}</td><td><img src=' "+"/"+${wavier}+" ' width='100px'></td><td><button class='btn btn-dark btnPayLoad'>Pay Now</button></td></tr>`;
                                $('#tblPopupRent').append(row);


                                $('.btnPayLoad').click(function () {
                                    let clickedCarID = ($(this).closest('tr').children(1).eq(0).text());
                                    let clickedDriverID = $(this).closest('tr').children(1).eq(1).text();
                                    let clickedPaymentID = $(this).closest('tr').children(1).eq(2).text();


                                    $.ajax({
                                        url: "http://localhost:8080/rental/car?car_id=" + clickedCarID,
                                        method: "GET",
                                        success: function (resp) {

                                            console.log(resp);

                                            let car = resp.data;

                                            let dailyPrice=car.freeMileageDailyPrice;
                                            let dailyMillege=car.freeMileageDaily;
                                            let extraKmPrice=car.extraMileagePrice;


                                            $('#dailyPriceInput').val(dailyPrice);
                                            $('#dailyKmInput').val(dailyMillege);
                                            $('#pricePerExtraKm').val(extraKmPrice);


                                            $('#extraKms').keydown(function (event){

                                                if (event.key==='Enter'){
                                                    let extraTotal = Number($('#pricePerExtraKm').val())*Number($('#extraKms').val());
                                                    let total =Number(extraTotal)+Number($('#dailyPriceInput').val());

                                                    $('#inputTotal').val(total);



                                                    $.ajax({
                                                        url:"http://localhost:8080/rental/payment?paymentID="+clickedPaymentID+"&total="+total,
                                                        method:"post",

                                                        success:function (res) {

                                                        },

                                                        error:function (error) {

                                                        }

                                                    })
                                                    //purchaseOrder();
                                                }

                                            });


                                        },
                                        error: function () {

                                        }
                                    });

                                })
                            }

                            break;
                        }

                    }

                });
            }

            console.log(res.message);
        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });
}

$('#btnRentalPopupClose').click(function () {
    $('#rentalDetailsPopupBg').hide();

})

$('#btnRentStatusUpdate').click(function () {

    let updateId=$('#lblRentId').text();
    let updatedStatus=$('#txtStatusRent').val();
    console.log(updatedStatus);

    $.ajax({
        url: "http://localhost:8080/rental/rent?rentID="+updateId+"&status="+updatedStatus,
        method: "post",
        async:false,
        success:function (res) {
        },

        error:function (error) {
            console.log(error);
        }
    });

});
