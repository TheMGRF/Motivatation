const notificationBox = document.getElementById("notification");

//"Achievement Get!"
//"Item Purchased!"

function notification(title, image, msg) {
    // Assign the notification as active if its not already
    if (!notificationBox.classList.contains("visible")) {
        notificationBox.innerHTML = notificationHTML(title, image, msg);
        notificationBox.classList.toggle("visible");

        sleep(4000).then(() => {
            // Remove visible if its still there
            if (notificationBox.classList.contains("visible")) {
                notificationBox.classList.toggle("visible");
            }
        });
    }
}

function notificationHTML(title, texture, msg) {
    return "" +
        "<img class='item-img notification-img' src='" + texture + "' alt='Notification Image'>" +
        "<h5 class='notification-text'><b class='achievement-title'>" + title + "</b><span class='notification-message'>" + msg + "</span></h5>";
}