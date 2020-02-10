//PART2 create constructor
 function Animal(name,gender2,species){
	this.name = name;
	this.gender = gender2;
	this.species = species;
 } 
 
 
 //PART3- global array
let animalNum = new Array(); 
 
  
 //PART4
 function addAnimal(){
	 //take values of input
	let name = document.getElementById("animalName").value;
	let gender2 = document.getElementsByName("gender");
	let species = document.getElementById("animalType").value; 
	let gender;
	//use for to take which is value of radio
	for(let i=0; i< gender2.length; i++){
		if(gender2[i].checked){
			gender =  gender2[i].value; 
		}
	}
	//created object
	let animalStore= new Animal(name,gender,species);
	
	//push animal to array
	animalNum.push(animalStore); 
	
	//call function to display animals 
	display(animalStore);
	 
 }
 
  //PART5
 //function to display the animals
function display(animalStore){
	var newItem = document.createElement("LI");
	var textnode = document.createTextNode(animalStore.name + " " + animalStore.gender +" "+ animalStore.species);
	newItem.appendChild(textnode);
	var list = document.getElementById("display");
	list.insertBefore(newItem, list.childNodes[0]);	
 }
 
 



