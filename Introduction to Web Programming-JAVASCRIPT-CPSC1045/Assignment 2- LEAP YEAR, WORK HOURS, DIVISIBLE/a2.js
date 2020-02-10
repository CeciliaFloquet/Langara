//question a
//declaring variable - receiving number from users
let numWorked = +prompt("Please enter the number of hours you worked");
let total40, count, ext, total;

//condition
if (numWorked <= 40) {
	total40 = numWorked * 12;
	console.log("In " + numWorked + " hours you made $" + total40);
}
else{
	count = numWorked - 40;
	ext = count * 18;
	total = ext + (40 * 12);
	console.log ("In " + numWorked + " hours you made $" + total);
}

//question b
//declaring variable - receiving number from users
let num1 = +prompt("Please enter the first number");
let num2 = +prompt("Please enter the second number");

//condition
if (num1 == 0 || num2 == 0){
	console.log("You entered 0");
}
else{
	if(num1 % num2 == 0){
		console.log("Second divides first");
	} 
	if (num2 % num1 == 0){
		console.log("First divides second");
	}
	if( num1 % num2 != 0 && num2 % num1 != 0){
		console.log("Not divisible");
	}
}

//question c
//declaring variable - receiving number from users
let year = +prompt("Please enter the year");
var year2 = year.toString(3);

//condition
if (year < 1582){
	alert("this program do not accept the year less 1582");
}
else{
	if (year % 4 ==0 && (year % 100 !== 0 || year % 400 == 0)) {
		alert("It is a leap year");
	}
	else{
		alert("It is not a leap year");
	}
}