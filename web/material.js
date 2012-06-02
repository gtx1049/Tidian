function over(number){
	switch (number)
	{
	case 1:
		display("s_week","s_month","s_total");
		break;
	case 2:
		display("s_month","s_week","s_total");
		break;
	case 3:
		display("s_total","s_week","s_month");
		break;
	case 4:
		display("d_week","d_month","d_total");
		break;
	case 5:
		display("d_month","d_week","d_total");
		break;
	case 6:
		display("d_total","d_week","d_month");
		break;
	}
}

function display(first, second, third){
	document.getElementById(first).style.display ="block";
	document.getElementById(second).style.display ="none";
	document.getElementById(third).style.display ="none";
}