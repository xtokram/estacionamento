

# API Estacionamento - Spring <img src="https://cdn-icons-png.flaticon.com/128/5968/5968282.png" height=28>


## Índice <img src="https://cdn-icons-png.flaticon.com/128/839/839860.png" height=28>
* 1 - [Introdução](#introducao)  
* 2 - [Tecnologias Utilizadas](#tecnologias)
* 3 - [Principais Funcionalidades](#funcionalidades)
* 4 - [Informações](#informacoes) 
* 5 - [Como Utilizar](#utilizar)
* 6 - [Contribua](#contribua)


<br></br>

<a name="introducao"></a> 
## Introdução  <img src="https://cdn-icons-png.flaticon.com/128/4129/4129437.png" height=28>
Este é um projeto idealizado pelo professor Eduardo Sganderla, o objetivo do projeto é ensinar tecnologias como Java, Springboot e PostgreSQL para os estudantes de Engenharia de Software da Uniamérica Descomplica.

<br></br>
<a name="informacoes"></a>    
## Informações <img src="https://cdn-icons-png.flaticon.com/128/471/471662.png" height=28>
* Professores Eduardo Sganderla & Gustavo Colombelli
* Faculdade Uniamérica Descomplica  


<br></br>

## Principais Funcionalidades  <a name="funcionalidades"></a>  <img src="https://cdn-icons-png.flaticon.com/128/2989/2989113.png" height=28>
* Registro de entrada de saída de veículos
* Cálculo do valor a ser pago
* Gerar relatório para o cliente



<br></br>
<a name="utilizar"></a>
## Como utilizar   <img src="https://cdn-icons-png.flaticon.com/128/3240/3240831.png" height=28>
* git clone https://github.com/xtokram/estacionamento.git
* Abra o projeto com o IntelliJ IDEA e aguarde ele instalar as dependências do projeto.   
* As rotas estão mapeadas na sessão "rotas" deste documento, bastando fazer a requisição utilizando o método específico de cada endpoint.  

<br></br>
 ## Rotas <img src="https://cdn-icons-png.flaticon.com/128/1674/1674969.png" height=28>
    /api/condutor  
        -> /api/condutor (POST)
        -> ?id={valor} (GET | PUT | DELETE)
        -> /lista (GET)
      
    /api/configuracao 
        -> /api/configuracao (POST)
        -> ?id={valor} (PUT | DELETE)
        -> /lista (GET)
    
    /api/marca
        -> /api/marca (POST)
        -> /lista (GET)
        -> ?id={valor} (PUT | DELETE)
        
    /api/modelo
        -> /api/modelo

<br></br>

## Validações <img src="https://cdn-icons-png.flaticon.com/128/10839/10839350.png" height=28>
* CONDUTOR  
    * GET
        * ID nulo retornará "Condutor não encontrado".  
    * POST (Criar Cadastro)
        * Nome vazio
        * CPF vazio, inválido ou já cadastrado.
        * Telefone vazio, inválido ou já cadastrado.
    * PUT (Editar Cadastro)
        * Formatação e existência de todos os dados acima.
    * DELETE (Deletar Cadastro)
        * Verifica se o condutor que deve ser deletado está ativo ou não, se não está ativo, será deletado. Se estiver ativo, será considerado inativo.  
          
* CONFIGURAÇÃO

          

<a name="tecnologias"></a>  
## Tecnologias Utilizadas  <img src="https://cdn-icons-png.flaticon.com/128/1087/1087927.png" height=28>
    Lista de tecnologias utilizadas neste projeto.   
* Java (JDK 19)
* Springboot 3.0.4
* Maven
* Lombok
* Postgres  

<br></br>

<a name="contribua"> </a>   
## Contribua  <img src="https://cdn-icons-png.flaticon.com/128/2562/2562464.png" height=28>
* 1 - Faça um fork do projeto
* 2 - Crie uma nova branch: git checkout -b minha-nova-feature
* 3 - Faça suas alterações e adicione-as ao commit: git add .
* 4 - Faça o commit das suas alterações: git commit -m 'Adicione uma nova feature'
* 5 - Faça o push para o branch: git push origin minha-nova-feature
* 6 - Envie um pull request



