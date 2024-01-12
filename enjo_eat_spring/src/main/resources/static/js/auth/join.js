const joinform = document.getElementById("join_form");
const userid = document.getElementById("userid");
const username = document.getElementById("username");
const password = document.getElementById("password");
const re_password = document.getElementById("re_password");
let chk_userid = false;
let chk_username = false;

// 회원가입
async function join() {
    if (validation() === false) {
        return false;
    }
    if (!confirm("가입 하시겠습니까?")) {
        return false;
    }
    try {
        const response = await fetch("/auth-api/join", {
            method: "POST",
            headers: {'X-CSRFToken': csrf_token},
            body: joinform
        });
        const result = response.json();
        if (result === true) {
            alert("가입 성공 !!");
            location.href = "/";
        }
    }
    catch(error){
        alert(error);
    }
}

// 아이디 중복 검사
async function checkUserData(check_type) {
    let data = "";
    if(check_type === "username"){
        if(username.value === ""){
            username.focus();
            document.getElementById("username_error").innerHTML = "<p style='color:red'>닉네임 입력해 주세요</p>";
            return false;
        }
        data = username.value;
    }else if(check_type === "userid"){
        if (userid.value === "") {
            userid.focus();
            document.getElementById("userid_error").innerHTML = "<p style='color:red'>아이디를 입력해 주세요</p>";
            return false;
        }
        data = userid.value;
    }
    console.log(csrf_token, csrf_header)
    try {
        const response = await fetch(window.location.origin + "/auth-api/check-userData", {
            method: "POST",
            headers: {csrf_header: csrf_token},
            body: JSON.stringify({
                "type" : check_type,
                "data" : data
            })
        });
        const result = await response.json();
        if (result.success === false) {
            alert("중복검사 에러!! 다시 시도...")
        } else {
            if (result.success === true) {
                if(check_type === "userid"){
                    document.getElementById("userid_error").innerHTML = "<p style='color:green'>사용 가능한 아이디 입니다</p>";
                    chk_userid = true;
                }else if(check_type === "username"){
                    document.getElementById("userid_error").innerHTML = "<p style='color:green'>사용 가능한 닉네임 입니다</p>";
                    chk_username = true;
                }
            } else {
                if(check_type === "userid"){
                    document.getElementById("username_error").innerHTML = "<p style='color:red'>중복된 아이디 입니다</p>"
                }else if(check_type === "username"){}
                    document.getElementById("username_error").innerHTML = "<p style='color:red'>중복된 닉네임 입니다</p>"
            }
        }

    } catch (error) {
        alert(error);
    }
}


// 유효성 검사
function validation() {
    if(username.value === ""){
        username.focus();
        document.getElementById("username_error").innerHTML = "<p style='color:red'>닉네임 입력해 주세요</p>";
        return false;
    }
    if(chk_username === false){
        username.focus();
        document.getElementById("username_error").innerHTML = "<p style='color:red'>닉네임 중복검사를 해주세요</p>";
        return false;
    }
    if (userid.value === "") {
        userid.focus();
        document.getElementById("userid_error").innerHTML = "<p style='color:red'>아이디를 입력해 주세요</p>";
        return false;
    }
    if (userid.value.length < 5) {
        userid.focus();
        document.getElementById("userid_error").innerHTML = "<p style='color:red'>아이디는 5글자 이상입니다</p>";
        return false;
    }
    if (chk_userid === false) {
        userid.focus();
        document.getElementById("userid_error").innerHTML = "<p style='color:red'>중복검사를 해주세요</p>";
        return false;
    }
    if (password.value === "") {
        password.focus();
        document.getElementById("password_error").innerHTML = "<p style='color:red'>비밀번호를 입력해 주세요</p>";
        return false;
    }
    if (password.value.length < 5) {
        password.focus();
        document.getElementById("password_error").innerHTML = "<p style='color:red'>비밀번호는 5글자 이상입니다.</p>";
        return false;
    }
    if (re_password.value === "") {
        re_password.focus();
        document.getElementById("re_password_error").innerHTML = "<p style='color:red'>비밀번호 확인을 입력해 주세요</p>";
        return false;
    }
    if (password.value !== re_password.value) {
        re_password.focus();
        document.getElementById("re_password_error").innerHTML = "<p style='color:red'>비밀번호가 다릅니다</p>";
        return false;
    }
}

username.oninput = function (){
    document.getElementById("username_error").innerHTML = "";
    chk_username = false;
}
userid.oninput = function () {
    document.getElementById("userid_error").innerHTML = "";
    chk_userid = false;
}
password.oninput = function () {
    document.getElementById("password_error").innerHTML = "";
}
re_password.oninput = function () {
    document.getElementById("re_password_error").innerHTML = "";
}

