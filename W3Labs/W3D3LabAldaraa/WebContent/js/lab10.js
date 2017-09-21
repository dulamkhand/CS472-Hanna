$(document).ready(function(){  
    $(function(){
    const p = document.getElementById("currentTime");
    setInterval(function(){ $(p).text( new Date()); }, 1000)
    });

    $(function(){
         navigator.geolocation.getCurrentPosition(success, fail); 
         function success(position){ 
                var location = document.getElementById("currentLocation");
                var img = new Image();
               // img.src = "https://maps.googleapis.com/maps/api/staticmap?center=" + position.coords.latitude + "," + position.coords.longitude + "&zoom=13&size=300x300&sensor=false";
                location.appendChild(img);
            }
         function fail(){
            $(location).text("Couldn't get location"); 
         }
        });
    
     $(function(){
        var myArr = localStorage['AccountData'];
        if(myArr!=null){
            $.each(JSON.parse(myArr)['Account'], function(index, item) {
                var newLine = document.createElement("list");
                newLine.className = "list-group-item";
                newLine.innerHTML = item.accountNo + " | " + item.firstName + " | " + item.accountType;
                $("#listOfStudents").append(newLine);
            });
        }
    });

    $(function() { 
        $("#btnSubmit").click(AddData); 
    }); 
    
    function AddData(event) { 
        var txtAccountNo = $("#accountNo");
        var txtFirstName = $("#firstName");
        var txtAccountType = $("#accountType");
        const newLine = document.createElement("list");
        if(txtAccountNo.value !="" || txtFirstName.value!=""){
            newLine.className = "list-group-item";
            newLine.innerHTML = txtAccountNo.val() + " | " + txtFirstName.val() + " | " + txtAccountType.val();
            $("#listOfStudents").append(newLine);
            var arr = {'Account':[]}
            arr['Account'].push({"accountNo": txtAccountNo.val(),"firstName": txtFirstName.val(), "accountType" : txtAccountType.val()});
            localStorage['AccountData']= JSON.stringify(arr);
           
            txtAccountNo.value = "";
            txtFirstName.value = "";
            txtAccountNo.focus();
            event.preventDefault(); 
            
        }
        else
            window.alert("Please fillout all empty fields");
    }


    $("#btnLoad").click(function(){

        $.ajax({ 
            type: 'GET', 
            url: 'AddStudentData', 
            data: { get_param: 'value' }, 
            dataType: 'json',
            success: function (data) { 
            	alert("servlet");
//                $.each(data, function(index, value) {
//                    myArr = value;
//                });
//                myArr.forEach( function(student) { 
//                    const newLine = document.createElement("list");
//                    newLine.className = "list-group-item";
//                    newLine.innerHTML = student.studentId + " - " + student.firstName;
//                    $("#listOfStudents").append(newLine);
//                });
            }
        });
    }); 
    
});