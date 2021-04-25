# TakeBlip
Frameworks Automação TakeBlip

Download do Katalon Studio 7.7.2 - https://github.com/katalon-studio/katalon-studio/releases/download/v7.7.2/Katalon_Studio_Windows_64-7.7.2.zip

Não estou usando a versão mais recente devido não ter avaliado as mudanças nos novos realeases e qual impacto para causar no framework. 

Para automação Funcional foi utilizado o Katalon Studio com Java/Groovy.
Os cenários estão criados em Gherkin utilizando os Steps Definition do Cucumber no modelo de reutiliação das métodos voltado a programação orientado a objeto.
O reuso de toda a construção da automação é 100%.

Criados os casos de testes utilizando o comando cucumber runner featureFileTags para executar via tag de cada cenários.
Suite de teste implementada para geração da evidências, vídeo e prints customizado no framework e report HTML onde todo o time de uma Squad consegue fazer a leitura deixando os termos técnicos e partindo para o comportamental/negócio.


Teste de Stress - Usado Jmeter para criar o projeto 
O cenário executado foi avaliar o comportamento do login utilizando 100 usuários virtuais com 20 interações a cada 1 segundo. Utilizei o request de login com dados válidos mapeados diretamente na aplicação.
Resultado com sucesso onde aplicação não teve comportamento de bloqueio e recusa das requisições.
