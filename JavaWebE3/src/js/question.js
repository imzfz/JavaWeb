/**
 * Created by zfz on 2017/11/16.
 */

var id;

function checkValid() {
    var title = document.getElementById("newTitle").value;
    var score = document.getElementById("score").value;
    var choiceA = document.getElementById("newA").value;
    var choiceB = document.getElementById("newB").value;
    var choiceC = document.getElementById("newC").value;
    var choiceD = document.getElementById("newD").value;
    var answer = document.getElementsByName("answer");
    var type = document.getElementById("question_type");

    if (title.match(/^[ ]*$/)) {
        alert("标题不能为空");
        return false;
    }
    else if (title.length > 255) {
        alert("标题过长");
        return false;
    }

    if (type == "select") {
        if (choiceA.match(/^[ ]*$/) || choiceB.match(/^[ ]*$/) || choiceC.match(/^[ ]*$/) || choiceD.match(/^[ ]*$/)) {
            alert("选项不能为空");
            return false;
        }
        else if (choiceA.length > 255 || choiceB.length > 255 || choiceC.length > 255 || choiceD.length > 255) {
            alert("选项过长");
            return false;
        }
    }

    if (score.match(/^[ ]*$/)) {
        alert("分值不能为空");
        return false;
    }
    else if (score.length > 4) {
        alert("分值过大");
        return false;
    }

    for (var i = 0; i < answer.length; i++) {
        if (answer[i].checked) {
            break;
        }
        if (i == answer.length - 1) {
            alert("未选择正确答案");
            return false;
        }
    }
    return true;
}

function sub() {

    if (checkValid()) {
        document.addForm.submit();
    }
}

function loadjs() {
    document.getElementById("newId").value = document.getElementById("getId").value;
    var selectArea = document.getElementById("addSelect");
    var tfArea = document.getElementById("addTf");
    var type = document.getElementById("question_type");
    if (type.value == "tf") {
        selectArea.style.display = "none";
        tfArea.style.display = "block";
    }

    if (type.value == "select") {
        selectArea.style.display = "block";
        tfArea.style.display = "none";
    }
}

function getChange() {
    var selectArea = document.getElementById("addSelect");
    var tfArea = document.getElementById("addTf");
    var type = document.getElementById("question_type");
    if (type.value == "tf") {
        selectArea.style.display = "none";
        tfArea.style.display = "block";
    }

    if (type.value == "select") {
        selectArea.style.display = "block";
        tfArea.style.display = "none";
    }

}
