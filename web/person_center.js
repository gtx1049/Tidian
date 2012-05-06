function Onclick(object){
	var hide = document.getElementsByClassName("dis");
	if(hide != null){
		hide[0].className = "undis";
	}
	var number = document.getElementById(object.id).id;
	var grid = document.getElementsByClassName("undis");
	grid[parseInt(number)-1].className = "dis";
}
function _Onclick(){
    var hide = document.getElementsByClassName("dis");
	if(hide != null){
		hide[0].className = "undis";
	}
    document.getElementById("welcome").className ="dis";
}