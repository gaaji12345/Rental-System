$('#customersSec').hide();
$('#dashboardSec').show();
$('#carsSec').hide();
$('#driversSec').hide();
$('#rentalsSec').hide();
$('#paymentsSec').hide();

$('#btnSignOut').click(function () {
    window.history.back();
});

$('#customers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').show();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#dashboard-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").show();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#cars-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').show();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});

$('#drivers-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').show();
    $('#rentalsSec').hide();
    $('#paymentsSec').hide();
});



$('#rentals-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').show();
    $('#paymentsSec').hide();
});

$('#Payments-tab').click(function (e) {
    console.log("clicked");
    $("#dashboardSec").hide();
    $('#customersSec').hide();
    $('#carsSec').hide();
    $('#driversSec').hide();
    $('#rentalsSec').hide();
    $('#paymentsSec').show();
});
