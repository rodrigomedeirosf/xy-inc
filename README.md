# xy-poi

Projeto criado para o processo seletivo da Zup. Seguem abaixo as funcionalidades

  - Cadastrar Poi
  - Listar Poi's cadastrados
  - Buscar Poi's pr�ximos a uma coordenada

### Vers�o
1.0-SNAPSHOT

### Instala��o

##### Pr�-requisitos
  - Java 1.6
  - Maven
  - Mysql

##### Configura��o
O arquivo de configura��o do banco de dados est� localizado no m�dulo xy-poi-repository no arquivo abaixo, e deve ser ajustado para as configura��es do banco Mysql instalado:
  -  src/main/resources/jdbc.properties

Por padr�o a aplica��o cria automaticamente as tabelas no banco de dados, mas caso o usu�rio n�o tenha permiss�o, as mesmas devem ser criadas manualmente com o script abaixo, localizado no m�dulo xy-poi-repository:
  -  src/test/resources/sql/db-schema-mysql.sql

A aplica��o foi configurada para executar na porta 8080. Segue abaixo exemplo de chamada a aplica��o:
  -  http://localhost:8080/poi-web/poi/list

##### Gera��o do pacote
Para compilar o projeto, acessar a pasta xy-poi e executar o comando abaixo
```sh
$ mvn clean install
```
O arquivo para deploy, ser� gerado na pasta xy-poi-web/target/poi-web.war

##### Deploy
Para executar a aplica��o, acessar a pasta do m�dulo xy-poi-web e executar o comando abaixo
```sh
$ mvn jetty:run
```

### Teste
Os servi�os foram disponibilizados no formato REST, e podem ser acessados de qualquer cliente HTTP.<br/>
Seguem abaixo os servi�os dispon�veis, e os detalhes dos mesmo:
  -  Listar Poi's cadastrados
      - Url: /poi-web/poi/list
      - M�todo: GET
      - Par�metros
        -  N/A
  - Cadastrar novo Poi
      - Url: /poi-web/poi/save
      - M�todo: POST
      - Par�metros
         - name
             - Tipo: String
             - Descri��o: Nome do Poi
             - Obrigat�rio: Sim
         - coordinateX
             - Tipo: Inteiro positivo
             - Descri��o: Coordenada X do Poi
             - Obrigat�rio: Sim
         - coordinateY
             - Tipo: Inteiro positivo
             - Descri��o: Coordenada Y do Poi
             - Obrigat�rio: Sim
  -  Buscar Poi's por proximidade
      - Url: /poi-web/poi/search/x-axis/{coordinateX}/y-axis/{coordinateY}/distance/{distance}
      - M�todo: GET
      - Par�metros
         - coordinateX
             - Tipo: Inteiro positivo
             - Descri��o: Coordenada X
             - Obrigat�rio: Sim
         - coordinateY
             - Tipo: Inteiro positivo
             - Descri��o: Coordenada Y
             - Obrigat�rio: Sim
         - distance
             - Tipo: Inteiro positivo
             - Descri��o: Dist�ncia m�xima entre a coordenada e o Poi
             - Obrigat�rio: Sim