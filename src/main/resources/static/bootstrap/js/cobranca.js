$("#confirmaExclusaoModal").on("show.bs.modal", function(event){

	var button = $(event.relatedTarget);
	
	var codigoTitulo = button.data('codigo');
	var descricaoTitulo = button.data('descricao');	
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');

	if(!action.endsWith('/')){
		action += '/';
	}
	
	form.attr('action', action + codigoTitulo);
	
	modal.find('.modal-body span').html('Tem Certeza que Deseja Excluir o Título <strong>'+descricaoTitulo+'</strong>?');

});

$(function(){
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal:',', thousands:'.', allowZero:true});
	
	$('.js-atualiza-status').on('click', function(event){
		
		event.preventDefault();
		
		var btnReceber = $(event.currentTarget);
		var urlReceber = btnReceber.attr('href');

		var response = $.ajax({
			url: urlReceber,
			type: 'PUT'
		});
		
		response.done(function(e){
			var codigoTitulo = btnReceber.data('codigo');
			$('[data-role='+ codigoTitulo +']').html('<span class="label label-success">' + e +'</span>');
			btnReceber.hide();
		});

		response.fail(function(e){
			console.log(e);
			alert('Ocorreu um Erro ao Receber a Cobrança');
		});
		
	});
	
});