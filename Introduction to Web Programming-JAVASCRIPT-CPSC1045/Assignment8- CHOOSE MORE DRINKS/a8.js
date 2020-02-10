let chooseTea;
let chooseMilk;

let chooseToppings = new Array(3);
	chooseToppings[0] = new Array();
	//toppings
	chooseToppings[1] = new Array();
	chooseToppings[2] = new Array();

let price = new Array(3);
	price[0] = [0.00, 2.50, 3.00, 3.50];
	price[1] = [0.00, 0.50, 0.75, 0.50, 1.00];
	price[2] = [0.00, 1.00, 0.00];
    

 //function call when click in add toppings  
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

//function call when click in remove toppings  
function removeTopping(){
	let list= document.getElementById("displaytoppings");

	chooseToppings[1].splice(0, chooseToppings.length);
	while (list.hasChildNodes()) {
      list.removeChild(list.firstChild);
   }
}

//question 1-constructor
function BubbleTea(teaType, toppingsList, milkOption){
	this.teaType = chooseTea;
	this.toppingsList = chooseToppings[1].slice();
	this.milkOption = chooseMilk;
	this.cost= calculateCost(this);
}	
//question 2	
function calculateCost(bbtObject){
	//price for type of tea
	let display= 0;
	if(bbtObject.teaType == ""){
		display = price[0][0];
	}
	if(bbtObject.teaType == "black"){
		display = price[0][1];
	}
	else if(bbtObject.teaType == "green"){
		display = price[0][2];
	}
	else if(bbtObject.teaType == "red"){
		display = price[0][3];
	}

	//price for toppings
	let display2= 0;
	for(let i=0; i <= bbtObject.toppingsList.length; i++){
		if(bbtObject.toppingsList[i] == ""){
			display2 += price[1][0];
		}
		else if(bbtObject.toppingsList[i] == "Grass Jelly"){
			display2 += price[1][1];
		}
		else if (bbtObject.toppingsList[i]== "Coconut"){
			display2 += price[1][2];
		}
		else if (bbtObject.toppingsList[i] == "Pearls"){
			display2 += price[1][3];
		}
		else if(bbtObject.toppingsList[i] == "Mango Stars"){
			display2 += price[1][4];
		}	
	}
	
	//price for milk
	let display3= 0;
	if(bbtObject.milkOption == ""){
		display3 = price[2][0];
	}
	else if(bbtObject.milkOption == "yes"){
		display3 = price[2][1];
	}
	else if(bbtObject.milkOption == "no"){
		display3 = price[2][2];
	}
	return display + display2 + display3;
}
//question4//function to display order the price total
function displayTable(){
	let total=0;
	for(let i=0; i<listDrinks.length; i++){
		 total += listDrinks[i].cost;
	}
	document.getElementById("cost").innerHTML = "$" + total;
}


let listDrinks= new Array;
let count=1;
var row;
var table;
let countRow=1;
//question3-add drink
function addDrink(){
	chooseTea= document.getElementById("choseTea").value;
	chooseMilk = document.getElementById("milk").value;
	listDrinks.push(new BubbleTea());
	table = document.getElementById("myTable");
    row = table.insertRow(countRow);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	countRow++;
	for(let i=0; i<listDrinks.length; i++){
		cell1.innerHTML = "Drink" + count;
		cell2.innerHTML = listDrinks[i].teaType;
		cell3.innerHTML = listDrinks[i].milkOption;
		cell4.innerHTML = listDrinks[i].toppingsList;
		cell5.innerHTML = "$" + listDrinks[i].cost;
	}
	count ++;
	displayTable();
}

//question3-remove last drink
function removeDrink(){
	listDrinks.pop();
	document.getElementById("myTable").deleteRow(table.rows.length - 2);
	countRow--;
	count--;
	displayTable();
}

//question 3- empty drink list-reset
function resetOrder(){	
	listDrinks.splice(0, listDrinks.length);
	for(var i = table.rows.length - 2; i > 0; i--){
		table.deleteRow(i);
	}	
	count=1;
	countRow=1;
	displayTable();
}

