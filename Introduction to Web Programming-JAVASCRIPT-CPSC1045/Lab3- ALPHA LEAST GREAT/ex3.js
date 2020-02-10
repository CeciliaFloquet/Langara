/*
example
	var count = 1;
	var limit = 10;

	while(count <= limit){
		console.log(count + "\n");
		count++;
	}

*/

var count = 1;

var postNum = +prompt("Please enter a positive number");
	while(count <= postNum ){
		console.log(count + "\n");
		count++;
	}

//question B
var count2 = 0;

var numZero = +prompt("Please enter a number");
while (numZero != 0){
	numZero = +prompt("Please enter a number");
	count2 ++;	
}
alert("You entered " + count2 + " non-zero numbers!");


//question C
var letters = prompt("Please enter a single letter");
var str = letters.toUpperCase(0);


switch(str){
	case "z":
	console.log(str + " is the least common letter");
	break;
	case "q":
	console.log(str + " is the 2nd least common letter");
	break;
	case "x":
	console.log(str + " is the 3rd least common letter");
	break;
	case "j":
	console.log(str + " is the 4th least common letter");
	break;
	default:
	console.log("That is a common letter");
}

