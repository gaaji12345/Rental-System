getAllPayments();
function getAllPayments() {
    $("#tblPayments").empty();
    $.ajax({
        url: "http://localhost:8080/rental/payment",
        method: "GET",
        dataType: "json",
        // enctype:"multipart/form-data",
        // contentType: false,
        success: function (res) {
            console.log(res);

            for (let i of res.data) {
                let paymentID = i.paymentID;
                const waiverDeductions = String(i.waiverDeductions);
                let paymentSlip = i.waiverSlip;
                let extraMilleagePayment = String(i.extraMileagePayment);

                console.log(paymentSlip)

                let row = "<tr><td>" + paymentID + "</td><td><img src=' "+"../"+paymentSlip+" ' width='100px'></td><td>" + waiverDeductions + "</td><td>"+extraMilleagePayment+"</td></tr>";
                $("#tblPayments").append(row);

                // console.log(forntImage);
            }
            console.log(res.message);
        }, error: function (error) {
            // alert(error.responseJSON.message);
        }
    });
}
