/*jslint browser:true, es6 */
var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");

const width = 800;
const height = 500;
//QUESTION E - the snowman used the reference of the MID and everything in the snowman used Mid as reference. Then I add(right) 100 for the MID 
const MID = width / 2 + 100;
const GROUND = 400;

ctx.fillStyle = "cyan";
ctx.fillRect(0, 0, width, height);

ctx.fillStyle = "blue";
ctx.fillRect(0, GROUND, width, 100); // ground

//QUESTION C - I change the X position from 800 to -10 because it is the position of right
ctx.fillStyle = "yellow";
ctx.beginPath();
ctx.arc(800, -10, 80, 0, 2 * Math.PI); //sun 
ctx.fill();

//QUESTION D - display my name
ctx.font = "30px Arial";
ctx.fillStyle = "orange";
ctx.fillText("Cecilia Floquet",10,50);

ctx.fillStyle = "white";
ctx.beginPath();
ctx.arc(MID, GROUND - 265, 40, 0, 2 * Math.PI); // head
ctx.fill();
ctx.beginPath();
ctx.arc(MID, GROUND - 160, 70, 0, 2 * Math.PI); // upper torso
ctx.fill();
ctx.beginPath();
ctx.arc(MID, GROUND, 100, 0, 2 * Math.PI); // lower torso
ctx.fill();

//QUESTION A - the position of X is the same(MID).I change the position of Y(Ground-120/ground-180). I used the parameter of upper torso 
ctx.fillStyle = "red";
ctx.beginPath();
ctx.arc(MID, GROUND - 120, 10, 0, 2 * Math.PI);//red circles 1
ctx.fill();
ctx.beginPath();
ctx.arc(MID, GROUND - 180, 10, 0, 2 * Math.PI);//red circles 2
ctx.fill();

ctx.fillStyle = "black";
ctx.beginPath();
ctx.arc(MID - 15, GROUND - 275, 5, 0, 2 * Math.PI); // left eye
ctx.arc(MID + 15, GROUND - 275, 5, 0, 2 * Math.PI); // right eye
ctx.fill();

ctx.beginPath();
ctx.arc(MID - 17, GROUND - 290, 5, 0, Math.PI); //I use the reference of eyes - left eyebrow 
ctx.stroke();

ctx.beginPath();
ctx.arc(MID + 17, GROUND - 290, 5, 0, Math.PI); //right eyebrow 
ctx.stroke();

//QUESTION B - I  change the width and height.I multiply the PI
ctx.beginPath();
ctx.arc(MID, GROUND - 240, 10, 3, 2 * Math.PI); // smile
ctx.stroke();

ctx.moveTo(MID - 50, GROUND - 160);
ctx.lineTo(MID - 140, GROUND - 160); // left arm
ctx.stroke();


ctx.moveTo(MID + 50, GROUND - 160);
ctx.lineTo(MID + 140, GROUND - 200); // right arm
ctx.stroke();

ctx.moveTo(MID - 50, GROUND - 300);
ctx.lineTo(MID + 50, GROUND - 300); // brim of hat
ctx.stroke();

ctx.fillRect(MID - 30, GROUND - 340, 60, 40);

//QUESTION F - I moved to the position of near the eyes.  I start to draw the triangular
ctx.fillStyle = "orange";
ctx.beginPath();
ctx.moveTo(MID, GROUND - 275);
ctx.lineTo(MID + 9, GROUND - 255);
ctx.lineTo(MID, GROUND - 255);
ctx.fill();