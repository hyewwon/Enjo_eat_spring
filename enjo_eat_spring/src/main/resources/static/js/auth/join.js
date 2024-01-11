const joinform = document.getElementById("join_form");
const userid = document.getElementById("userid");
const password = document.getElementById("password");
const re_password = document.getElementById("re_password");
const btn_userid = document.getElementById("btn_userid");
let chk_userid = false;

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
async function checkUserId() {
    if (userid.value === "") {
        userid.focus();
        document.getElementById("userid_error").innerHTML = "<p style='color:red'>아이디를 입력해 주세요</p>";
        return false;
    }
    try {
        btn_userid.disabled = true;
        const response = await fetch("/auth-api/check-userid", {
            method: "POST",
            headers: {'X-CSRFToken': csrf_token},
            body: JSON.stringify({userid: userid.value,})
        });
        const result = await response.json();
        if (result.success === false) {
            btn_userid.disabled = false;
            alert("중복검사 에러!! 다시 시도...")
        } else {
            if (result.exist === true) {
                document.getElementById("userid_error").innerHTML = "<p style='color:red'>중복된 아이디 입니다</p>";
                btn_userid.disabled = false;

            } else {
                document.getElementById("userid_error").innerHTML = "<p style='color:green'>사용 가능한 아이디 입니다</p>";
                btn_userid.disabled = false;
                chk_userid = true;
            }
        }

    } catch (error) {
        alert(error);
        btn_userid.disabled = false;
    }

}

// 유효성 검사
function validation() {
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

