//全件検索のフィルターを非表示に
$(function() {
	$(".dataTables_filter").children().css('display', 'none');
});

//Datatableを生成
var table1 = $('#results').DataTable({
	"scrollY" : "800px"
});

var table2 = $('#results2').DataTable({
	"scrollY" : "800px"
});

var table3 = $('#results3').DataTable({
	"scrollY" : "800px"
});

//名前による検索
$('#nameSearch').on('keyup', function() {
	table1.columns(0).search(this.value).draw();
});

$('#nameSearch2').on('keyup', function() {
	table2.columns(0).search(this.value).draw();
});

$('#nameSearch3').on('keyup', function() {
	table3.columns(0).search(this.value).draw();
});

//エンジニアレベルによる検索
$('#eLevel').on('keyup', function() {
	table1.columns(1).search(this.value).draw();
});

$('#eLevel2').on('keyup', function() {
	table2.columns(1).search(this.value).draw();
});

$('#eLevel3').on('keyup', function() {
	table3.columns(1).search(this.value).draw();
});

//チーム名による検索
$('#teamSearch').on('keyup', function() {
	table1.columns(2).search(this.value).draw();
});

$('#teamSearch2').on('keyup', function() {
	table2.columns(2).search(this.value).draw();
});

$('#teamSearch3').on('keyup', function() {
	table3.columns(2).search(this.value).draw();
});

//各項目の表示非表示を切り替えるボタン
$(function() {
	$('input[name="check1"]').change(function() {
		var prop1 = $('#button1').prop('checked');
		if (prop1) {
			$(".achievementColumn").show();
			$("#button1").addClass("showOn1");
		} else {
			$(".achievementColumn").css("display", "none");
			$("#button1").removeClass("showOn1");
		}
	});
});

$(function() {
	$('input[name="check2"]').change(function() {
		var prop2 = $('#button2').prop('checked');
		if (prop2) {
			$(".abilityColumn").show();
			$("#button2").addClass("showOn2");
		} else {		
			$(".abilityColumn").css("display", "none");
			$("#button2").removeClass("showOn2");
		}
	});
});

$(function() {
	$('input[name="check3"]').change(function() {
		var prop3 = $('#button3').prop('checked');
		if (prop3) {
			$(".passionColumn").show();
			$("#button3").addClass("showOn3")
		} else {
			$(".passionColumn").css("display", "none").removeClass("showOn3");
			$("#button3").removeClass("showOn3");
		}
	});
});

//タブを付け加える
$(function() {
	$("#j-tab").addClass('tabed');
	$("h1").addClass('j-h1').click(function() {
		$(".selected").removeClass('selected');
		$(this).addClass('selected');
	});
});

//csvファイルダウンロードのためのリンク作成
$(function() {
	var year1 = $("#year1").val();
	var year2 = $("#year2").val();
	var year3 = $("#year3").val();
	var term1 = $("#term1").val();
	var term2 = $("#term2").val();
	var term3 = $("#term3").val();
	var url1 = '/csv/' + year1 + '/' + term1;
	var url2 = '/csv/' + year2 + '/' + term2;
	var url3 = '/csv/' + year3 + '/' + term3;
	$("#latest1").attr("href", url1);
	$("#latest2").attr("href", url2);
	$("#latest3").attr("href", url3);
});


//表示の崩れを直す
$(document).on('click', '.paginate_button:visible, .input-sm .sorting', check);

function check() {

	if ($("#button1").hasClass("showOn1")) {
		$(".achievementColumn").show();
		$('input[name="check1"]').prop("checked", true);
	} else {
		$(".achievementColumn").hide();
		$('input[name="check1"]').prop("checked", false);
	}
	if ($("#button2").hasClass("showOn2")) {
		$(".abilityColumn").show();
		$('input[name="check2"]').prop("checked", true);
	} else {
		$(".abilityColumn").hide();
		$('input[name="check2"]').prop("checked", false);
	}
	if ($("#button3").hasClass("showOn3")) {
		$(".passionColumn").show();
		$('input[name="check3"]').prop("checked", true);
	} else {
		$(".passionColumn").hide();
		$('input[name="check3"]').prop("checked", false);
	}
}


