const reply = document.getElementById("reply");
const btn_reply = document.getElementById("btn_reply");
const eatery_id = document.getElementById("eatery_id");
const eatery_location = document.getElementById("eatery_location");
const eatery_name = document.getElementById("eatery-name");
const group_id = document.getElementById("group-id");

async function deleteEatery(id){
    if(!confirm("이 음식점을 삭제할까요?")){
        return false;
    }
    try{
        const response = await fetch(`/eatery-api/eatery-delete/${id}`,{
            method:"DELETE",
            headers:{csrf_header: csrf_token, 'Content-Type' : "application/json"},
        })
        const result = await response.json();
        if(response.status !== 200){
            alert("음식점 삭제 실패.. 관리자에게 문의해주세요");
        }else{
            location.href = `/eatery/eatery-manage/${group_id.value}`;
        }
    }catch(error){
        alert(error);
    }
}

async function createReply(eateryId){
    if(reply.value === ""){
        reply.focus();
        document.getElementById("reply_error").innerHTML = "<p style='color:red;'>후기를 작성해 주세요</p>";
        return false;
    }
    if(!confirm("작성 하시겠습니까?")){
        return false;
    }
    try{
        btn_reply.disabled = true;
        const response = await fetch(`/reply-api/reply-create/${eateryId}`,{
            method:"POST",
            headers:{csrf_header: csrf_token, 'Content-Type' : "application/json"},
            body:JSON.stringify({reply:reply.value})

        })
        const result = await response.json();
        if(response.status !== 200){
            alert("후기 달기 에러..");
            btn_reply.disabled = false;

        }else{
            location.reload();
            btn_reply.disabled = false;
        }
    }catch(error){
        alert(error)
        btn_reply.disabled = false;
    }

}


// 후기 삭제
async function deleteReply(id){
    if(!confirm("삭제하시겠습니까?")){
        return false;
    }
    try{
        console.log(id)
        const response = await fetch(`/reply-api/reply-delete/${id}`,{
            method:"DELETE",
            headers:{csrf_header: csrf_token, 'Content-Type' : "application/json"},
            body:JSON.stringify({reply_id:id})
        })
        const result = await response.json();
        if(response.status !== 200){
            alert("후기 삭제 에러.. 관리자에게 문의해주세요");
        }else{
            location.reload();
        }
    }catch(error){
        alert(error)
    }
}



reply.oninput = function(){
    document.getElementById("reply_error").innerHTML = "";

}

// 카카오 지도 api

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(eatery_location.value, function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: `<div style="width:150px;text-align:center;padding:6px 0;">${eatery_name.innerText}</div>`
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    