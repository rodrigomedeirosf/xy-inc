# xy-poi

Projeto criado para o processo seletivo da Zup. Seguem abaixo as funcionalidades

  - Cadastrar Poi
  - Listar Poi's cadastrados
  - Buscar Poi's próximos a uma coordenada

### Versão
1.0-SNAPSHOT

### Instalação

##### Pré-requisitos
  - Java 1.6
  - Maven
  - Mysql

##### Configuração
O arquivo de configuração do banco de dados está localizado no módulo xy-poi-repository no arquivo abaixo, e deve ser ajustado para as configurações do banco Mysql instalado:
  -  src/main/resources/jdbc.properties

Por padrão a aplicação cria automaticamente as tabelas no banco de dados, mas caso o usuário não tenha permissão, as mesmas devem ser criadas manualmente com o script abaixo, localizado no módulo xy-poi-repository:
  -  src/test/resources/sql/db-schema-mysql.sql

A aplicação foi configurada para executar na porta 8080. Segue abaixo exemplo de chamada a aplicação:
  -  http://localhost:8080/poi-web/poi/list

##### Geração do pacote
Para compilar o projeto, acessar a pasta xy-poi e executar o comando abaixo
```sh
$ mvn clean install
```
O arquivo para deploy, será gerado na pasta xy-poi-web/target/poi-web.war

##### Deploy
Para executar a aplicação, acessar a pasta do módulo xy-poi-web e executar o comando abaixo
```sh
$ mvn jetty:run
```

### Teste
Os serviços foram disponibilizados no formato REST, e podem ser acessados de qualquer cliente HTTP.<br/>
Seguem abaixo os serviços disponíveis, e os detalhes dos mesmo:
  -  Listar Poi's cadastrados
      - Url: /poi-web/poi/list
      - Método: GET
      - Parâmetros
        -  N/A
  - Cadastrar novo Poi
      - Url: /poi-web/poi/save
      - Método: POST
      - Parâmetros
         - name
             - Tipo: String
             - Descrição: Nome do Poi
             - Obrigatório: Sim
         - coordinateX
             - Tipo: Inteiro positivo
             - Descrição: Coordenada X do Poi
             - Obrigatório: Sim
         - coordinateY
             - Tipo: Inteiro positivo
             - Descrição: Coordenada Y do Poi
             - Obrigatório: Sim
  -  Buscar Poi's por proximidade
      - Url: /poi-web/poi/search/x-axis/{coordinateX}/y-axis/{coordinateY}/distance/{distance}
      - Método: GET
      - Parâmetros
         - coordinateX
             - Tipo: Inteiro positivo
             - Descrição: Coordenada X
             - Obrigatório: Sim
         - coordinateY
             - Tipo: Inteiro positivo
             - Descrição: Coordenada Y
             - Obrigatório: Sim
         - distance
             - Tipo: Inteiro positivo
             - Descrição: Distância máxima entre a coordenada e o Poi
             - Obrigatório: Sim