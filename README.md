# Challenge
> CRUD de transportadoras.

Esse é o resultado do desafio proposto pela HiveCloud/Praxio. A aplicação é responsável por armazenar informações básicas sobre uma determinada transportadora.
Nela podemos listar todas as transportadoras salvas e filtrá-las, adicionar novas transportadoras, editar e excluir as informações da transportadora.
O projeto foi divido em dois sub-projetos, front-end e back-end, onde este é o back-end. Para consumo correto da aplicação, favor possuir os dois sub-projetos na máquina.
Inicializar primeiro o back-end e posteriormente o front-end.

## Instalação

O projeto foi gerado utilizando o Spring Initializr e utiliza:
* Gradle
* Spring Boot
* Java 8
* JPA + Hibernate
* Database H2

Aṕos clonar o projeto é necessário mudar a branch alvo para a develop:
```sh
git checkout develop
``` 

Caso queira queira acessar os testes, é preciso mudar a branch alvo para feature/testes-jUnit

OBS: Os testes foram implementados após a entrega. Favor desconsiderar durante avaliação. 
```sh
git checkout feature/testes-jUni
``` 

Importar o projeto utilizando IDE's compatíveis com o Gradle.
Automaticamente o Gradle baixará as depências do projeto e ele estará pronto para inicializar, basta executar a classe main ChallengeApplication.

Para rodar os testes basta executar o pacote ```br.com.project.challenge``` no diretório ```test/java``` 

## Meta

Bruno Barbosa Leite Pimentel – bruno.bblp@gmail.com
