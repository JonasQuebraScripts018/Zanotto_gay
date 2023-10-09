$("#enviarLogin").click(validaLogin);
$("#enviarCadastro").click(validaEnvio);

function validaCampoVazio(campo) {
    if (campo.trim() == '') {
        return true;
    } else {
        return false;
    }
}

function validaLogin() {
    let podeEnviar = true
    let cpf = $("#cpfLogar").val();
    let senha = $("#senhaLogar").val();
    if (validaCampoVazio(cpf)) {
        podeEnviar = false;
    }
    if (validaCampoVazio(senha)) {
        podeEnviar = false;
    }
    if (podeEnviar) {
        $.ajax({
            type: "POST",
            url: "/",
            data: {
                cpf: cpf,
                senha: senha,
            },
            success: function (data) {window.location.href = "/home";
                },
            error: function () {
                $("#errorMessage").append("Deu muito ruim parça!");
            }
        });
    }
}


function validaEnvio() {
    let podeEnviar = true;
    let nome = $("#nome").val();
    let cpf = $("#cpf").val();
    let email = $("#email").val();
    let datanasc = $("#datanasc").val();
    let telefone = $("#telefone").val();
    let senha = $("#senha").val();
    let mensagem = "";

    if (validaCampoVazio(nome)) {
        podeEnviar = false;
        mensagem += "O Nome precisa ser Preenchido!";
    }
    if (validaCampoVazio(email) && validaCampoVazio(telefone)) {
        podeEnviar = false;
        mensagem += "Email ou telefone precisa ser informado!";
    }
    if (validaCampoVazio(datanasc)) {
        podeEnviar = false;
        mensagem += "A data de nascimento precisa ser informada!";
    }
    if (validaCampoVazio(senha)) {
        podeEnviar = false;
        mensagem += "A senha precisa ser informada e igual a Confirmação de Senha!";
    }
    if (validaCampoVazio(cpf)) {
        podeEnviar = false;
        mensagem += "O CPF informado é Inválido!";
    }

    if (podeEnviar) {
        $.ajax({
            type: "POST",
            url: "/Cadastrar",
            data: {
                nome: nome,
                cpf: cpf,
                email: email,
                senha: senha,
                datanasc: datanasc,
                telefone: telefone,
            },
            success: function (data) {
                if(data.sucesso){
                    alert("Deu bom, Faça seu login!");
                }else{
                    alert(data.mensagem);
                }
            },
            error: function () {
                alert("Deu muito ruim parça!");
            }
        });
    }
}

const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
    container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
    container.classList.remove("right-panel-active");
});