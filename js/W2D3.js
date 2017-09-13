// 8. 
var count = (function() {
    var counter = 0;

    return  {
        make_adder: function(inc) {
            return counter + inc;
        },
        add: function() {
            return ++counter;
        },
        reset: function() {
            return counter = 0;
        }
    }
})();

var add5 = count.make_adder(5);
document.write(add5());
document.write(",");
document.write(add5());
document.write(",");
document.write(add5());
document.write("<br/>");

// 6. 
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
document.write(count.add());
document.write(",");
document.write(count.reset());

document.write("<br/>");
// ------------------------------
var foo = 1;
function bar() {
    if(!foo) {
        var foo = 10;
    }
    //alert(foo);
    document.write(foo);
}
bar();

document.write("<br/>");
// ------------------------------
var x = 9;

function myFunc() {
    return x * x;
}
document.write(myFunc());
x = 5;
document.write(",");
document.write(myFunc());

document.write("<br/>");
// ------------------------------
x = 1;
var a = 5;
var b = 10;
var c = function (a, b, c) {
    document.write(x);
    document.write(a);
    var f = function (a, b, c) {
        b = a;
        document.write(b);
        b = c;
        var x = 5;
    }
    f(a, b, c);
    document.write(b);
    var x = 10;
}

c(8, 9, 10);
document.write(b);
document.write(x);


