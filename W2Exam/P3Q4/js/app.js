$(document).ready(function() {
    var firstCall = true;
    if (firstCall) {
        $.ajax({
        url: "./data/customerData.json",
        type: "GET",
        dataType: "json"
        }).done(function(data) {
            data.forEach(function (s) {
                data['accountNo'] = $("#id").val();
                data['customerName'] = $("#name").val();
                data['accountType'] = $("#type").val();
            });
            localStorage.setItem("customerData", JSON.stringify(data));
        });
    } else {
        firstCall = false;
    }
    // bind data
    populateData(localStorage.getItem("customerData"));

    function populateData(dataJson) {
        data = JSON.parse(dataJson)
        data.forEach(function (s) {
            const li = document.createElement("li");
            li.className = "list-group-item";
            li.innerHTML = s.accountNo + " | " + s.customerName + " | " + s.accountType;
            $("#customers-list").append(li);
        });
    }
    
    $("#form").submit(function(event) {
        return false;
    })

    $("#submit").bind('click', function() {
        // append li
        const li = document.createElement("li");
        li.className = "list-group-item";
        li.innerHTML = $("#id").val() + " | " + $("#name").val() + " | " + $("#type").val();
        $("#customers-list").append(li);

        // update storage
        dataJson = localStorage.getItem("customerData");
        let data = JSON.parse(dataJson);
        data.push({'accountNo':$("#id").val(), 'customerName':$("#name").val(), 'accountType':$("#type").val()});
        localStorage.setItem("customerData", JSON.stringify(data));
    });
});