# PetShopCTD2 Back-End Rest API
Este é um projeto Rest API de cadastro e controle de um petshop.

Sobre o projeto
Basicamente, este projeto busca fornecer os serviços de backend de um CRUD de donos de animais, animais, veternários, consultas, vacinas e aplicações de vacinas. 
Onde é possível, das informações citadas acima, listar, cadastradar, buscar por ID, atualizar e remover.

As principais funcionalidades que foram implementadas, são:

API com rotas implementadas segundo o padrão REST;
Validações feitas conforme as regras de negócio;
Implementação de base de dados para persistência das informações;
Tratamento e customização de exceções;
Serviço de autenticação para acesso às rotas GET, POST, PUT e DELETE.
Ambiente de desenvolvimento:
Windows 11: o SO da máquina de desenvolvimento;
Java: Linguagem de promação server-side;
Framework Spring: Spring Boot;
H2: o H2 é um banco de dados SQL em memória gratuito.
Este projeto foi um experimento de desenvolvimento com um prazo curto. Simulando como seria na vida real de um desenvolvedor em uma empresa.

#Posso rodar este projeto local?
##Se deseja clonar este projeto e executá-lo há dois usos 
###testes unitários:
acessar o caminho src/main/test/repositories e escolher os testes a serem executados

###Rodar a api localmente
Será necessário utilizar uma ferramenta para requisição de rotas http (como postman ou insominia);
Após rodar a classe PetShopCtd2Application, será necessário: 
configurar ferramenta para a autenticação Basic Auth;
pegando o algum dos e-mails que estão no arquivo import.sql da tb_user
e a senha 123456(está cadastrada a mesma senha para todos).
localhost:8080/...(a rota escolhida)
Obs: há dois perfis: 
*o adminstrador (ADMIN): que pode acessar todos os caminhos sem restrição; (os dois primeiros cadastrados são ADMIN)
*o usuário (USER): que tem rotas restritas, não pode criar e nem deletar(POST DELETE). (todos os outros são usuários)

Se estiver usando o IntelliJ, não esqueça de fazer com que o Maven baixe as dependências do pom.xml

Deploy
Futuramente pretendo subir este projeto.
