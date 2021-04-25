#language:pt
Funcionalidade: Login

  @VerificarTentativadelogincomusuarioesenhainexistentes
  Cenário: Verificar tentativa de login com usuário inválido
    Dado que estou na tela de Login takeBlip
    Quando informo email "nãotente@nãotente.com.br" inválido
    Então vejo a mensagem "Deve ser um e-mail válido" abaixo do campo Usuário
    E encerro a minha aplicação

  @VerificarTentativadelogincomusuarioesenhainvalidos
  Cenário: Verificar tentativa de login com usuário e senha inválidos
    Dado que estou na tela de Login takeBlip
    Quando informo meus dados de acesso
      | usuario               | senha         |
      | acolella@gmail.com.br | saicorona2021 |
    Então vejo a mensagem "Login e/ou senha inválidos"
    E encerro a minha aplicação

  @Verificartentativadelogincomusuárioesenhaembrancos
  Cenário: Verificar tentativa de login com usuário e senha em brancos
    Dado que estou na tela de Login takeBlip
    Quando não informo meus dados de acesso
    Então vejo a mensagem "Este campo é obrigatório" abaixo do campo Usuário
    E vejo a mensagem "Este campo é obrigatório" abaixo do campo Senha
    E encerro a minha aplicação
