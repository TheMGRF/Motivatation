const taskModal = document.getElementById("task-modal");
const btn = document.getElementById("add-task");
const span = document.getElementsByClassName("close")[0];
const continueBtn = document.getElementById("task-add");

// When the user clicks the button, open the taskModal
btn.onclick = function() {
    taskModal.style.display = "block";
}

// When the user clicks on <span> (x), close the taskModal
span.onclick = function() {
    taskModal.style.display = "none";
}

document.onkeydown = function () {
    shouldButton();
}

continueBtn.onclick = function () {
    if (shouldButton()) {
        taskModal.style.display = "none";
    }
}

function shouldButton() {
    if (document.getElementById("name").value === "") {
        continueBtn.disabled = true;
        return false;
    } else if (document.getElementById("desc").value === "") {
        continueBtn.disabled = true;
        return false;
    } else if (document.getElementById("date").value === "") {
        continueBtn.disabled = true;
        return false;
    } else if (document.getElementById("priority").value === "") {
        continueBtn.disabled = true;
        return false;
    } else if (document.getElementById("reward-type").value === "") {
        continueBtn.disabled = true;
        return false;
    } else if (document.getElementById("formRewardAmount").value === "") {
        continueBtn.disabled = true;
        return false;
    }

    continueBtn.disabled = false;
    return true;
}

// When the user clicks anywhere outside of the taskModal, close it
window.onclick = function(event) {
    if (event.target === taskModal) {
        taskModal.style.display = "none";
    }
}