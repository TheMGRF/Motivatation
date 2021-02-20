const elements = document.getElementsByClassName("item");

const listElement = document.getElementById("list");

const onClickOutside = (event) => {
    listElement.style.display = "none";
    document.removeEventListener("click", onClickOutside);
};

listElement.addEventListener("contextmenu", (event) => {
    event.stopPropagation();
});

listElement.addEventListener("mouseup", (event) => {
    event.stopPropagation();
});

document.addEventListener("contextmenu", (event) => {
    listElement.style.display = "none";
});

listElement.addEventListener("click", (event) => {
    event.stopPropagation();
});

for (let i = 0; i < elements.length; i++) {
    elements[i].addEventListener("mouseup", (event) => {
        event.stopPropagation();
        if (event.button === 2) {
            return;
        }
    });

    elements[i].addEventListener("contextmenu", (event) => {
        event.preventDefault();
        event.stopPropagation();
        document.addEventListener("click", onClickOutside);

        let tooltips = document.getElementsByClassName("tooltip");
        for (let j = 0; j < tooltips.length; j++) {
            tooltips[i].style.display = "hidden";
        }

        const x = event.pageX;
        const y = event.pageY;
        listElement.style.display = "block";
        listElement.style.top = y - 20 + "px";
        listElement.style.left = x - 5 + "px";
    });
}