/**
 * Created by zfz on 2017/11/16.
 */

var id;

//添加信息完整性检查
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

    if (type.value == "select") {
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

//修改信息完整性检查
function checkValidUpdate() {
    var title = document.getElementById("updateTitle").value;
    var score = document.getElementById("updateScore").value;
    var choiceA = document.getElementById("updateA").value;
    var choiceB = document.getElementById("updateB").value;
    var choiceC = document.getElementById("updateC").value;
    var choiceD = document.getElementById("updateD").value;
    var answer = document.getElementsByName("answer");
    var type = document.getElementById("update_question_type");

    if (title.match(/^[ ]*$/)) {
        alert("标题不能为空");
        return false;
    }
    else if (title.length > 255) {
        alert("标题过长");
        return false;
    }

    if (type.value == "select") {
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

//提交添加的信息
function sub() {

    if (checkValid()) {
        document.addForm.submit();
    }
}

//提交修改的信息
function subUpdate() {

    if (checkValidUpdate()) {
        document.updateForm.submit();
    }
}

//选项列表的修改与显示
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

//填充已有信息
function update() {
    var whoIsSelected = document.getElementsByName("checkbox");
    var selectArea = document.getElementById("updateSelect");
    var tfArea = document.getElementById("updateTf");
//    var type = document.getElementById("update_question_type");
    var count = 0;
    for(var i = 0; i < whoIsSelected.length; i++){
        count++;
        var type = document.getElementById("showType_" + (i + 1)).innerHTML;
        if(whoIsSelected.item(i).checked){
            document.getElementById("updateId").value = document.getElementById("showId_" + (i + 1)).innerHTML;
            document.getElementById("updateTitle").value = document.getElementById("showTitle_" + (i + 1)).innerHTML;
            document.getElementById("updateScore").value = document.getElementById("showScore_" + (i + 1)).innerHTML;
            document.getElementById("update_question_type").options[1].selected = true;
            if(type == "选择") {
                document.getElementById("update_question_type").options[0].selected = true;
                document.getElementById("updateA").value = document.getElementsByName("getChoice_" + (i + 1)).item(0).value;
                document.getElementById("updateB").value = document.getElementsByName("getChoice_" + (i + 1)).item(1).value;
                document.getElementById("updateC").value = document.getElementsByName("getChoice_" + (i + 1)).item(2).value;
                document.getElementById("updateD").value = document.getElementsByName("getChoice_" + (i + 1)).item(3).value;
            }
            var ans = document.getElementById("showAnswer_" + (i + 1)).innerHTML;
            document.getElementById("answer_" + ans).checked = true;
            break;
        }
    }
    if (type == "判断") {
        selectArea.style.display = "none";
        tfArea.style.display = "block";

    }

    if (type == "选择") {
        selectArea.style.display = "block";
        tfArea.style.display = "none";
    }

}

function getChange_update() {
    var selectArea = document.getElementById("updateSelect");
    var tfArea = document.getElementById("updateTf");
    var type = document.getElementById("update_question_type");
    if (type.value == "tf") {
        selectArea.style.display = "none";
        tfArea.style.display = "block";
    }

    if (type.value == "select") {
        selectArea.style.display = "block";
        tfArea.style.display = "none";
    }

}

//编辑和删除 验证
function beforeDelorUpdate() {
    var whoIsSelected = document.getElementsByName("checkbox");
    var delBtn = document.getElementById("delButton");
    var updateBtn = document.getElementById("updateButton");

    for(var i = 0; i < whoIsSelected.length; i++){
        if(whoIsSelected.item(i).checked){
            delBtn.disabled = false;
            updateBtn.disabled = false;
            break;
        }
        else{
            delBtn.disabled = true;
            updateBtn.disabled = true;
        }
    }
}

function doDelete() {
    if(confirm("确定删除所选问题？")){
        document.doDel.submit();
    }
}

