var timeLeft = (parseInt($('#duration').val()) - parseInt($('#timeSpent').val())) * 60
if(localStorage.timeLeftStorage){
	timeLeft = localStorage.timeLeftStorage
}
var examID = $('#examID').val();
var sendLast = false;

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
		blockNavigation();
		$.alert({
		    title: 'Temps écoulé!',
		    content: 'Veuillez pouvez encore répondre à cette question.',
		    type:'red'
		});
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
			data : "examID=" + examID,
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
	//console.log(questionID)
	$("#"+questionID).toggleClass("badge-light");
	$("#"+questionID).toggleClass("badge-danger");
}

function blockNavigation(){
	$("#navigation").children("a").each(function(){
		var link = $(this)[0];
		$(link).attr('href','#');
		if(!$(link).hasClass("currentQuestion")){
			$(link).addClass("badge-dark");
		}
		
	});
}
const url = $('#finishTestUrl').val();
$('#finishTest').on("click",function(){
	$.alert({
		title : 'Attention!',
		type : "red",
		content : 'Voulez-vous vraiment terminer l\'épreuve ?',
		buttons : {
			oui : function() {
				$(location).attr("href", url);
			},
			non : function() {
			}
		}
	});
})