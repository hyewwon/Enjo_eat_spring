const group_name = document.getElementById("name");
const group_location = document.getElementById("location");
const group_comment = document.getElementById("comment");

function validation(){
    if(group_name.value === ""){
        group_name.focus();
        document.getElementById("name_error").innerHTML = "<p style='color:red;'>테마 이름을 작성해 주세요</p>";
        return false;
    }
    if(group_location.value === ""){
        group_location.focus();
        document.getElementById("location_error").innerHTML = "<p style='color:red;'>주요 지역을 작성해 주세요</p>";
        return false;
    }
    if(group_comment.value === ""){
        group_comment.focus();
        document.getElementById("comment_error").innerHTML = "<p style='color:red;'>테마 소개를 작성해 주세요</p>";
        return false;
    }
    return true;
}


async function createGroup(){
    if(!validation()){
        return false;
    }
    if(!confirm("생성하시겠습니까?")){
        return false;
    }
    try{
        const response=await fetch('/eateryGroup-api/group-create',{
            method:'POST',
            headers: {csrf_header : csrf_token, "Content-Type" : "application/json"},
            body: JSON.stringify({
                "groupName" : group_name.value,
                "groupLocation" : group_location.value,
                "groupComment" : group_comment.value
            }),
        })
        const result = await response.json();
        if(response.status !== 200){
            alert("테마 생성 오류.. 관리자에게 문의해주세요.");
        }else{

        }

    }catch(error){
        alert(error);
    }
}


group_name.oninput = function(){
    document.getElementById("name_error").innerHTML = "";
}
group_comment.oninput = function(){
    document.getElementById("comment_error").innerHTML = "";
}
group_location.oninput = function(){
    document.getElementById("location_error").innerHTML = "";
}

