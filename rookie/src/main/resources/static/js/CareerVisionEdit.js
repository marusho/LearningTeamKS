$(function() {
	$("#firstEssential").keyup(function() {
		var txtcount1 = $(this).val().length;
		$("#txtlmt1").text(txtcount1);
		if (txtcount1 == 0) {
			$("#txtlmt1").text("0");
		}
		if (txtcount1 >= 80) {
			$("#txtlmt1").css("color", "#d577ab");
		} else {
			$("#txtlmt1").css("color", "#333");
		}
	});
	$("#secondEssential").keyup(function() {
		var txtcount2 = $(this).val().length;
		$("#txtlmt2").text(txtcount2);
		if (txtcount2 == 0) {
			$("#txtlmt2").text("0");
		}
		if (txtcount2 >= 80) {
			$("#txtlmt2").css("color", "#d577ab");
		} else {
			$("#txtlmt2").css("color", "#333");
		}
	});
	$("#thirdEssential").keyup(function() {
		var txtcount3 = $(this).val().length;
		$("#txtlmt3").text(txtcount3);
		if (txtcount3 == 0) {
			$("#txtlmt3").text("0");
		}
		if (txtcount3 >= 80) {
			$("#txtlmt3").css("color", "#d577ab");
		} else {
			$("#txtlmt3").css("color", "#333");
		}
	});
	$("#freetext").keyup(function() {
		var txtcount4 = $(this).val().length;
		$("#txtlmt4").text(txtcount4);
		if (txtcount4 == 0) {
			$("#txtlmt4").text("0");
		}
		if (txtcount4 >= 900) {
			$("#txtlmt4").css("color", "#d577ab");
		} else {
			$("#txtlmt4").css("color", "#333");
		}
	});
	$("#oneyearVision").keyup(function() {
		var txtcount5 = $(this).val().length;
		$("#txtlmt5").text(txtcount5);
		if (txtcount5 == 0) {
			$("#txtlmt5").text("0");
		}
		if (txtcount5 >= 900) {
			$("#txtlmt5").css("color", "#d577ab");
		} else {
			$("#txtlmt5").css("color", "#333");
		}
	});
	$("#threeyearsVision").keyup(function() {
		var txtcount6 = $(this).val().length;
		$("#txtlmt6").text(txtcount6);
		if (txtcount6 == 0) {
			$("#txtlmt6").text("0");
		}
		if (txtcount6 >= 900) {
			$("#txtlmt6").css("color", "#d577ab");
		} else {
			$("#txtlmt6").css("color", "#333");
		}
	});
	$("#fiveyearsVision").keyup(function() {
		var txtcount7 = $(this).val().length;
		$("#txtlmt7").text(txtcount7);
		if (txtcount7 == 0) {
			$("#txtlmt7").text("0");
		}
		if (txtcount7 >= 900) {
			$("#txtlmt7").css("color", "#d577ab");
		} else {
			$("#txtlmt7").css("color", "#333");
		}
	});

});
