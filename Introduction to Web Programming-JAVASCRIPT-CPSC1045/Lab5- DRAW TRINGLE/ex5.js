//question A
let canvas = document.getElementById("myCanvas");
let ctx = canvas.getContext("2d");

function drawTriangle(x,y){
	ctx.save();
	ctx.beginPath();
	ctx.lineTo(x,y);
	ctx.lineTo(x+50, y+100);
	ctx.lineTo(x-50, y+100);
	ctx.lineTo(x,y);
	ctx.stroke();
	ctx.fillStyle = "yellow";
	ctx.fill();
	ctx.restore();
}


drawTriangle(100, 0);//top
drawTriangle(150, 100);//right
drawTriangle(50, 100);//left



//question B

let x = +prompt("Please enter the number");
if(x <= 0){
	console.log("Error: this program just accept positive numbers");
}
else{
	palindromicNumber(x);
}

function palindromicNumber(x){
		var y = 1;
		
		if(x % 10 == 0){
				console.log("Error: this problem does not have solution");
		}
		else{
			do{
				var resultReverse = "";
				var result = x * y;
				for(var i= result.toString().length-1; i >=0  ; i--){
					resultReverse += result.toString().charAt(i);
				}
				
				if( result == resultReverse){
					console.log(x + "*" + y  + "= " + result);
				
				}
				else{
					y++;
				}
			}while( result != resultReverse);
		}
}