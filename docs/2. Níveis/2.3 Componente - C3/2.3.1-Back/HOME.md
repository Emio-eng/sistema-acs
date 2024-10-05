# 2.3.1-Back

![diagram](https://www.plantuml.com/plantuml/svg/0/bPNDRjim3CVlVWekEQUNOHYM0KC3PnjsA5guAtOOWe6nc4IO9NgINAmRzZ0zzRHJi2VmYussazXkadxe4alyanH_efHJ7z25mcGmrRXqQ13Ybp22c4tEbcmW7xq8Ap84FiUKCfn7aML5CFZWs8RHUwi6W1uMrGo6-7gEhzx0xoZw4qNYy1sN8frSVAf5cEkE16GiE5FaO719xbgNTrpBV3L96OPVLZhGHbcDhx4aSPpH92Nl-RBHpLfxGZyAxNMA79CBUY5Vwa7PlkqXHykodNQ3t-hvyAF3cvsa6XViVQ418IlNIua4WilIibodca5nJ-kr3sJmPBT8LjLvwWM1sAMqAL-svcfGQJj_55R7zp2mhdsluawcOrLFGe6YCmo50IsTummfNTuwALeQoL5FZOra8JqbIA3mnKRPOklfHVCiL0dbx7KernAqPkMQ1QwIxBEwyWMA9Mb51o4TjdTQvg1W2x6pXMCG4_9oxtnvUqqPv7Ai2_mbvOWpv-Iml2l_oOtiWI68awkf984vMharig1a9_vfdAPiohzsmqYnqVOWdpEvyXdFAf6fFrlJzFDvlQu2Tv597VAsp9gwcyaUa4s-up1oSPNUmKeilreA8m-vqpRLEUfx9DXlU-Inukl7QkJqSXL6etVLkzGOkXTArdSFKQOjZULvl7aRw6SOpxE2O2nDsvIqbOb7hykEU-qdgtqRJ5t7wkj4eL-HwWKnQ7LUPFVoIn0vXMVxTpTTnMXE-2bXpfCpUUXFXR7yXVm7)

O diagrama de componentes em questão oferece uma representação visual dos componentes principais do sistema. Esses componentes são elementos fundamentais que desempenham papéis específicos no funcionamento do sistema como um todo.

## Back-end
### Convenções
Para promover a separação de responsabilidades, a coesão e a manutenção da arquitetura, são adotados padrões de nomenclatura para pastas, arquivos, funções e variáveis. As pastas são organizadas para representar as diferentes camadas do software e são nomeadas como "controlador", "serviço", "repositório" e "modelo". Os arquivos seguem a convenção de "nome da entidade + nome da camada", por exemplo, "RequisicaoController". Em relação às funções e variáveis, é recomendado utilizar o camelCase, pois isso melhora a legibilidade do código.

### Camadas
* **Controlador:** O Controlador atua como uma ponte entre a interface do usuário e a lógica de negócio da aplicação. Ele recebe os dados fornecidos pelo usuário, faz a validação dos parâmetros de entrada e decide qual ação precisa ser tomada com base nas informações recebidas. Essa camada também é responsável por traduzir as respostas do serviço em uma representação adequada para a interface do usuário, como um JSON ou uma página HTML.
* **Serviço:** A camada Serviço, por sua vez, contém a lógica de negócio da aplicação. Ela é responsável por processar as requisições recebidas do Controller, realizar as operações necessárias e coordenar as interações entre diferentes componentes do sistema. O serviço encapsula as regras de negócio e pode fazer chamadas a outras camadas, como a camada de acesso a dados (Repositório), para buscar ou persistir informações no banco de dados.
* **Repositório:** O Repositório é a camada responsável pelo acesso aos dados. Ele fornece métodos para recuperar, armazenar e manipular informações no banco de dados ou em outros meios de armazenamento. Essa camada abstrai os detalhes do acesso ao banco de dados, permitindo que o serviço trabalhe com objetos de domínio sem precisar conhecer os detalhes da implementação do banco de dados.
* **Modelo:** A camada Modelo representa os objetos de domínio da aplicação. Ela define as entidades e seus atributos, bem como os relacionamentos entre elas. Os objetos de domínio são usados pelo serviço e pelo Repositório para manipular as informações da aplicação de acordo com as regras de negócio.
* **Config:** Inclui várias classes de configuração, como as responsáveis pela autenticação e autorização, além das classes de configuração do Swagger.
* **Utils:** Possui os utilitários do sistema (Classes de exceção).

### Novos casos de uso
Para implementar novos casos de uso na API, siga o passo-a-passo abaixo:

* Crie o **modelo** para a entidade em questão, definindo seus atributos.
* Crie o **repositório** responsável pela camada de acesso aos dados da entidade.
* Crie o **serviço** que irá implementar a lógica de negócio relacionada à entidade.
* Crie o **controlador** responsável por receber as requisições relacionadas à entidade e retornar as respostas correspondentes.