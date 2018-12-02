function addLoadEvent(func) {
    var oldonload = window.onload;
    if (typeof window.onload != 'function') {
        window.onload = func;
    } else {
        window.onload = function () {
            oldonload();
            func();
        }
    }
}

function insertAfter(newElement, targentElement) {
    var parent = targentElement.parentNode;
    if (parent.lastChild == targentElement) {
        parent.appendChild(newElement);
    } else {
        parent.insertBefore(newElement, targentElement.nextSibling)
    }
}

function validatePhone(phoneNumber) {
    var phoneReg = /^((0\d{2,3}-\d{7,8})|(1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}))$/; //手机号码
    var mobReg = /^0?1[3|4|5|8][0-9]\d{8}$/; // 座机格式
    if (mobReg.test(phoneNumber) || phoneReg.test(phoneNumber)) {
        return true;
    } else {
        return false;
    }
}

function validateEmail(Email) {
    var emailReg = /^([a-zA-Z0-9]+[-_.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[-_.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,6}$/
    if (emailReg.test(Email)) {
        return true;
    } else {
        return false;
    }
}

function validateCheckboxRequired(checkboxArray) {
    for (let i = 0; i < checkboxArray.length; i++) {
        var checkboxElement = checkboxArray[i];
        var isValidated = false;
        if (checkboxElement.checked) {
            isValidated = true;
            break;
        }
    }
    return isValidated;
}

function resetInvalid(inputElement) {
    try {
        inputElement.classList.remove("is-invalid");
        inputElement.parentNode.removeChild(inputElement.nextSibling);
    } finally {
        continue;
    }
}

function resetInvalidCheckboxs(checkboxArray) {
    try {
        var checkboxArray = new Array();
        var elements = getFormElements(resumeForm);
        for (let i = 0; i < elements.length; i++) {
            element = elements[i];
            if (element.type == "checkbox") {
                checkboxArray.push(element);
            }
        }
        for (let i = 0; i < checkboxArray.length; i++) {
            element = checkboxArray[i];
            element.classList.remove("is-invalid");
        }
        var child = document.getElementById("feedback-checkbox");
        child.parentNode.removeChild(child);
    } finally {
        continue;
    }
}

function setAsInvalid(inputElement, feedbackText) {
    inputElement.classList.remove("is-valid");
    inputElement.classList.add("is-invalid");
    var feedbackElement = document.createElement("div");
    feedbackElement.classList.add("invalid-feedback", "d-sm-block", "d-md-inline", "mx-1");
    var node = document.createTextNode(feedbackText);
    feedbackElement.appendChild(node);
    insertAfter(feedbackElement, inputElement);
}

function setAsInvalidCheckboxs(checkboxArray, feedbackText) {
    for (let i = 0; i < checkboxArray.length; i++) {
        checkbox = checkboxArray[i];
        checkbox.classList.remove("is-valid");
        checkbox.classList.add("is-invalid");
    }
    var feedbackElement = document.createElement("div");
    feedbackElement.classList.add("invalid-feedback", "d-sm-block", "d-md-inline", "mx-1");
    feedbackElement.id = "feedback-checkbox";
    var node = document.createTextNode(feedbackText);
    feedbackElement.appendChild(node);
    insertAfter(feedbackElement, checkbox.parentNode);

}


function validateRequiredInput(inputElement, feedbackText) {
    if (inputElement.value == null || inputElement.value == "") {
        setAsInvalid(inputElement, feedbackText);
        return false;
    } else {
        return true;
    }
}

function validatePhoneInput(inputElement, feedbackText) {
    if (!validatePhone(inputElement.value) && inputElement.value != null && inputElement.value != "") {
        setAsInvalid(inputElement, feedbackText);
        return false;
    } else {
        return true;
    }
}

function validateEmailInput(inputElement, feedbackText) {
    if (!validateEmail(inputElement.value) && inputElement.value != null && inputElement.value != "") {
        setAsInvalid(inputElement, feedbackText);
        return false;
    } else {
        return true;
    }
}

function validateCheckboxRequiredInput(checkboxArray, feedbackText) {
    if (!validateCheckboxRequired(checkboxArray)) {
        setAsInvalidCheckboxs(checkboxArray, feedbackText);
        return false;
    } else {
        return true;
    }
}


function getFormElements(formElement) {
    var elements = new Array();
    var form = document.getElementById(formElement);
    var tagElements = formElement.getElementsByTagName('input');
    for (var j = 0; j < tagElements.length; j++) {
        elements.push(tagElements[j]);
    }
    var tagElements = formElement.getElementsByTagName('select');
    for (var j = 0; j < tagElements.length; j++) {
        elements.push(tagElements[j]);
    }
    var tagElements = formElement.getElementsByTagName('textarea');
    for (var j = 0; j < tagElements.length; j++) {
        elements.push(tagElements[j]);
    }
    return elements;
}

function validateForm(formElement) {
    var elements = getFormElements(formElement);
    var isValidated = true;
    var checkboxArray = new Array();
    for (let i = 0; i < elements.length; i++) {
        element = elements[i];
        if (element.required) {
            switch (element.name) {
                case "Name":
                    var feedbackText = "姓名"
                    break;
                case "Grademajor":
                    var feedbackText = "年级专业";
                    break;
                case "Email":
                    var feedbackText = "邮箱";
                    break;
                case "Phone":
                    var feedbackText = "电话号码";
                    break;
                default:
                    break;
            }
            feedbackText = feedbackText + "不能为空！";
            if (isValidated == true) {
                isValidated = validateRequiredInput(element, feedbackText);
            } else {
                validateRequiredInput(element, feedbackText);
            }
        }
        switch (element.type) {
            case "tel":
                if (isValidated == true) {
                    isValidated = validatePhoneInput(element, "请输入有效的电话号码！");
                } else {
                    validatePhoneInput(element, "请输入有效的电话号码！");
                }
                break;
            case "email":
                if (isValidated == true) {
                    isValidated = validateEmailInput(element, "请输入有效的邮箱！");
                } else {
                    validateEmailInput(element, "请输入有效的邮箱！");
                }
                break;
            case "checkbox":
                checkboxArray.push(element);
                break;
            default:
                break;
        }
    }
    if (isValidated == true) {
        isValidated = validateCheckboxRequiredInput(checkboxArray, "志愿部门/子网不能为空！");
    } else {
        validateCheckboxRequiredInput(checkboxArray, "志愿部门/子网不能为空！");
    }

    return isValidated;
}

var resumeForm = document.getElementById("resumeForm");
EventUtil.addHandler(resumeForm, "submit", function (event) {
    event = EventUtil.getEvent(event);
    if (!validateForm(resumeForm)) {
        EventUtil.preventDefault(event);
    } else {
        resumeForm.submit();
    }
})

elements = getFormElements(resumeForm);
for (let i = 0; i < elements.length; i++) {
    EventUtil.addHandler(elements[i], "click", function () {
        if (elements[i].type != "checkbox") {
            resetInvalid(elements[i]);
        } else {
            resetInvalidCheckboxs(elements[i]);
        }
    })
}