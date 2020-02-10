var c=document.getElementById("myCanvas");
var ctx=c.getContext("2d");


ctx.fillStyle="black";
ctx.rect(0, 0, 150, 300);
ctx.fill();
ctx.stroke();

var light1=0;

//CIRCLE 1
    ctx.fillStyle="gray";
	ctx.beginPath();
	ctx.strokerStyle="black";
	ctx.arc(60,50,40,0,2*Math.PI);
	ctx.fill();
	ctx.stroke();
//CIRCLE 2	
	ctx.fillStyle="gray";
	ctx.beginPath();
	ctx.strokerStyle="black";
	ctx.arc(60,150,40,0,2*Math.PI);
	ctx.fill();
	ctx.stroke();
//CIRCLE 1	
	ctx.fillStyle="gray";
	ctx.beginPath();
	ctx.strokerStyle="black";
	ctx.arc(60,250,40,0,2*Math.PI);
	ctx.fill();
	ctx.stroke();

		

function changeLight(){
		if (light1 ==0){
			
			 ctx.fillStyle="red";
		ctx.beginPath();
		ctx.strokerStyle="black";
		ctx.arc(60,50,40,0,2*Math.PI);
		ctx.fill();
		ctx.stroke();
		light1++;
		}
		else if (light1 == 1){
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,50,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			
			ctx.fillStyle="yellow";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,150,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			light1++;
		}
		else if (light1 == 2){
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,50,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,150,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			
			ctx.fillStyle="green";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,250,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			light1++;
		}
		
		else {
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,50,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,150,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			
			ctx.fillStyle="gray";
			ctx.beginPath();
			ctx.strokerStyle="black";
			ctx.arc(60,250,40,0,2*Math.PI);
			ctx.fill();
			ctx.stroke();
			light1=0;
		}
		
	}

	
	
	
	
	