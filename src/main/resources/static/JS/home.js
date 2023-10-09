$('a').click(function(event){
	event.preventDefault();
	if(!$(this).hasClass('btn')){
		$('a').removeClass('active disable text-Blue');
		$(this).addClass('active disable text-Blue');
	}
	controleRotasGet($(this).attr("href"));
});

function controleRotasGet(url){
	switch(url){
		case "/logout":
			gerarSwal(url);
			break;
		case "/conta":
			$.get(url,function(data){
				$(".container").html(data);
			});
			break;
		case "/deposito":
			$.get(url,function(data){
				$(".container").html(data);
				$("#enviar").click(validaEnvioDeposito);
			});
			break;
		case "/transacao":
			$.get(url,function(data){
				$(".container").html(data);
				$("#enviar").click(validaEnvioTransacao);
			});
			break;

	}
}
function gerarSwal(urlSucesso) {
	const swalWithBootstrapButtons = Swal.mixin({
		customClass: {
			confirmButton: 'btn btn-success me-2',
			cancelButton: 'btn btn-danger ms-2'
		},
		buttonsStyling: false
	})

	swalWithBootstrapButtons.fire({
		title: 'Salve meu parça!',
		text: "Tu quer sair?",
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: 'Vlw flw',
		cancelButtonText: 'Mb miss click!',
		reverseButtons: false
	}).then((result) => {
		if (result.isConfirmed) {
			window.location.href = urlSucesso
		} else if (result.dismiss === Swal.DismissReason.cancel) {

		}
	})
}

// ---------Responsive-navbar-active-animation-----------
function test(){
	var tabsNewAnim = $('#navbarSupportedContent');
	var selectorNewAnim = $('#navbarSupportedContent').find('li').length;
	var activeItemNewAnim = tabsNewAnim.find('.active');
	var activeWidthNewAnimHeight = activeItemNewAnim.innerHeight();
	var activeWidthNewAnimWidth = activeItemNewAnim.innerWidth();
	var itemPosNewAnimTop = activeItemNewAnim.position();
	var itemPosNewAnimLeft = activeItemNewAnim.position();
	$(".hori-selector").css({
		"top":itemPosNewAnimTop.top + "px",
		"left":itemPosNewAnimLeft.left + "px",
		"height": activeWidthNewAnimHeight + "px",
		"width": activeWidthNewAnimWidth + "px"
	});
	$("#navbarSupportedContent").on("click","li",function(e){
		$('#navbarSupportedContent ul li').removeClass("active");
		$(this).addClass('active');
		var activeWidthNewAnimHeight = $(this).innerHeight();
		var activeWidthNewAnimWidth = $(this).innerWidth();
		var itemPosNewAnimTop = $(this).position();
		var itemPosNewAnimLeft = $(this).position();
		$(".hori-selector").css({
			"top":itemPosNewAnimTop.top + "px",
			"left":itemPosNewAnimLeft.left + "px",
			"height": activeWidthNewAnimHeight + "px",
			"width": activeWidthNewAnimWidth + "px"
		});
	});
}
$(document).ready(function(){
	setTimeout(function(){ test(); });
});
$(window).on('resize', function(){
	setTimeout(function(){ test(); }, 500);
});
$(".navbar-toggler").click(function(){
	$(".navbar-collapse").slideToggle(300);
	setTimeout(function(){ test(); });
});



// --------------add active class-on another-page move----------
jQuery(document).ready(function($){
	// Get current path and find target link
	var path = window.location.pathname.split("/").pop();

	// Account for home page with empty path
	if ( path == '' ) {
		path = 'index.html';
	}

	var target = $('#navbarSupportedContent ul li a[href="'+path+'"]');
	// Add active class to target link
	target.parent().addClass('active');
});




// Add active class on another page linked
// ==========================================
// $(window).on('load',function () {
//     var current = location.pathname;
//     console.log(current);
//     $('#navbarSupportedContent ul li a').each(function(){
//         var $this = $(this);
//         // if the current path is like this link, make it active
//         if($this.attr('href').indexOf(current) !== -1){
//             $this.parent().addClass('active');
//             $this.parents('.menu-submenu').addClass('show-dropdown');
//             $this.parents('.menu-submenu').parent().addClass('active');
//         }else{
//             $this.parent().removeClass('active');
//         }
//     })
// });