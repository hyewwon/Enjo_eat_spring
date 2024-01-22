const btn_login = document.getElementById("btn_login");
const userid = document.getElementById("userid");
const password = document.getElementById("password");

async function login(){
    try{
        if(validation() === false){
            return false;
        }
        const response = await fetch('/security/login',{
            method:"POST",
            headers: {csrf_header: csrf_token, 'Content-Type' : "application/json"},
            body: JSON.stringify({
                "userid": userid.value,
                "password" : password.value
            })
        })
        const result = await response.json();
        console.log(response);
        console.log(result)
        if(response.status !== 200){
            alert("로그인 오류... 관리자에게 문의해주세요.");
        }else{
            if(result.check === "fail"){
                document.getElementById("login_error").innerHTML = "<p style='color:red'>아이디 혹은 비밀번호가 틀립니다.</p>";
            }else{
                location.href = "/"
            }
        }
    }catch(error){
        alert(error)
    }
}



function validation(){

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
}

userid.oninput = function(){
    document.getElementById("userid_error").innerHTML = "";
    document.getElementById("login_error").innerHTML = "";
}
password.oninput = function(){
    document.getElementById("password_error").innerHTML = "";
    document.getElementById("login_error").innerHTML = "";
}

