
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");

//function to calculate the radians
function toRad (angle){
	
	var radians = angle * (Math.PI/180);
	
	return radians;
}
//function to validate the number;
function isValidNumber(inputNum, validMin, validMax){
	
	if(inputNum >= validMin && inputNum <= validMax){
		return true;
	}
	else{
		return false;
	}
}
//function to draw circle
function drawObject(x,y){
	ctx.save();
	ctx.fillStyle = "pink";
	ctx.beginPath();
	ctx.arc(x,y,30,0,2 * Math.PI);
	ctx.stroke();
	ctx.fill();
	
}
//declaring the variable
var n;
var r;
//do loop to check if the number of the object is valid-it is not ask again
do{
	n = +prompt("Please enter the number of object to draw on canvas, between 1 and 10");
	var isValidNum = isValidNumber(n, 1, 10);	
}while(!isValidNum);

////do loop to check if the number of distance is valid-it is not ask again
do{
	r = +prompt("Please enter the distance, between 100 and 200");
	var isValidNum = isValidNumber(r, 100, 200);
}while(!isValidNum);

ctx.translate(300,300);
//do the loop until the amount of object finish
for(var i=1;i <= n; i++){
	drawObject(300 - r, 300 - r);//calculating distance of centre use r
	ctx.rotate(toRad(360 / n));//call the toRad and make the radius
	
}
ctx.restore();