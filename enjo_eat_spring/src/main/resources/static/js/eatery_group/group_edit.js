const group_name = document.getElementById("name");
const group_location = document.getElementById("location");
const group_comment = document.getElementById("comment");
const open = document.getElementById("open");
const group_id = document.getElementById("group-id");

async function updateGroup(){
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
        document.getElementById("comment_error").innerHTML = "<p style='color:red;'>태마 소개를 작성해주세요</p>";
        return false;
    }
    if(!confirm("수정하시겠습니까?")){
        return false;
    }
    try{
        const response=await fetch(`/eateryGroup-api/group-edit/${group_id.value}`,{
            method:'PUT',
            headers: {csrf_header : csrf_token, "Content-Type" : "application/json"},
            body: JSON.stringify({
                "groupName" : group_name.value,
                "groupLocation" : group_location.value,
                "groupComment" : group_comment.value,
                "openFlag" : open.checked ? 1 : 0
            }),
        })
        const result = await response.json();
        if(response.status !== 200){
            alert("테마 생성 오류.. 관리자에게 문의해주세요.");
        }else{
            alert("수정되었습니다.");
            location.href = "/my-group"
        }

    }catch(error){
        alert(error);
    }
}

async function deleteGroup(){
    if(!confirm('테마를 삭제하면 등록된 모든 음식점들이 삭제됩니다.\n테마를 삭제할까요?')){
        return false;
    }
    try{
        const response = await fetch(`/eateryGroup-api/group-delete/${group_id.value}`,{
            method:"DELETE",
            headers:{csrf_header : csrf_token, "Content-Type" : "application/json"}
        })
        const result = await response.json();
        if(response.status !== 200){
            alert("삭제 에러.. 관리자에게 문의해주세요.");
        }else{
            alert("삭제되었습니다.")
            location.href = "/my-group"
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