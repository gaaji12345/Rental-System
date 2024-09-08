$('#btnSign').click(function () {
    getallusers();
})

function getallusers() {

    let userName=$('#txtUserName').val();
    let password=$('#txtPassword').val();

    localStorage.setItem("username", userName);



    $.ajax({
        url: "http://localhost:8080/rental/user?userName="+userName,
        dataType: 'json',
        success: function (resp) {
            if (resp.password === password) {

                let currentDate = new Date().toJSON().slice(0, 10);

                const d = new Date();
                let hours =new Date().toLocaleTimeString();;

                let loginId = resp.userName+currentDate+hours;
                let us = $('#txtUserName').val();
                let password = $('#txtPassword').val();
                let role = resp.role;

                let user = {
                    userName:us,
                    password:password,
                    role:role
                }

                let loginDetail = {
                    loginID: loginId,
                    user: user,
                    date: currentDate,
                    time: hours
                }

                console.log(loginDetail);

                $.ajax({
                    url :"http://localhost:8080/rental/logindetail",
                    method : "post",
                    data : JSON.stringify(loginDetail),
                    contentType : 'application/json',
                    success:function(){
                        console.log("Success")
                    },
                    error : function(){
                        console.log("Error")
                    }
                });

                switch (resp.role) {
                    case "admin":
                        window.open("../pages/admin.html","_self");
                        break;

                    case "customer":
                        window.open("../pages/login.html","_self");
                        $('#txtLoggedCusName').text(userName);
                        break;

                    case "driver":
                        window.open("#","_self");
                        break;

                    default:
                        alert("Check Your User Name");
                        break;
                }


            }else{
                alert("Check Your Password");
            }
        },
        error: function (err) {
            console.log(err.message);
        }
    });
}
