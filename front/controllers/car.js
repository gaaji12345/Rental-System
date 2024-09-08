loadAllCars();
$('#carDetailsPopupBg').hide();

generateCarID();
function loadAllCars() {
    $("#tblDrivers").empty();
    $.ajax({
        url: "http://localhost:8080/rental/car",
        method: "GET",
        dataType: "json",
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let carID = i.carID;
                let regNo = i.regNo;
                let brand = i.brand;
                let type = i.type;
                let passenger = i.passenger;
                let color = i.color;
                let transmissionType = i.transmissionType;
                let fuelType = i.fuelType;
                let extraMileagePrice = i.extraMileagePrice;
                let currentMileage = i.currentMileage;
                let wavierPayment = i.wavierPayment;
                let availability = i.availability;
                let freeMileageDaily = i.freeMileageDaily;
                let freeMileageDailyPrice = i.freeMileageDailyPrice;
                let freeMileageMonthly = i.freeMileageMonthly;
                let freeMileageMonthlyPrice = i.freeMileageMonthlyPrice;
                let frontImage = i.frontImage;
                let rearImage = i.RearImage;
                let sideImage = i.sideImage;
                let interiorImage = i.interiorImage;


                console.log(frontImage);

                let row = "<tr><td>" + carID + "</td><td>" + type + "</td><td>" + brand + "</td><td>" + availability + "</td></tr>";
                $("#tblCars").append(row);
                bindTrEvents();

            }
            console.log(res.message);
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
}

// save car
$('#btnAddCar').click(function () {
    let formData = new FormData($("#carRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/rental/car",
        method: "post",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
            loadAllCars();
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});


function bindTrEvents() {
    $('#tblCars>tr').click(function () {
        let id = $(this).children().eq(0).text();
        console.log("row clicked")
        console.log(id);

        $('#carDetailsPopupBg').show();


        $.ajax({
            url: "http://localhost:8080/rental/car?carId="+id,
            method: "GET",
            contentType: "application/json",
            dataType: "json",
            success: function (res) {
                console.log(res);
                $("#lblCarId").text(res.carID);
                $("#lblregNo").text(res.regNo);
                $("#lblbrand").text(res.brand);
                $("#lbltype").text(res.type);
                $("#lblcolor").text(res.color);
                $("#lbltransmissionType").text(res.transmissionType);
                $("#lblfuelType").text(res.fuelType);
                $("#lblextraMileagePrice").text(res.extraMileagePrice);
                $("#lblCurrentMileage").text(res.currentMileage);
                $("#lblWaiverPayment").text(res.wavierPayment);
                $("#lblPassenger").text(res.passenger);
                $("#lblAvailability").text(res.availability);
                $("#lblfreeMileageDaily").text(res.freeMileageDaily);
                $("#lblfreeMileageDailyPrice").text(res.freeMileageDailyPrice);
                $("#lblfreeMileageMonthly").text(res.freeMileageMonthly);
                $("#lblfreeMileageMonthlyPrice").text(res.freeMileageMonthlyPrice);

                $("#frontImage").attr('src',"../"+res.frontImage);
                $("#RearImage").attr('src',"../"+res.rearImage);
                $("#sideImage").attr('src',"../"+res.sideImage);
                $("#interiorImage").attr('src',"../"+res.interiorImage);


                $('#btnEditCarDetail').click(function () {
                    $("#txtCarId").val(res.carID);
                    $("#txtCarRegNum").val(res.regNo);
                    $("#txtCarBrand").val(res.brand);
                    $("#txtCarType").val(res.type);
                    $("#txtCarNumPassengers").val(res.passenger);
                    $("#txtCarColour").val(res.color);
                    $("#txtCarTransmission").val(res.transmissionType);
                    $("#txtCarFuel").val(res.fuelType);
                    $("#txtExtraKMPrice").val(res.extraMileagePrice);
                    $("#txtcurrentMileage").val(res.currentMileage);
                    $("#txtWaiverPayment").val(res.wavierPayment);
                    $("#txtAvailability").val(res.availability);
                    $("#txtDailyRate").val(res.freeMileageDaily);
                    $("#txtCarDayPrice").val(res.freeMileageDailyPrice);
                    $("#txtFreeMileage").val(res.freeMileageMonthly);
                    $("#txtCarMonthlyPrice").val(res.freeMileageMonthlyPrice);




                    $('#carDetailsPopupBg').hide();
                })

            },
            error: function (error) {
                alert(error.responseJSON.message);
            }
        })
    })
}

$('#btnCloseCarDetail').click(function () {
    $('#carDetailsPopupBg').hide();
});


$("#btnDeleteCar").click(function () {
    let carId = $("#txtCarId").val();
    console.log(carId);
    $.ajax({
        url: "http://localhost:8080/rental/car?carId="+carId,
        method: "delete",
        dataType: "json",
        success: function (res) {
            alert(res.message)
            loadAllDrivers();
        }, error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});


$('#btnUpdateCar').click(function () {
    let formData = new FormData($("#carRegForm")[0]);
    console.log(formData);
    $.ajax({
        url:"http://localhost:8080/rental/car",
        method: "put",
        data: formData,
        async:true,
        contentType: false,
        processData: false,
        success: function (res) {
            alert(res.message);
        },
        error: function (error) {
            alert(error.responseJSON.message);
        }
    });
});

function generateCarID() {
    $("#txtCarId").val("CAR-001");
    $.ajax({
        url: "http://localhost:8080/rental/car/IdGenerate",
        method: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (resp) {
            let id = resp.value;
            console.log("id" + id);
            let tempId = parseInt(id.split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                $("#txtCarId").val("CAR-00" + tempId);
            } else if (tempId <= 99) {
                $("#txtCarId").val("CAR-0" + tempId);
            } else {
                $("#txtCarId").val("CAR-" + tempId);
            }
        },
        error: function (ob, statusText, error) {
        }
    });
}
