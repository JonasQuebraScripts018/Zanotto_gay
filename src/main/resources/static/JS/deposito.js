
function validaCampoVazio(campo) {
    if (campo.trim() == '') {
        return true;
    } else {
        return false;
    }
}

function validaEnvioDeposito(){
    let podeEnviar = true;
    let valorDeposito = $("#valorDeposito").val();
    let senha = $("#senha").val();
    let cpf = $("#cpf").val();

    if(validaCampoVazio(valorDeposito)){
        podeEnviar = false;
    }
    if(podeEnviar){
        $.ajax({
            type: "POST",
            url: "/deposito",
            data:{
                valorDeposito:valorDeposito,
                cpf: cpf,
                senha: senha,
            },
            success: function (data){
                if(data.sucesso){
                    alert("Deu bom, mas agr vc ficou um pouco menos probre!");
                }else{
                    alert(data.mensagem);
                }
            },
            error: function (){
                $("#errorMessage").append("Deu muito ruim parça!");
            }
        });
    }
}
