# 2.3 Componente - C3

O objetivo principal dos diagramas de componentes no C4 Model é mostrar a estrutura interna dos contêineres do sistema e como eles são compostos por diferentes componentes. Os diagramas de componentes fornecem uma visão detalhada dos principais blocos de construção estruturais do sistema e suas interações. Esses diagramas ajudam a entender a arquitetura de um sistema de software em um nível mais granular, identificando os componentes individuais e suas responsabilidades. Eles mostram como os componentes se relacionam entre si, quais são as dependências e como eles colaboram para fornecer as funcionalidades do sistema.

* **Escopo:** Um único contêiner.
* **Elementos primários:** Componentes dentro do contêiner no escopo.
* **Público alvo:** Arquitetos e desenvolvedores de software.
****
## Convenções Back-end

Antes de nos aprofundarmos no C3, é importante ressaltar que são utilizadas algumas convenções que apoiam a arquitetura proposta. Essas convenções são as seguintes
*  Convenção de nomenclaturas de arquivos e diretórios ([Oracle](https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html))
*  Convenção de fluxo de trabalho Git - com adapatações e aderência parcial ([Gitflow](https://danielkummer.github.io/git-flow-cheatsheet/))
*  Convenção de commits ([Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/))

## Convenções Front-end
⚒️🏗️

## Restrições e metas arquiteturais
* As tecnologias de desenvolvimento utilizadas são: 
  * Front-end: TypeScript associado aos frameworks React + NextJs.
  * Back-end: Java associado ao framework Spring boot.
* O projeto não possui nenhuma espécie de orçamento, tornando a aquisição de serviços de terceiros um custo pessoal, portanto os serviços utilizados devem ser gratuitos e o servidor pessoal ou da instituição;.
* A aplicação será disponibilizada como página web.
* O sistema deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas.
* O serviço de API deve ser criado com um banco de dados completo, com gerenciamento de concorrência e maior capacidade de armazenamento, dado que o sistema será desenvolvido com foco em manter múltiplos usuários acessando concorrentemente.

