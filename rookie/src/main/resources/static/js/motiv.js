/**
 * 
 */
$(function() {
 			$("input,select,textarea").on('change', function() {
 						$('.err').remove();
 						//同じインデックス番号の仲間が集まる
 						let current = $(this);
 						let index_num = $(this).attr("class").split('-')[1];
 						if (index_num != 0) {
 						var formData = {
 							motivationId : $('.motivationId-' + index_num)
 									.val(),
 							companyMotivation : $(
 									'.companyMotivation-' + index_num).val(),
 							jobMotivation : $('.jobMotivation-' + index_num)
 									.val(),
 							comment : $('.comment-' + index_num).val(),
 							interviewDate : $('.interviewDate-' + index_num)
 									.val(),
 							retireRisk : $('.retireRisk-' + index_num).prop(
 									'checked')
 						}
 						const xsrf = $.cookie('XSRF-TOKEN');
 						$.ajax({
 							type : "POST",
 							url : "editComment",
 							contentType : "application/json",
 							//javaからJSON形式に書き換える
 							data : JSON.stringify(formData),
 							dataType : "json",
 							headers : {
 								'X-XSRF-TOKEN' : xsrf
 							},
 							success : function(data, status, xhr) {
 								if (data[1]['fields'] != null ||data[2]['fields'] != null 
 									||data[3]['fields'] != null||data[4]['fields'] != null) { 
 									var motivationId = data[0]['messages'];
 									for (var i = 1; i < data.length; i++) {
 										var itemName = data[i]['fields'];
 										var errorMessages = data[i]['messages'];
 										var errorHTML = '<p class="err">'
 											+ errorMessages + '</p>'
 										$('.' + itemName + '-' + motivationId)
 											.after(errorHTML);
  									}  
 								}
 							},
 							error : function(XMLHttpRequest, textStatus,
 									errorThrown) {
 								console.log("errr");
 								console.log("XMLHttpRequest : "
 										+ XMLHttpRequest.status);
 								console.log("textStatus     : " + textStatus);
 								console.log("errorThrown    : "
 										+ errorThrown.message);
 							}
 						
 						});
 						}else {
 							//TODO cssで存在しないレコードは灰色などにしたい
 							$(this).css('backgroundcolor','red');
 						}
 					});
 		});