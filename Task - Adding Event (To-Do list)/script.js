function additem(){
    var myitem = document.getElementById("myitem");
    var text = document.getElementById("newevent").value;
    if(text=='')
    {
        alert("Please Add an Event ")
    }
  
    else{
    document.getElementById("newevent").value = "";
    var list = document.createElement("li");
    list.innerHTML=text;
    list.className = "l";
    list.addEventListener('click', function(){
        list.classList.add('completed');
    })
    myitem.appendChild(list);
}
}

function empty(){
    var elements = document.querySelectorAll(".l");
    for(var x of elements){
        x.remove();
    }
}

function clearComplete(){
    var elements = document.querySelectorAll(".completed");
    for(var x of elements){
        x.remove();
    }
}

function save(){
    var saveList = document.getElementById("myitem").innerHTML;
    localStorage.setItem("saveList", JSON.stringify(saveList));
}

function showSavedList(){
    var savedList = localStorage.getItem("saveList");
    document.getElementById("myitem").innerHTML = JSON.parse(savedList);
}