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
continueBtn.onclick = function () {
    taskModal.style.display = "none";
}

// When the user clicks anywhere outside of the taskModal, close it
window.onclick = function(event) {
    if (event.target === taskModal) {
        taskModal.style.display = "none";
    }
}