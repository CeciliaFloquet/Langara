
let chooseToppings = new Array(3);
	chooseToppings[0] = new Array();
	chooseToppings[1] = new Array();
	chooseToppings[2] = new Array();

let price = new Array(3);
	price[0] = [2.50, 3.00, 3.50];
	price[1] = [0.50, 0.75, 0.50, 1.00];
	price[2] = [1.00, 0.00];
    
   
 //function to add toppings  
function addTopping(){
	let choose = document.getElementById("toppings").value;
		
	if(!chooseToppings[1].includes(choose)){
		chooseToppings[1].push(choose);
		var newItem = document.createElement("LI");
		var textnode = document.createTextNode(choose);
		newItem.appendChild(textnode);
		var list = document.getElementById("displaytoppings");
		list.insertBefore(newItem, list.childNodes[0]);
	}
}

function removeTopping(){
	let list= document.getElementById("displaytoppings");
	list.removeChild(list.childNodes[0]); 
	
	chooseToppings[1].pop();
	
}
	
function calculateCost(){
	//price for type of tea
	let chooseTea= document.getElementById("choseTea").value;
	
	let display= 0;
	if(chooseTea == "black"){
		display = price[0][0];
	}
	else if(chooseTea == "green"){
		display = price[0][1];
	}
	else{
		display = price[0][2];
	}

	
	
	//price for toppings
	let display2= 0;
	for(let i=0; i < chooseToppings[1].length; i++){
		if(chooseToppings[1][i] == "Grass Jelly"){
			display2 += price[1][0];
		}
		else if (chooseToppings[1][i]== "Coconut"){
			display2 += price[1][1];
		}
		else if (chooseToppings[1][i] == "Pearls"){
			display2 += price[1][2];
		}
		else{
			display2 += price[1][3];
		}
		
	
	}
	
	//price for milk
	let chooseMilk = document.getElementById("milk").value;
	let display3= 0;
	if(chooseMilk == "yes"){
		display3 = price[2][0];
	}
	else{
		display3 = price[2][1];
	}
	
	let show2 = document.getElementById("price");
	show2.innerHTML = display + display2 + display3;
	
}
	
	

	
	
	
	