$('#loginBG').hide();

// loadCarDetails();

$('#btnViewSignIn').click(function () {
    $('#loginBG').show();
});

$('#closeLogin').click(function () {
    $('#loginBG').hide();
});

function btnBookNowView() {
    console.log("clicked")
    alert("Please Log In to System for Rent a Car")
}

function btnAddToListView() {
    console.log("clicked")
    alert("Please Log In to System for Add To List")
}
