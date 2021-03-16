const completeRandomBtn = document.getElementById("complete-random-event");
const randomBtn = document.getElementById("random-event-display");
const missionBtn = document.getElementById("mission-event-display");

completeRandomBtn.onclick = function() {
    randomBtn.style.display = "none";
    missionBtn.style.visibility = "visible";
};