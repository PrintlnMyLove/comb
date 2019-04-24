var check = 0;//该变量是记录当前选择的评分
/*over()是鼠标移过事件的处理方法*/
var param = 0;

function over(param){
    if(param == 1){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>很差");
    }else if(param == 2){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>比较差");
    }else if(param == 3){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>一般");
    }else if(param == 4){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star_red.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>比较好");
    }else if(param == 5){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star_red.png");
        $("#star5").attr("src","js/img/star_red.png");
        $("#message").html("<br>很好");
    }else if(param == 0){
        $("#star1").attr("src","js/img/star.png");
        $("#star2").attr("src","js/img/star.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("");
    }
}
    /*out 方法是鼠标移除事件的处理方法，当鼠标移出时，恢复到我的打分情况*/
function out(){
    if(check == 1){//打分是1，设置第一颗星星亮，其他星星暗，其他情况以此类推
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>很差");
    }else if(check == 2){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>比较差");
    }else if(check == 3){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>一般");
    }else if(check == 4){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star_red.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("<br>比较好");
    }else if(check == 5){
        $("#star1").attr("src","js/img/star_red.png");
        $("#star2").attr("src","js/img/star_red.png");
        $("#star3").attr("src","js/img/star_red.png");
        $("#star4").attr("src","js/img/star_red.png");
        $("#star5").attr("src","js/img/star_red.png");
        $("#message").html("<br>很好");
    }else if(check == 0){
        $("#star1").attr("src","js/img/star.png");
        $("#star2").attr("src","js/img/star.png");
        $("#star3").attr("src","js/img/star.png");
        $("#star4").attr("src","js/img/star.png");
        $("#star5").attr("src","js/img/star.png");
        $("#message").html("");
    }
}
/*click()点击事件处理，记录打分*/
/*function click(param){
    out();//设置星星数

}*/

$(function () {
    $(document).on("click", "#star1", function() {
        check = 1;
        out();
    });
    $(document).on("click", "#star2", function() {
        check = 2;
        out();
    });
    $(document).on("click", "#star3", function() {
        check = 3;
        out();
    });
    $(document).on("click", "#star4", function() {
        check = 4;
        out();
    });
    $(document).on("click", "#star5", function() {
        check = 5;
        out();
    });
});


$(function () {
    $(document).on("click", ".btn_evaluation", function() {
        $("#container").stop().fadeIn(100);
    });
    /*$(".btn_evaluation").click(function () {
        $("#container").stop().fadeIn(100);
    });*/
    $(document).on("click", ".close", function() {
        $("#container").stop().fadeOut(100);
    });
    /*$(".close").click(function () {
        $("#container").stop().fadeOut(100);
    });*/
});



