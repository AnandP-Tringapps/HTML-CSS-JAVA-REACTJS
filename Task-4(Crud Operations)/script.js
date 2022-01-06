
var selectedRow = null

function onFormSubmit() {
    if (validate()) {
        var formData = readFormData();
        if (selectedRow == null)
            insertNewRecord(formData);
        else
            updateRecord(formData);
        resetForm();
    }
}
function country() { 
            var result = document.getElementById("country").value; 
            alert(result);
        } 


function readFormData() {
    var formData = {};
    formData["fullName"] = document.getElementById("fullName").value;
    formData["Phonenumber"] = document.getElementById("Phonenumber").value;
    formData["email"] = document.getElementById("email").value;
    formData["country"] = document.getElementById("country").value;
    formData["city"] = document.getElementById("city").value;
    formData["pincode"] = document.getElementById("pincode").value;
    if(document.getElementById("male").checked){
        formData["gender"] =document.getElementById("male").value;    
    }
    else if(document.getElementById("female").checked){
        formData["gender"] =document.getElementById("female").value;    
    }
    else{
        formData["gender"] =document.getElementById("others").value;    
    }
    console.log(document.getElementById("male").value);
    
    if(document.getElementById("cricket").checked){
        formData["hobbies"] =document.getElementById("cricket").value;    
    }
    if(document.getElementById("youtube").checked){
        formData["hobbies"] =document.getElementById("youtube").value;    
    }
    if(document.getElementById("music").checked){
        formData["hobbies"] =document.getElementById("music").value;    
    }
    if(document.getElementById("others").checked){
        formData["hobbies"] =document.getElementById("others").value;    
    }
    
    console.log(document.getElementById("hobbies").value);
    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("regdetails").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.fullName;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.Phonenumber;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.email;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.country;
    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.city;
    cell6 = newRow.insertCell(5);
    cell6.innerHTML = data.pincode;
    cell7 = newRow.insertCell(6);
    cell7.innerHTML = data.gender;
    cell8 = newRow.insertCell(7);
    cell8.innerHTML = data.hobbies;
    cell9 = newRow.insertCell(8);
    cell9.innerHTML = `<a onClick="onEdit(this)">Edit</a>
                       <a onClick="onDelete(this)">Delete</a>`;
    
}

function resetForm() {
    document.getElementById("fullName").value = "";
    document.getElementById("Phonenumber").value = "";
    document.getElementById("email").value = "";
    document.getElementById("country").value = "";
    document.getElementById("city").value = "";
    document.getElementById("pincode").value = "";
    document.getElementById("gender").value = "";
    document.getElementById("hobbies").value = "";
    selectedRow = null;
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("fullName").value = selectedRow.cells[0].innerHTML;
    document.getElementById("Phonenumber").value = selectedRow.cells[1].innerHTML;
    document.getElementById("email").value = selectedRow.cells[2].innerHTML;
    document.getElementById("country").value = selectedRow.cells[3].innerHTML;
    document.getElementById("city").value = selectedRow.cells[4].innerHTML;
    document.getElementById("pincode").value = selectedRow.cells[5].innerHTML;
    document.getElementById("gender").value = selectedRow.cells[6].innerHTML;
    document.getElementById("hobbies").value = selectedRow.cells[6].innerHTML;
}
function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.fullName;
    selectedRow.cells[1].innerHTML = formData.Phonenumber;
    selectedRow.cells[2].innerHTML = formData.email;
    selectedRow.cells[3].innerHTML = formData.country;
    selectedRow.cells[4].innerHTML = formData.city;
    selectedRow.cells[5].innerHTML = formData.pincode;
    selectedRow.cells[6].innerHTML = formData.gender;
    selectedRow.cells[7].innerHTML = formData.hobbies;

}

function onDelete(td) {
    if (confirm('Are you sure to delete this record ?')) {
        row = td.parentElement.parentElement;
        document.getElementById("regdetails").deleteRow(row.rowIndex);
        resetForm();
    }
}
function validate() {
    isValid = true;
    if (document.getElementById("fullName").value == "") {
        isValid = false;
        document.getElementById("fullNameValidationError").classList.remove("hide");
    } else {
        isValid = true;
        if (!document.getElementById("fullNameValidationError").classList.contains("hide"))
            document.getElementById("fullNameValidationError").classList.add("hide");
    }
    return isValid;
}