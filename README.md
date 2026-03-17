# Malha Aérea

> Esta é apenas uma descrição curta e direta (*tentando*) sobre o projeto.

O projeto utiliza os dados dos SIROS (Sistema de Registro de Operações) para criar um grafo, mapeando os aeroportos como vértices e os voos como arestas.

O projeto utiliza o algoritmo de Kruskal, para visualizar o todo e criar uma malha aérea essencial, com as conexões com o menor número de horas possível e sem ciclos, um caminho direto e único.

## Sobre a Base de Dados

O programa lê um arquivo CSV que contém informações sobre os SIROS, ferramenta da Agência Nacional de Aviação Civil (ANAC) no Brasil.

O SIROS é utilizado para o registro dos serviços de transporte aéreo, incluindo a consulta de voos programados, tanto regulares quanto não regulares.

## Resultado

O programa depois de gerar a malha aérea essencial, transforma o grafo (código Java) em um arquivo `.gv` para renderização em plataforma web [Graphviz](https://dreampuf.github.io/GraphvizOnline/).

> Utilizei a engine `dot` para visualizar e instalar a imagem (svg), mas indico alterar para a engine `fdp` para uma visualização mais amigável *"grafomente"* falando.

## Links

* Link do site com o arquivo: [Horus](https://horus.labtrans.ufsc.br/gerencial/#Siros/Mapa)
* Link do site de Consultas de Voos Programados: [SIROS](https://siros.anac.gov.br/SIROS/view/registro/frmConsultaVoos)
