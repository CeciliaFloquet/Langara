var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");

ctx.fillStyle = "blue";
ctx.beginPath();
ctx.moveTo(0, 0);
ctx.lineTo(150, 100);
ctx.lineTo(0, 200);
ctx.fill();
        

ctx.fillStyle = "red";
ctx.beginPath();
ctx.moveTo(0, 200);
ctx.lineTo(150, 100);
ctx.lineTo(300, 100);
ctx.lineTo(300, 100);
ctx.lineTo(300, 200);
ctx.fill();

 
 