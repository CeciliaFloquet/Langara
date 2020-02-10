let n = Math.floor((Math.random() * 100) + 1);
let operation = new Array();
operation[0]= new Array();

document.getElementById("Intup1").innerHTML= n;

let input2Text= document.getElementById("input2").value;

	
	
function Calculate(){
	let input2Text= document.getElementById("input2").value;
		if (isNaN(input2Text)){
			document.getElementById("input3").innerHTML = "BAD INPUT";
		}
		else if(input2Text == " "){
			document.getElementById("input3").innerHTML = "BAD INPUT";
		}
		else{
			let inputSelect= document.getElementById("select1").value;
			
			if(inputSelect== "/"){
				if(input2Text=="0"){
					document.getElementById("input3").innerHTML = "BAD INPUT";
				}
				else{
					document.getElementById("input3").innerHTML= n / input2Text;
				}
			}
			else if(inputSelect== "-"){
				document.getElementById("input3").innerHTML= n - input2Text;
			}
			else if(inputSelect== "+"){
				document.getElementById("input3").innerHTML= parseInt(n) + parseInt(input2Text);
			}
			else if(inputSelect== "*"){
				document.getElementById("input3").innerHTML= n * input2Text;
			}
			
			
			
			
		}
}	