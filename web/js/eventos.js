$(document).on('click','.evento-desc button',function(){

	var des = $(this).parent().parent();
	var parent = $(this).parent().parent().parent().find('.evento-edit');
	$(parent).toggleClass('hide');
	$(des).toggleClass('hide');
});

$(document).on('click','#guardar',function(){
	var parent_form = $(this).parent().parent();
	var parent_desc = $(this).parent().parent().parent().find('.evento-desc');
	$(parent_form).toggleClass('hide');
	$(parent_desc).toggleClass('hide');
});

