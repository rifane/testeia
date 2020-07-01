# test-ia
#### Projeto criado para fins de avaliação de analista de sistema

aplicações devem consumir dados relacionados a configurações de serviços como banco de dados e mensageria, de um servidor de configuração.
A definição de componentes como Templates de mensageria, Connections factories, Data Source, Entity Manager devem ser configuradas utilizando Java Config Class ou XML (evitar configurações default em properties).

Bônus 
Desenvolver uma versão WebService SOAP para a funcionalidade do envio de e-mail. 
Documentação da API REST. 
Construir um container Docker para cada módulo. 
Utilização de Profiles para configuração de ambientes da aplicação (DEV e Production). 

Considerações finais 
O front end do módulo web é obrigatório para a análise do projeto e deverá utilizar o Angular 7+. 
O projeto deve ser publicado no GitHub e enviado o código para análise. 
Documentação para a execução do projeto deverá ser disponibilizado no README com pontos que o candidato ache importante a serem considerados.

#### Foram criados 4 serviços para atenter o objetivo:

config-server-app
api-usuario-app
aplicacao-web
consumo-email

## Configuração do Projeto
- java 8
- maven

##Configurações necessárias
Alterar o ip utilizado para o ip da máquina

## Execução pela IDE
Importar projetos pela IDE
Executar diretamente pela IDE as aplicações na seguinte ordem:
1 - config-server-app
2 - api-usuario-app
3 - aplicacao-web
4 - consumo-email

## As aplicações ficarão disponíveis em:
Aplicação web: http://localhost:8085
Api Usuário: http://localhost:8086
