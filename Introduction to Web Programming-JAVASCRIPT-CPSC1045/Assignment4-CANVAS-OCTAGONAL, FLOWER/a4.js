 //Question A
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");

//circle

ctx.fillStyle = "black";
ctx.beginPath();
ctx.arc(300,300,10,0,2 * Math.PI);
ctx.stroke();
ctx.fill();


//right leaf
ctx.save()
ctx.beginPath();
ctx.moveTo(300,300);
ctx.lineTo(400,300);
ctx.lineTo(375,275);
ctx.lineTo(325,275);
ctx.lineTo(300,300);
ctx.lineTo(325,325);
ctx.lineTo(375,325);
ctx.lineTo(400,300);
ctx.stroke();
ctx.restore();

//down leaf
ctx.save()
ctx.beginPath();
ctx.moveTo(300,300);
ctx.lineTo(300,400);
ctx.lineTo(280,370);
ctx.lineTo(280,330);
ctx.lineTo(300,300);
ctx.lineTo(320,325);
ctx.lineTo(320,370);
ctx.lineTo(300,400);
ctx.stroke();
ctx.restore();

//up right leaf 
ctx.save()
ctx.beginPath();
ctx.moveTo(300,300);
ctx.lineTo(320,220);
ctx.lineTo(300,230);
ctx.lineTo(290,270);
ctx.lineTo(300,300);
ctx.lineTo(320,275);
ctx.lineTo(330,240);
ctx.lineTo(320,220);
ctx.stroke();
ctx.restore();

//up left leaf 
ctx.save()
ctx.beginPath();
ctx.moveTo(300,300);
ctx.lineTo(220,250);
ctx.lineTo(230,270);
ctx.lineTo(270,300);
ctx.lineTo(300,300);
ctx.lineTo(285,270);
ctx.lineTo(250,245);
ctx.lineTo(220,250);
ctx.stroke();
ctx.restore();

//down left leaf 
ctx.save()
ctx.beginPath();
ctx.moveTo(300,300);
ctx.lineTo(210,350);
ctx.lineTo(210,350);
ctx.lineTo(220,320);
ctx.lineTo(270,300);
ctx.lineTo(300,300);
ctx.lineTo(280,325);
ctx.lineTo(230,350);
ctx.lineTo(210,350);
ctx.stroke();
ctx.restore();

 
//QUESTION B
var canvas = document.getElementById("myCanvas2");
var ctx = canvas.getContext("2d");

ctx.beginPath(); 
ctx.translate(300,300);
for(var count = 0; count <= 8; count++){     
	ctx.lineTo(100,0); 
    ctx.rotate(45*Math.PI/180);
}
ctx.stroke()

