function searchFunction() {
    var key = document.querySelector("#searchbox").value.toUpperCase();
    var mydishes = document.querySelectorAll(".box");
    for (let i = 0; i < mydishes.length; i++) {
        var inItems = mydishes[i].querySelector("h2").innerText.toUpperCase();
        if (inItems.indexOf(key) > -1) {
            mydishes[i].style.display = ""
        } else {
            mydishes[i].style.display = "none"
        }
    }
}