const summaryModal = document.getElementById("summary-modal");
const btn = document.getElementById("summary-open");
const span = document.getElementsByClassName("close")[0];
const continueBtn = document.getElementById("summary-continue");

// When the user clicks the button, open the summaryModal
btn.onclick = function() {
    summaryModal.style.display = "block";
}

// When the user clicks on <span> (x), close the summaryModal
span.onclick = function() {
    summaryModal.style.display = "none";
}
continueBtn.onclick = function () {
    summaryModal.style.display = "none";
}

// When the user clicks anywhere outside of the summaryModal, close it
window.onclick = function(event) {
    if (event.target === summaryModal) {
        summaryModal.style.display = "none";
    }
}