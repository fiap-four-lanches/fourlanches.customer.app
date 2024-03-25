# Four Lanches App

## DOC

### 1. Tecnologias
* Java 17 
* Spring Boot
* Postgres SQL
* Docker
* [Swagger](http://localhost:8080/swagger-ui/index.html)

### 2. Pre-requisitos para rodar a aplicação
* [Java Version: 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
* [Gradle](https://gradle.org/install/)
* [IDE IntelliJ](https://www.jetbrains.com/idea/)
* [Docker](https://www.docker.com/)
* Kubernetes - K8S

### 3. Para executar localmente com Docker
#### 3.1. Para buildar, executar as migration e rodar o app no docker pela primeira vez

`docker compose up --build -d`

#### 3.2. Para executar o app com docker após a primeira vez
Após rodar a primeira o comando acima, execute o seguinte comando abaixo para que apenas execute 
os containers sem a etapa de build e migration.

`docker compose up -d app db`

#### 3.3. Necessário um arquivo .env na raiz do projeto com a seguinte conteúdo:
```
DATABASE_USERNAME=username_do_banco  
DATABASE_PASSWORD=password_do_banco
```

### 4. Testando
Basta acessar a url do swagger disponivel em `http://localhost/swagger-ui/index.htm`

#### 4.1. Nota para executar localmente pelo Docker
Subindo a aplicação via docker, a mesma se encotrará disponível no localhost:8080 para ser acessada


### 5. Links Adicionais
