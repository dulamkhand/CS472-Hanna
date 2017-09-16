function calculateAverage() {
    let sum = 0;
    for(let i=0; i<arguments.length;i++) {
        sum += arguments[i];
    }
    return sum / arguments.length;
}
console.log(calculateAverage(1,2,3));
console.log(calculateAverage(1,2,3,4));
console.log(calculateAverage(1,2,3,4,5,16.6));