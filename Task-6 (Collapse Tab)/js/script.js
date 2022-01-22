var myTabs = document.querySelectorAll(".collapsetab");
for (let i = 0; i < myTabs.length; i++) {
    myTabs[i].addEventListener("click", function() {
        var cont = myTabs[i].nextElementSibling;
        if (cont.style.maxHeight) {
            cont.style.maxHeight = null;
        } else {
            cont.style.maxHeight = cont.scrollHeight + "px";
        }
        myTabs[i].classList.toggle("active");
    });
}