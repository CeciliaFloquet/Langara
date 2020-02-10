//QUESTION A
//input
var string  = prompt("Please enter a string: ");
//declaring the variable
var vowelA = 0;
var vowelE = 0;
var vowelI = 0;
var vowelO = 0;
var vowelU = 0;
var nonVowel = 0;
//loop for finding the vowel(or not) and count
for(var count = 0; count < string.length; count++){
	var letter = string.charAt(count)
	if (letter == letter.toLowerCase()){
		if(letter== "a"){
			vowelA ++
		}	
		else if(letter == "e"){
			vowelE++;	
		}
		else if(letter == "i"){
			vowelI++;
		}
		else if(letter == "o"){	
			vowelO++;
		}
		else if(letter == "u"){
			vowelU++;
		}
		else{	
			nonVowel++;
		}
	}
	else{
		nonVowel++;
	}
	
}
//display the result
console.log("a:" + vowelA);
console.log("e:" + vowelE);
console.log("i:" + vowelI);
console.log("o:" + vowelO);
console.log("u:" + vowelU);
console.log("non-vowels:" + nonVowel);



//QUESTION B
//declaring variable
var num;
var num2;
var sum = 0;
var average;
var temp = 0;

//enter input
num = +prompt("Please enter the numbers: ");
if (num < 0){
	alert("Error: NO positive numbers entered");
}

//otherwise
else{
	sum = sum + num;
	temp = 1;
	do{
		num2 = +prompt("Please enter the numbers: ");
		if (num2 > 0){
			sum = sum + num2;
			temp++;
		}	
	}while(num2 > 0);

	//calculating
	average = sum / temp;
	//display
	alert("The average is " + average);
}



//QUESTION C
//declaring variable
var toPrint = "";

var num1 = +prompt("Please enter an odd number: ");
//check 
while (num1 % 2 == 0){
	alert("This is not odd number");
	num1 = +prompt("Please enter an odd number: ");
}

// mid of the number
var mid = (num1 - 1) / 2;

//for the line
for(var row = 0; row < num1; row++){
	
	//for the space
	for(var col = 0; col < mid && row != mid; col++){
		toPrint += " ";
	}
	//for the * in the mid
	for(var col2 = num1- 1; col2 < num1 && row != mid; col2++){
		toPrint += "*";	
	}
	//for to print * the mid
	for(var col3 = 0; col3 < num1 && row == mid; col3++){
		toPrint += "*";
	}
	//new line
	toPrint += "\n";
}
//print
console.log(toPrint);
