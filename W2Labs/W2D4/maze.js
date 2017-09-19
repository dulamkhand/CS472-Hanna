"use strict"; 
(function(){

    var gameStarted = false;
    function youLose(){
		if(gameStarted){
			$("#status").text("Sorry, you lost! :[");
			$(".boundary").addClass("youlose");
			alert("Sorry, you lost! :[");
			gameStarted = false;
		}
	}
	
	$(function(){
		$("#start").click(function(){
			gameStarted = true;
			$("#status").text("Game Started!");
			$(".boundary").removeClass("youlose");
		});

		$(".boundary").mouseover(function(){
			if(gameStarted){
				youLose();
			}	
		});
		$("#end").click(function(){
			if(gameStarted){
				gameStarted = false;
				$("#status").text("You win! :]");
				alert("You win! :]");
			}	
		});
		$("#maze").mouseleave(function(){
			if(gameStarted){
				youLose();
				$(".boundary").addClass("Cheater");
				alert("Cheater! :[");
			}	
		});
	});

}());
