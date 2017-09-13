console.log("Hello Module Pattern");

const appModule = (function() {
    let counter = 0;

    return {
        setCounter: function(newValue) {
            counter = newValue;
        },
        incrementCounter: function() {
            return ++counter;
        },
        getCounter: function() {
            return counter;
        }
    }
})();


// use our module
console.log(appModule.getCounter());
let newValue = appModule.incrementCounter();
console.log(newValue);
console.log(appModule.getCounter());
