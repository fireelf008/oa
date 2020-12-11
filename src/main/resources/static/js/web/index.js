function login() {
    var username = $("#username").val();
    var pwd = $("#pwd").val();
    $.post("/user/loginVali", {username: username, pwd: pwd}, function(result) {
        if (200 == result.status) {
            window.location = "/user/index";
        }
    });
}