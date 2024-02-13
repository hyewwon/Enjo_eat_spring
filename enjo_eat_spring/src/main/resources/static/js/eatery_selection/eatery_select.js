const card = document.querySelectorAll(".card");
const result_eatery = document.getElementById("result-eatery");
const modal_detail_btn = document.getElementById("modal-detail-btn");


async function selectCard(card, id) {
    let selectedCard = card.parentNode;
    selectedCard.classList.toggle("flip");
    result_eatery.innerHTML = `
        <div className="spinner-grow text-warning mt-3" role="status"></div>
        <p className="text-secondary mt-2">결과 불러오는 중..</p>
    `;
    try {
        const response = await fetch(`/eatery-selection-api/eatery-select/${id}`, {
            method: "GET"
        })
        const result = await response.json();
        if (response.status !== 200) {
            alert("메뉴 선택 오류.. 관리자에게 문의해주세요");
        } else {
            result_eatery.innerHTML = `<img src="${result.result.imagePath + result.result.imageName}" style="width:200px;height:200px;">
            <p class="mt-3">오늘은 <strong>${result.result.eateryName}</strong> 어떠세요?</p>
            <p>이 식당이 궁금하시다면 <span style="color:rgb(232,122,68)">자세히 보러가기</span>를 클릭해 주세요!</p>`;
            modal_detail_btn.href = "/"
            setTimeout(function(){
                $("#result_modal").modal("show");
            },1300)
        }

    }catch (error){
        alert("메뉴 선택 오류... 관리자에게 문의해주세요");
        console.log(error);
    }
}



