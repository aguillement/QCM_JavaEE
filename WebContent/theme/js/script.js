var examID = $('#examID').val();
var sendLast = false;
var timeLeft = 0;

console.log(timeLeft);
console.log(localStorage.timeLeftStorage);
if(localStorage.timeLeftStorage){
    timeLeft = localStorage.timeLeftStorage
    console.log(timeLeft);
    console.log(localStorage.timeLeftStorage);
    console.log("if");
}else{
	$.ajax({
		type : "POST",
		url : "/QCM_JavaEE/Candidate/AjaxSaveExam",
		data : {examID: examID, getDuration: true},
		datatype : "html",
		success: function(response){
			    console.log("success");
				timeLeft = response * 60;
				console.log(timeLeft);
				console.log(timeLeft);
				console.log(localStorage.timeLeftStorage);
         }
	});
}

var counterJS = setInterval(function() {
	localStorage.timeLeftStorage = timeLeft
	timeLeft--;
	var hours = 0;
	var min = parseInt(timeLeft / 60, 10);
	var sec = parseInt(timeLeft % 60, 10);
	// dureeRestante = dureeRestante * 60;

	while (min >= 60) {
		min -= 60;
		hours++;
	}

	if (min == -1) {
		min = 58;
		hours--;
	}

	// Display the result in the element with id="demo"
	document.getElementById("timer").innerHTML = hours + "h " + min + "m " + sec
			+ "s ";

	// If the count down is finished, write some text
	if (timeLeft <= 0) {
		clearInterval(counterJS);
		document.getElementById("timer").innerHTML = "Temps écoulé";
		$("#anchorBlock").css("display", "block");
	}
}, 1000);

var counterSaveDB = setInterval(function() {
	// Add 1 to timeSpend in database
	if ($("#timer").text() == "Temps écoulé" && !sendLast) {
		sendLast = true;
		$.ajax({
			type : "POST",
			url : "/QCM_JavaEE/Candidate/AjaxSaveExam",
			data : {examID: examID, finished: true},
			datatype : "html"
		});
	} else if($("#timer").text() != "Temps écoulé") {
		$.ajax({
			type : "POST",
			url : "/QCM_JavaEE/Candidate/AjaxSaveExam",
			data : {examID: examID, updateTimer: true},
			datatype : "html"
		});
	}

}, 60000);

function questionMarked(){
	var questionID = $('#question_id').val();
	
	$.ajax({
		type: "POST",
		url: "/QCM_JavaEE/Candidate/AjaxSaveExam",
		data : {examID: examID, questionID: questionID},
		datatype : "html"
	});
	$("#"+questionID).toggleClass("badge-light");
	$("#"+questionID).toggleClass("badge-danger");
}