function onload(){
}

function over(id){
	document.getElementById(id.id).style.backgroundImage = "url('./images/2.jpg')";
	//id.backgroundImage = "url('2.jpg')";
}
function out(id){
	document.getElementById(id.id).style.backgroundImage = "url('./images/1.jpg')";
}
function _over(id){
	document.getElementById(id.id).style.backgroundImage = "url('./images/2.jpg')";
	//id.backgroundImage = "url('2.jpg')";
}
function _out(id){
	document.getElementById(id.id).style.backgroundImage = "url('./images/11.jpg')";
}
function Onclick(id){
	var hide = document.getElementsByClassName("dis")
	if(hide != null){
		hide[0].className = "undis";
	}
	var number = document.getElementById(id.id).id;
	var grid = document.getElementsByClassName("undis");
	grid[parseInt(number)-1].className = "dis";
}
function _Onclick(id){
	var hide = document.getElementsByClassName("_dis")
	if(hide != null){
		hide[0].className = "_undis";
	}
	var number = document.getElementById(id.id).id;
	var grid = document.getElementsByClassName("_undis");
	grid[parseInt(number)-11].className = "_dis";
}