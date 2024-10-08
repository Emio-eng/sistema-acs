# 2.1 Contexto - C1

`/2. Níveis/2.1 Contexto - C1`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [1.1 Requisitos do Sistema](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [**2.1 Contexto - C1**](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

![diagram](https://www.plantuml.com/plantuml/svg/0/ZLPDRzms4BthLqpjQzP80nHf7A38OcFaqY86t8zZC4kDTeb8f4fIZlrpZ1w2_81UUjKVwoFrHQrj83RWrP9lXc_clQ7ypWTseMjgUg_vuBXXKZ_IXfGrGUw2BNu8Hsc4VCjAQjuN_hCsBGD8h89rD-6-5k8lucqZHP7Mw0_VzGzEMpgljP6BalrHohSnt-M-xcH4RUlE07AwlBEDzhx_vyajwqenNEBvqUQsRBJHFhYdjw-yiZKxNN8fT5wzB7z-ypAZL1WRX89joLOJim-Exml2pqVYj2BcLZCnEVcxqrxtNoDBPHkoFk6KkA0hhS304xfowDYLJ5s3270mzc9CrqqDQYtOC5AqR8xiKkuD9LHsH0l-ZG1UMlBIKSjeQtrHY2afyXxPEtquXiX_rQUi2fMjEr6obzDY4X2dZFMYOiLewv4fQWuqt_8cWMhDGmWAL9Da5sXT_wsX4b_jYo7RV112dmmYIJWmuQ5xZmhRsn1YbwlS77DTsvJtj9AiYFxRnCItrlZ-uLRgr5EOl1AdNTGgE3qKjk-m0FsGrI8281VLymIbZjRn83M-G6RE9QT1IbScJoIKxpYTAYheMr34ty60-DLtzda5Jyoyr0gQ84Yjk4fxr3mvoUUv1l_I9gNR_78oZvSOy_ktnTBAJTS2D9f-XLZi4Z40PVtFW6ksCpGpOGOkO8Z0ve1humOnql2dhK8fdix6xxJT-JCwvzTx_kdDUZBpYAKhr-8Q3H14clj1SYU3eAeBSR8yLPrHsXgu9MemwxXeDWnNRErgkFWW9j2krlYGJpU__NwTs8uB51VEfYjbnNOLij2zmZMIt89AT8tIExYxVmXQWVRer9eJrNYHuAp5sV_2aSZfP036xP1iAjE4IdRHFQxYuxOBnrUhRiSMT06RS76QdPDYbkaRWvTAiXI_seCrrFzdK0M6BsqVh8qofx2LFnELFpNlf4rKy4Zn-Q-RPyyUqTbrjW_YI9lAkeR7pfJZ3OQZn4d_TNrrxgwkSnRpLCnpidBNOjdvBK6Ny1SNEMoENMlzTF3m_f1DbBrOlP0sjLJVcsMyK8SqViscj5yCqan2VMSDOzJKukUZtg5x-5_XVm00)

O principal objetivo do diagrama de contexto, de acordo com o modelo C4, é fornecer uma visão geral e simplificada da arquitetura do sistema, destacando seu relacionamento com o ambiente externo. O diagrama de contexto mostra o sistema em foco como uma única caixa central, cercada por elementos externos, como usuários, sistemas externos e outras entidades com as quais o sistema interage.Esse diagrama é útil para comunicar de forma clara e concisa a função e o propósito do sistema, bem como sua interação com o ambiente ao seu redor. Ele fornece uma representação de alto nível da arquitetura, permitindo que os stakeholders identifiquem facilmente as partes interessadas envolvidas e entendam a amplitude do sistema.

Além disso, o diagrama de contexto é uma base sólida para a elaboração de outros diagramas mais detalhados, pois fornece um ponto de partida para a decomposição do sistema em componentes menores. Ele ajuda a definir os limites e a identificar as interfaces do sistema, sendo uma ferramenta essencial para a compreensão inicial da arquitetura em um nível mais amplo.

* **Escopo:** Um único sistema de software.
* **Elementos primários:**  O sistema de software no escopo.
* **Elementos de suporte:** Pessoas (por exemplo, usuários, atores, funções ou personas) e sistemas de software (dependências externas) que estão diretamente conectados ao sistema de software no escopo.
* **Público alvo:** Todos, técnicos e não técnicos, dentro e fora da equipe de desenvolvimento de software.

## Principais elementos
### Personas
Cada usuário possui obrigatoriamente um perfil, que define os níveis de autorização no sistema.
* **Aluno:** Esse usuário representa aqueles que possuem acesso ao sistema para enviar requisições juntamente com suas atividades complementares. É importante ressaltar que apenas os membros da Universidade de Pernambuco possuem permissão para acessar o sistema.
* **Comissão:** Esse usuário desempenha um papel fundamental na avaliação das requisições de atividades complementares. Sua responsabilidade principal é verificar cuidadosamente os dados da requisição e os certificados apresentados. Além disso, é sua responsabilidade atribuir a quantidade de horas correspondente às atividades e definir o status da requisição como deferido ou indeferido, com base nas informações fornecidas e nos critérios estabelecidos.
* **Coordenação:** O responsável pelo gerenciamento das requisições possui o perfil de coordenador. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo autoridade para indeferir uma requisição sem envolvê-la com a comissão responsável. Somente um usuário com esse perfil possui a autoridade para concluir o fluxo da requisição. O coordenador desempenha um papel crucial na triagem inicial, garantindo que apenas as requisições válidas e adequadas prossigam para o próximo estágio do processo.
* **Administrador:** Esse usuário é responsável por atribuir os perfis de comissão e coordenação. Para realizar essa atribuição, é necessário enviar um e-mail para a conta de administração, solicitando o cadastro de usuários com esses perfis específicos. Esse processo garante que apenas usuários autorizados possuam os privilégios necessários para desempenhar as funções de comissão e coordenação, mantendo assim a segurança e a organização do sistema.
#### Personas Externas
* **Escolaridade:** Esse ator não possui interação direta com o sistema, porém desempenha um papel crucial ao receber e-mails durante o processo de cadastro das requisições. Ele é notificado quando um aluno realiza o cadastro de uma requisição e também quando a requisição é concluída. Sua responsabilidade é inserir as informações das atividades complementares no Siga, garantindo que os registros sejam atualizados adequadamente. Embora não esteja diretamente envolvido no sistema, esse ator desempenha uma função indispensável para o fluxo de trabalho eficiente e preciso.

### Sistema principal
* **Sistema ACs-UPE:** Essa plataforma web é um sistema que oferece aos alunos a capacidade de cadastrar requisições, ao mesmo tempo em que permite o gerenciamento dessas requisições pela coordenação e comissão. É um ambiente centralizado que facilita o processo de solicitações de atividades complementares, promovendo uma comunicação eficiente entre os alunos e as equipes responsáveis pela avaliação e aprovação das requisições. A plataforma oferece recursos que permitem aos alunos inserir os dados necessários para as requisições, enquanto a coordenação e a comissão podem acessar e administrar essas requisições de forma organizada, efetiva e segura.

### Sistema externos
* **Sistema de e-mail:** Responsável pelo envio de e-mails automáticos relacionados às requisições para a escolaridade, envio de e-mails de notificação entre os atores do sistema, bem como e-mails relacionados às etapas de configuração de contas de usuário. Esse componente desempenha um papel crucial na comunicação efetiva do sistema, garantindo que as partes relevantes sejam informadas sobre o status das requisições, atualizações e outras informações importantes. Os e-mails automáticos são disparados de acordo com eventos específicos, agilizando o fluxo de trabalho e mantendo os usuários informados em tempo hábil.
* **Sistema de autenticação:** O recurso de login com credenciais do Google oferece aos usuários a conveniência de utilizar suas contas do Google para acessar diversos serviços e aplicativos. Isso elimina a necessidade de criar novas credenciais e permite um processo de login simplificado e seguro. Ao aproveitar as credenciais existentes do Google, os usuários podem acessar rapidamente os serviços desejados, reduzindo o atrito no processo de autenticação e melhorando a experiência do usuário. Além disso, o login com credenciais do Google também proporciona um nível adicional de confiança e segurança, uma vez que a autenticação é realizada pela infraestrutura robusta e confiável do Google.
* **API do Via CEP:** O recurso permite obter automaticamente os dados de endereço do usuário apenas informando o CEP. Com essa funcionalidade, é possível simplificar e agilizar o processo de preenchimento de informações de endereço, eliminando a necessidade de digitar manualmente cada campo. Ao inserir o CEP, o sistema realiza uma busca em uma base de dados atualizada e recupera automaticamente as informações de rua, número, bairro, cidade e estado associados ao CEP fornecido. Isso proporciona uma experiência mais conveniente para o usuário, reduzindo erros de digitação e economizando tempo ao preencher formulários ou realizar transações online que requerem informações de endereço.