$("#enviarTransacao").click(validaEnvioTransacao);

function validaEnvioTransacao(){
    let podeEnviar = true;
    let cpf = $("#cpf").val();
    let valorTransacao = $("#valorTransacao").val();
    let senha = $("#senha").val();

    if(valorTransacao == null){
        podeEnviar = false;
    }
    if(podeEnviar){
        $.ajax({
            type: "POST",
            url: "/transacao",
            data:{
                cpf: cpf,
                senha: senha,
                valorTransacao:valorTransacao,
            },
            success: function (data){
                if(data.sucesso){
                    alert("Deu bom!");
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