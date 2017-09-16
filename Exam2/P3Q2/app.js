function multiplesCount(nums, k) {
    var res = nums.filter(function(i){
        return (i%k == 0);
    });
    return res.length;
}
console.log(multiplesCount([1,2,3,4,5,6], 3));
console.log(multiplesCount([1,2,3,4,5,6,7,8,9,10,11,12,13,14,15], 5) ); 