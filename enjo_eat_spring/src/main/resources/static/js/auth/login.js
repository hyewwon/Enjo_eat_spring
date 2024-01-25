const btn_login = document.getElementById("btn_login");
const userid = document.getElementById("userid");
const password = document.getElementById("password");
const loginForm = document.getElementById("login_form");

function login(){
    if(userid.value === ""){
        userid.focus();
        document.getElementById("userid_error").innerHTML = "<p style='color:red'>아이디를 입력해 주세요</p>";
        return false;
    }
    if(password.value === ""){
        password.focus();
        document.getElementById("password_error").innerHTML = "<p style='color:red'>비밀번호를 입력해 주세요</p>";
        return false;
    }
    loginForm.submit();
}

userid.oninput = function(){
    document.getElementById("userid_error").innerHTML = "";
    document.getElementById("login_error").innerHTML = "";
}
password.oninput = function(){
    document.getElementById("password_error").innerHTML = "";
    document.getElementById("login_error").innerHTML = "";
}

function enterkey() {
    if (window.keyCode === 13) {
        btn_login.click()
    }
}

