//create global array
let student = new Array(2);
 student[0] = new Array();
student[1] = new Array();

 //call function when click submit grade
function submitGrade(){
 
	let studentName = document.getElementById("name").value;
	//push the element of array00
	student[0].push(studentName);
	//push the element to array10
	
	let grade = document.getElementById("grade").value;
	student[1].push(grade);


	let display1= "";
	let display2= "";
	
	let table = document.getElementById("displayGrade");
	var row = table.insertRow(0);
	var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
	
	for(let i=0; i< student[0].length; i++){
		display1 = student[0][i]
		display2= student[1][i];
	}
	

	cell1.innerHTML = display1;
	cell1.innerHTML = display1;
    cell2.innerHTML = display2;
	
	
}
function remove(){
	document.getElementById("displayGrade").deleteRow(0);
}


//call function when to click update summary- to calculate the amount
function updateSummary(){
	let countA =0; let countB=0; let countC=0; let countD=0; let countE=0; let countF=0;
	for (i=0; i < student[0].length; i++){
	if(student[1][i]== 'A'){
		countA++;
	}
	if(student[1][i]== 'B'){
		countB++;
	}
	if(student[1][i]== 'C'){
		countC++;
	}
	if(student[1][i]== 'D'){
		countD++;
	}
	if(student[1][i]== 'E'){
		countE++;
	}
	if(student[1][i]== 'F'){
		countF++;
	}
 }
    //display the calculating
	document.getElementById("displayClass").innerHTML += "A: " + countA + " B: " +countB + " C: " +countC + " D: " + countD + " E: " +countE + " F: " + countF;
}