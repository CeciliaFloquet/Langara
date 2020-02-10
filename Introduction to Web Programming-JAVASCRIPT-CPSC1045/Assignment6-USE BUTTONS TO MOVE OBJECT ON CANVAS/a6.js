let width= 600;
let height = 600;
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
let midX = 300;
let midY = 300;
//variable that I used to control the movement of object
let x = midX;
let y = midY;
//start the object in the center of canvas
drawObject(midX,midY);
	
//call function to draw the object
function drawObject(paramX,paramY){
	x=paramX; 
	y=paramY;	
	ctx.save();
	ctx.fillStyle = "pink";
	ctx.beginPath();
	ctx.arc(x,y,30,0,2 * Math.PI);
	ctx.stroke();
	ctx.fill();
	
}

//call function when press button up, move 5 to lup
function up(){
	
	if(y > 30 && y <570){
		ctx.clearRect(0,0, width, height);
		drawObject(x,y-5);
	}
	
}

//call function when press button down, move 5 to down
function down(){
	
	if(y >= 30 && y < 570){
		ctx.clearRect(0,0, width, height);
	
		drawObject(x,y+5);
	}
}

//call function when press button left, move 5 to left
function left(){
	
	if(x > 30  && x < 570){
		ctx.clearRect(0,0, width, height);
		drawObject(x - 5,y);
	}
}

//call function when press button right, move 5 to right
function right(){
	
	if(x >= 0 && x < 570){
		ctx.clearRect(0,0, width, height);
		drawObject(x+5,y);
	}
}

//call function reset that cleared and create the object in the center of canvas
function reset(){
	ctx.clearRect(0,0, width, height);
	drawObject(midX,midY);
}