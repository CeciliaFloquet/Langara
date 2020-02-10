
//QUESTION 1
var countEven = 0;
var countOdd = 0;
var count = 0;
var num = +prompt("Enter the number");
if(num < 0){
	console.log("0 even and 0 odd");
}
else{
	if (num % 2 ==0){
		countEven++;
	}
	else{
		countOdd;
	}
	do{
		var num = +prompt("Enter the number");
		if(num%2 == 0){
			countEven++;
		}
		else{
			countOdd++;
		}
	}while(num > 0);
	console.log( countEven + " even and " + countOdd + " odd");
}


//question2

var radius = Math.floor(Math.random() * 6)+ 5;
var circ = parseFloat(2 * Math.PI * radius);
var area = parseFloat(Math.PI * Math.pow(radius, 2));
var circ1 = circ.toFixed(2);
var area1= area.toFixed(2);
alert("Radius is "+ radius +", circumference of the circle is " + circ1 + " and area is " + area1);


