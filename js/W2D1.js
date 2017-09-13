function max(a, b) {
	if (a > b) {
		return a;
	} else {
		return b;
	}
}

function maxOfThree(a, b, c) {
	return Math.max(a, b, c);
}

function isVowel(letter) {
	if (letter.length == 1) {
		return /[aeiou]/.test(letter);
	}
}

function sum(numbers) {
	var total = 0;
	for (var i = 0; i < numbers.length; i++) {
		total += numbers[i];
	}
	return total;
}

function multiply(numbers) {
	var total = 1;
	for (var i = 0; i < numbers.length; i++) {
		total = (total * numbers[i]);
	}
	return total;
}

function reverse(str) {
	var text = '';
	for (var i = str.length - 1; i >= 0; i--) {
		text += str[i];
		continue
	}
	return text;
}

function findLongestWord(words) {
	var charCnt = 0;
	var longestWord;
	for (var i = 0; i < words.length; i++) {
		if (words[i].length > charCnt) {
			longestWord = words[i];
			charCnt = words[i].length;
		}
	}
	return longestWord;
}

function filterLongWords(words, i) {
	var filtered = new Array();
	var j = 0;
	for (var m = 0; m < words.length; m++) {
		if (words[m].length > i) {
			filtered[j] = words[m];
			j++;
		}
	}
	return filtered;
}


console.log("max: " + max(6, 8));
console.log("maxOfThree: " + maxOfThree(12, 45, 656));
console.log("isVowel: " + isVowel("e"));
console.log("sum: " + sum([1,2,3,4]));
console.log("multiply: " + multiply([1,2,3,4]));
console.log("reverse: " + reverse("jagtestar"));
console.log("findLongestWord: " + findLongestWord(["test", "hail", "candy", "reverse"]));
console.log("filterLongWords: " + filterLongWords(["test", "hail", 
  "candy", "reverse", "plate", "car", "winter", "travel", "whiteboard"], 5));