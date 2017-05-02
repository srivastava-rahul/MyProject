$(document).ready(function(){

	// first example
	// $("#navigation").treeview({
	// 	collapsed: true,
	// 	unique: true,
	// 	persist: "location"
	// });


	// second example
	// $("#browser").treeview({
	// 	animated:"normal",
	// 	persist: "cookie"
	// });

	// $("#samplebutton").click(function(){
	// 	var branches = $("<li><span class='folder'>New Sublist</span><ul>" +
	// 		"<li><span class='file'>Item1</span></li>" +
	// 		"<li><span class='file'>Item2</span></li></ul></li>").appendTo("#browser");
	// 	$("#browser").treeview({
	// 		add: branches
	// 	});
	// });


	// third example
	// $("#treeviewMenu").treeview({
	// 	animated: "fast",
	// 	collapsed: true,
	// 	control: "#treecontrol"
	// });


	//     var curPage="";
    // $("#treeviewMenu a").click(function() {
    //     if (curPage.length) {
    //         $("#"+curPage).hide();
    //     }
    //     curPage=$(this).data("page");
    //     $("#"+curPage).show();
    // });


/*	 $('#red a').click(function() {
	$('#red a').removeClass('active');
    $(this).addClass('active');
});
*/

// $('#treeviewMenu a').on('click', function() {
// 	var t = $(this);
//   t.parents('#red').find('li').removeClass('act');
//   t.parentsUntil('#red', 'li').addClass('act');

// });


//show / hide left column
var pageH = $('.PageContent').height() + 40;
$('.col-left').height(pageH)
		$('.slider-arrow').click(function(){
			if($(this).hasClass('show1')){
		$( ".col-left" ).animate({left: "+=284" }, 700, function() {
					// Animation complete.
				});
	 // $(".col-left").css({'width':'20%'})
		$(".col-right").animate({'width':'calc(80% + 10px)','float':'right','margin-left':'300px'},700)
		$(this).html('&laquo;').removeClass('show1').addClass('hide1');
			$( ".col-left > .scroll1" ).animate({'opacity':'1'},700)
			}
			else {
		$( ".col-left" ).animate({left: "-=284px", 'margin-left':'16px' }, 700, function() {
					// Animation complete.
				});
	//  $(".col-left").css({'width':'4%'})
		$(".col-right").animate({'width':'calc(100% - 16px)','float':'right','margin-left':'16px'},700)
		$(this).html('&raquo;').removeClass('hide1').addClass('show1');
		$( ".col-left > .scroll1" ).animate({'opacity':'0'},700)
			}
	});
// end

// treeview Menu
$("#treeviewMenu").treeview({
	animated: "fast",
	collapsed: true,
	control: "#treecontrol"
});


		var curPage="";
	$("#treeviewMenu a").on('click',function() {
		debugger;
		
			if (curPage.length) {
				$("#"+curPage).hide();
			}
			curPage=$(this).data("page");
			alert(curPage);
			$("#"+curPage).show();
	});


/*	 $('#red a').click(function() {
$('#red a').removeClass('active');
	$(this).addClass('active');
});
*/

$('#treeviewMenu a').on('click', function() {
var t = $(this);
t.parents('#treeviewMenu').find('li').removeClass('act');
t.parentsUntil('#treeviewMenu', 'li').addClass('act');

});



         		

});
