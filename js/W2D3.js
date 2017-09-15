// 1 ------------------------------------------------------------------------
document.write("1. undefined, 8, 8, 9, 10 and 1");
x = 1;
var a = 5;
var b = 10;
var c = function (a, b, c) {
    //document.write(x);
    //document.write(a);
    var f = function (a, b, c) {
        b = a;
        //document.write(b);
        b = c;
        var x = 5;
    }
    f(a, b, c);
    //document.write(b);
    var x = 10;
}

c(8, 9, 10);
//document.write(b);
//document.write(x);
document.write("<br><br>");

// 2 ------------------------------------------------------------------------
document.write("2. Global scope - A window level scope.<br>");
document.write("Local scope or Functional Scope - Variable declared within a function with var keyword has functional scope.");
document.write("<br><br>");

// 3 ------------------------------------------------------------------------
document.write("3. a. No &nbsp;b. Yes &nbsp;c. No &nbsp;d. Yes &nbsp;e. Yes");
document.write("<br><br>");

// 4 ------------------------------------------------------------------------
document.write("4. ");
var x = 9;

function myFunc() {
    return x * x;
}
document.write(myFunc());
x = 5;
document.write(" and ");
document.write(myFunc());
document.write("<br><br>");


// 5 ------------------------------------------------------------------------
document.write("5. ");
var foo = 1;
function bar() {
    if(!foo) {
        var foo = 10;
    }
    //alert(foo);
    document.write("foo:" + foo);
}
bar();
document.write("<br><br>");

// 6 ------------------------------------------------------------------------
document.write("6. ");
var count = (function() {
    var counter = 0;

    return  {
        add: function() {
            return ++counter;
        },
        reset: function() {
            return counter = 0;
        }
    }
})();
document.write("count.add(): " + count.add());
document.write("<br>");
document.write("count.reset(): " + count.reset());
document.write("<br><br>");

// 7 ------------------------------------------------------------------------
document.write("7. counter");
document.write("<br><br>");

// 8 ------------------------------------------------------------------------
document.write("8. ");

var count = (function() {
    var counter = 0;
    return  {
        make_adder: function(inc) {
            //return counter + inc;
            return counter = counter + inc;
        },
        add: function() {
            return ++counter;
        },
        reset: function() {
            return counter = 0;
        }
    }
})();

document.write("add5(): ");
var add5 = count.make_adder.bind(count, 5);
document.write(add5());
document.write(",");
document.write(add5());
document.write(",");
document.write(add5());
document.write("<br>");

var add7 = count.make_adder.bind(count, 7);
document.write("add7(): ");
document.write(add7());
document.write(",");
document.write(add7());
document.write(",");
document.write(add7());
document.write("<br><br>");

// 9 ------------------------------------------------------------------------
document.write("9. We can use modules pattern creating each modules with functions with its related variables in local scope.");
document.write("<br><br>");

// 10 ------------------------------------------------------------------------
document.write("10. ");
var emp = (function() {
    var name;
    var age;
    var salary;

    // private functions
    var getName = function () { return name; };
    var getAge = function () { return age; };
    var getSalary = function () { return salary; };
    
    // public functions
    var setName = function (newName) { name = newName; };
    var setAge = function (newAge) { age = newAge; };
    var setSalary = function (newSalary) { salary = newSalary; };
    var increaseSalary = function (percentage) { return getSalary() + getSalary() * percentage / 100; };
    var incrementAge = function () { return getAge() + 1; };

    return {
        'setAge': setAge,
        'setSalary': setSalary,
        'setName': setName,
        'increaseSalary': increaseSalary,
        'incrementAge': incrementAge,
        'print': function() {
            return getName() + ": " + getAge() + ", " + getSalary();
        }
    };
})();

emp.setName("Dulamkhand");
emp.setAge(35);
emp.setSalary(85000);
emp.increaseSalary(10);
emp.incrementAge();
document.write(emp.print());
document.write("<br>");
emp.setName("George");
emp.setAge(31);
emp.setSalary(75000);
emp.increaseSalary(15);
emp.incrementAge();
document.write(emp.print());
document.write("<br><br>");

// 11 ------------------------------------------------------------------------
document.write("11. ");
var address;
var emp = (function() {
    var name;
    var age;
    var salary;
    var address;

    // private functions
    var getName = function () { return name; };
    var getAge = function () { return age; };
    var getSalary = function () { return salary; };
    
    // public functions
    var setName = function (newName) { name = newName; };
    var setAge = function (newAge) { age = newAge; };
    var setSalary = function (newSalary) { salary = newSalary; };

    var increaseSalary = function (percentage) { 
        return getSalary() + getSalary() * percentage / 100; 
    };
    var incrementAge = function () { 
        return getAge() + 1; 
    };
    var getAddress = function () { 
        return address; 
    };
    var setAddress = function (newAddress) { 
        address = newAddress; 
    };

    return {
        'setAge': setAge,
        'setSalary': setSalary,
        'setName': setName,
        'increaseSalary': increaseSalary,
        'incrementAge': incrementAge,
        'getAddress': getAddress,
        'setAddress': setAddress,
        'print': function() {
            return getName() + ": " + getAge() + ", " + getSalary() + ", " + getAddress();
        }
    };

})();

emp.setName("Dulamkhand");
emp.setAge(35);
emp.setSalary(85000);
emp.setAddress("8536 W Gregory St, Chicago, IL");
emp.increaseSalary(10);
emp.incrementAge();
document.write(emp.print());
document.write("<br>");

emp.setName("George");
emp.setAge(31);
emp.setSalary(75000);
emp.setAddress("2000 N Court St, Fairfield, IA");
emp.increaseSalary(15);
emp.incrementAge();
document.write(emp.print());
document.write("<br><br>");