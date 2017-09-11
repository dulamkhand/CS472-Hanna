function max(a,b){	
	if(a > b){
		return a;
	}else{
		return b;
	}
}

function maxOfThree(a,b,c){	
	return Math.max(a, b, c);
}

function isVowel(letter) {
	return ~"aeiou".indexOf(letter);
}
