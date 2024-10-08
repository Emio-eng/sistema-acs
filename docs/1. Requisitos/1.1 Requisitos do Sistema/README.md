# 1.1 Requisitos do Sistema

`/1. Requisitos/1.1 Requisitos do Sistema`

* [Sistema ACS | Docs](../../README.md)
  * [1. Requisitos](../../1.%20Requisitos/README.md)
    * [**1.1 Requisitos do Sistema**](../../1.%20Requisitos/1.1%20Requisitos%20do%20Sistema/README.md)
    * [1.2 Casos de uso](../../1.%20Requisitos/1.2%20Casos%20de%20uso/README.md)
      * [1.2.1 Usuário geral](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.1%20Usu%C3%A1rio%20geral/README.md)
      * [1.2.2 Aluno](../../1.%20Requisitos/1.2%20Casos%20de%20uso/1.2.2%20Aluno/README.md)
    * [1.3 Requisitos Arquiteturais](../../1.%20Requisitos/1.3%20Requisitos%20Arquiteturais/README.md)
  * [2. Níveis](../../2.%20N%C3%ADveis/README.md)
    * [2.1 Contexto - C1](../../2.%20N%C3%ADveis/2.1%20Contexto%20-%20C1/README.md)
    * [2.2 Container - C2](../../2.%20N%C3%ADveis/2.2%20Container%20-%20C2/README.md)
    * [2.3 Componente - C3](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/README.md)
      * [2.3.1-Back](../../2.%20N%C3%ADveis/2.3%20Componente%20-%20C3/2.3.1-Back/README.md)
    * [2.4 Código - C4](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/README.md)
      * [2.4.1-Atividades](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.1-Atividades/README.md)
      * [2.4.2-Classes](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.2-Classes/README.md)
      * [2.4.3-Sequência](../../2.%20N%C3%ADveis/2.4%20C%C3%B3digo%20-%20C4/2.4.3-Sequ%C3%AAncia/README.md)
  * [3. Manutenção da arquitetura](../../3.%20Manuten%C3%A7%C3%A3o%20da%20arquitetura/README.md)

---

## Requisitos funcionais

Os requisitos funcionais desempenham um papel fundamental no desenvolvimento de um sistema ou software, pois eles definem as funcionalidades e comportamentos esperados do sistema. Eles descrevem o que o sistema deve ser capaz de fazer, quais tarefas deve executar e como deve responder a determinados inputs do usuário ou do ambiente.

O papel dos requisitos funcionais é estabelecer uma base clara para o projeto, implementação e teste do sistema. Eles servem como um contrato entre os stakeholders (partes interessadas) e os desenvolvedores, garantindo que todas as partes envolvidas tenham uma compreensão comum das funcionalidades esperadas.

## Prioridade dos requisitos

No processo de priorização dos requisitos, adotamos uma técnica baseada no uso de tags classificadoras, sendo elas: Alta, Média e Baixa.

A prioridade alta é atribuída aos requisitos indispensáveis para o sistema. Esses requisitos são essenciais e sua ausência resultaria na interrupção do funcionamento adequado do sistema, impedindo o cumprimento de seus objetivos. Portanto, é imperativo que esses requisitos sejam implementados obrigatoriamente e de forma impreterível.

A prioridade média é atribuída aos requisitos que são extremamente relevantes para o sistema. A ausência desses requisitos não impede que o sistema seja executado, porém, pode resultar no cumprimento parcial de seus objetivos ou procedimentos, geralmente de maneira insatisfatória. Esses requisitos devem ser implementados, mas caso não sejam, o sistema pode ser implantado em sua forma atual.

A prioridade baixa é atribuída aos requisitos que não comprometem as funcionalidades básicas do sistema, permitindo sua execução de forma satisfatória. Esses requisitos podem ser deixados para versões futuras do software, sendo introduzidos como recursos adicionais em um pacote de atualização.

Ao utilizar essa técnica de classificação, é possível estabelecer uma hierarquia de importância para os requisitos, permitindo uma melhor alocação de recursos e garantindo que os aspectos essenciais do sistema sejam tratados prioritariamente. Isso ajuda a orientar o desenvolvimento de acordo com as necessidades críticas do projeto, enquanto permite o planejamento de implementações futuras para requisitos de menor prioridade

| RF 001 - Realizar cadastro via sistema                                                                                                                            |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:**   Um usuário deve ser capaz de realizar cadastro no sistema, vale ressaltar que para todo cadastro feito é atribuído ao usuário o perfil de aluno. |
| **Atores:**   Nenhum.                                                                                                                                             |
| **Prioridade:**   Média.                                                                                                                                          |
| **Entrada:**  Inserir nome completo, período, telefone, email, senha, cep, rua, bairro, cidade, UF, número.                                                       |
| **Pré-condições:** Cadastar-se com email institucional, senha com 8 ou mais caracteres incluindo caracteres especiais, letras maiúsculas e minúsculas.            |
| **Saída:** Confirmação de cadastro.                                                                                                                               |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para certificar que é membro da instituição, passando por um processo de verificação.         |

| RF 002 - Realizar login via sistema                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Um usuário deve ser capaz de realizar login via sistema.                                                                  |
| **Atores:** Usuário geral.                                                                                                               |
| **Prioridade:** Média.                                                                                                                   |
| **Entrada:** Inserir e-mail e senha.                                                                                                     |
| **Pré-condições:** O usuário deve estar cadastrado.                                                                                      |
| **Saída:** Confirmação de login.                                                                                                         |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema, caso informe as credenciais corretamente (e-mail e senha). |

| RF 003 - Realizar login via Google                                                                                                     |
| -------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de fazer login no aplicativo utilizando o serviço de SSO (Single Sign-On) do Google, o OAuth2. |
| **Atores:** Nenhum.                                                                                                                    |
| **Prioridade:** Baixa.                                                                                                                 |
| **Entrada:** Selecionar a conta do Google.                                                                                             |
| **Pré-condições:** Possuir uma conta Google.                                                                                           |
| **Saída:** Confirmação de login.                                                                                                       |
| **Pós-condições:** O usuário será direcionado para a tela de perfil para completar os dados de cadastro.                               |

| RF 004 - Sair do sistema                                                       |
| ------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de sair do sistema.                    |
| **Atores:** Usuário geral.                                                     |
| **Prioridade:** Baixa.                                                         |
| **Entrada:** Selecionar o botão de logoff presente na tela inicial do sistema. |
| **Pré-condições:** O usuário deve estar logado.                                |
| **Saída:** Confirmação de logoff.                                              |
| **Pós-condições:** O usuário será direcionado para a tela de login.            |

| RF 005 - Verificar usuário institucional                                                                                                                   |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve realizar o processo de verificação, o qual receberá um token via e-mail para confirmar se é uma conta institucional própria. |
| **Atores:** Usuário geral.                                                                                                                                 |
| **Prioridade:** Alta.                                                                                                                                      |
| **Entrada:** Inserir token recebido por e-mail.                                                                                                            |
| **Pré-condições:** O usuário não pode ser verificado e deve estar logado.                                                                                  |
| **Saída:** Saídas: Confirmação da verificação institucional do usuário.                                                                                    |
| **Pós-condições:** O usuário será direcionado para a tela inicial do sistema.                                                                              |

| RF 006 - Alterar senha                                                                            |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de alterar sua própria senha.                             |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Inserir a senha antiga para ser possível realizar a alteração da nova senha.         |
| **Pré-condições:** O usuário deve estar logado.                                                   |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 007 - Recuperar senha                                                                          |
| ------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de recuperar sua senha.                                   |
| **Atores:** Usuário geral.                                                                        |
| **Prioridade:** Baixa.                                                                            |
| **Entrada:** Recuperar senha.                                                                     |
| **Pré-condições:** Recebe o link de recuperação de senha por e-mail.                              |
| **Saída:** Confirmação da alteração da senha.                                                     |
| **Pós-condições:** O usuário recebe uma mensagem informando que a senha foi alterada com sucesso. |

| RF 008 - Consultar dados do próprio usuário                                                                                                                                                                  |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O usuário deve ser capaz de visualizar todos os seus dados. Sendo possível visualizar o nome completo, cpf, período, telefone, e-mail, senha oculta, status de verificação, curso e endereço. |
| **Atores:** Usuário geral.                                                                                                                                                                                   |
| **Prioridade:** Baixa.                                                                                                                                                                                       |
| **Entrada:** Não possui entradas.                                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                              |
| **Saída:** Não possui saídas.                                                                                                                                                                                |
| **Pós-condições:** O usuário é direcionado para a página de perfil.                                                                                                                                          |

| RF 009 - Editar dados do próprio usuário                                                                |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de editar seus dados exceto e-mail, matrícula e CPF.            |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Baixa.                                                                                  |
| **Entrada:** Inserir dados a serem alterados.                                                           |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da alteração dos dados.                                                          |
| **Pós-condições:** O usuário recebe uma mensagem informando que seus dados foram alterados com sucesso. |

| RF 010 - Apagar dados do usuário                                                                        |
| ------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de solicitar que todos os seus dados sejam apagados do sistema. |
| **Atores:** Usuário geral.                                                                              |
| **Prioridade:** Média.                                                                                  |
| **Entrada:** Inserir senha do usuário para confirmação da exclusão.                                     |
| **Pré-condições:** O usuário deve estar logado.                                                         |
| **Saída:** Confirmação da exclusão dos dados.                                                           |
| **Pós-condições:** O usuário é redirecionado para a tela de login do sistema.                           |

### Perfil Aluno

O aluno possui acesso ao sistema para enviar requisições juntamente com suas atividades complementares. Além de obter informações sobre o progresso da validação da sua requisição, permitindo que você acompanhe em qual etapa do processo ela se encontra.

| RF 011 - Cadastrar requisição                                                                                                                                                                     |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de cadastrar uma requisição com o intuito de ratificar uma determinada quantidade de horas das suas atividades complementares.                            |
| **Atores:** Aluno.                                                                                                                                                                                |
| **Prioridade:** Alta.                                                                                                                                                                             |
| **Entrada:** Inserir informações da requisição, como semestre e quantidade de certificados. Para cada certificado, fornecer título, descrição, data, horas, atividade e o arquivo no formato PDF. |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                   |
| **Saída:** Confirmação do envio da requisição.                                                                                                                                                    |
| **Pós-condições:** O usuário é redirecionado para a tela específica da requisição enviada, e a coordenação recebe a notificação por e-mail.                                                       |

| RF 012 - Consultar lista de requisições                                                                               |
| --------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar sua lista de requisições.                                       |
| **Atores:** Aluno.                                                                                                    |
| **Prioridade:** Alta.                                                                                                 |
| **Entrada:** Não possui entradas.                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                       |
| **Saída:** Não possui saídas.                                                                                         |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela da requisição selecionada. |

| RF 013 - Buscar requisição específica                                               |
| ----------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de visualizar uma requisição específica.    |
| **Atores:** Aluno.                                                                  |
| **Prioridade:** Média.                                                              |
| **Entrada:** Não possui entradas.                                                   |
| **Pré-condições:** O usuário deve estar logado.                                     |
| **Saída:** Não possui saídas.                                                       |
| **Pós-condições:** O usuário é redirecionado para a tela da requisição selecionada. |

| RF 014 - Receber alerta após mudança de status de uma requisição                                               |
| -------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve receber um alerta via e-mail após haver uma mudança no status da requisição.     |
| **Atores:** Aluno.                                                                                             |
| **Prioridade:** Alta.                                                                                          |
| **Entrada:** Não possui entradas.                                                                              |
| **Pré-condições:** Quando o status de uma requisição associada a um determinado aluno for alterada.            |
| **Saída:** Não possui saídas.                                                                                  |
| **Pós-condições:** O usuário recebe um e-mail com as informações daquela requisição e o seu respectivo status. |

| RF 015 - Baixar arquivo PDF referente à requisição                                                       |
| -------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ter a opção de fazer o download da requisição em formato PDF.              |
| **Atores:** Aluno.                                                                                       |
| **Prioridade:** Baixa.                                                                                   |
| **Entrada:** Não possui entradas.                                                                        |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF. |
| **Saída:** Confirmação do download do arquivo.                                                           |
| **Pós-condições:** O usuário vê o arquivo baixado na pasta selecionada.                                  |

| RF 016 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Aluno.                                            |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.                             |

### Perfil Coordenador

O coordenador é responsável pelo gerenciamento das requisições. Ele é o primeiro a receber as requisições e realiza validações iniciais, tendo autoridade para indeferir uma requisição sem envolvê-la com a comissão responsável. Somente um usuário com esse perfil possui a autoridade para concluir o fluxo da requisição.

| RF 017 - Solicitar permissões de coordenação                                                                                                                                      |
| --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário pode solicitar ao administrador o perfil de coordenação, é necessário validar se o usuário é docente e faz parte da coordenação de um determinado curso. |
| **Atores:** Usuário geral.                                                                                                                                                        |
| **Prioridade:** Média.                                                                                                                                                            |
| **Entrada:** O usuário deve enviar alguma documentação que confirme a veracidade da sua posição.                                                                                  |
| **Pré-condições:** O usuário deve estar logado no sistema.                                                                                                                        |
| **Saída:** Confirmação da solicitação de autorização.                                                                                                                             |
| **Pós-condições:** O usuário deve receber por e-mail um retorno sobre a sua solicitação.                                                                                          |

| RF 018 - Consultar lista de requisições                                                                                                                                                                                                                                          |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de visualizar a lista de requisições encaminhadas para a coordenação e comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre, status da requisição e aluno. |
| **Atores:** Coordenador.                                                                                                                                                                                                                                                         |
| **Prioridade:** Média.                                                                                                                                                                                                                                                           |
| **Entrada:** Nenhuma.                                                                                                                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                                                                                                  |
| **Saída:** Não possui saídas.                                                                                                                                                                                                                                                    |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para tela de requisição selecionada.                                                                                                                                                              |

| RF 019 - Encaminhar requisição para a comissão                                                                                                             |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de encaminhar a requisição para a comissão do seu curso.                                                       |
| **Atores:** Coordenador.                                                                                                                                   |
| **Prioridade:** Alta.                                                                                                                                      |
| **Entrada:** Não possui entradas.                                                                                                                          |
| **Pré-condições:** O usuário deve estar logado.                                                                                                            |
| **Saída:** Confirmação de encaminhamento de requisição.                                                                                                    |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi encaminhada com sucesso e a comissão recebe por e-mail a notificação. |

| RF 020 - Assinar documento requisição                                                                                                                                          |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** Antes de deferir ou indeferir uma requisição, o coordenador deve ser capaz de baixar o documento da requisição em sua máquina e submetê-lo assinado ao sistema. |
| **Atores:** Coordenador.                                                                                                                                                       |
| **Prioridade:** Alta.                                                                                                                                                          |
| **Entrada:** O usuário deve submeter o documento assinado.                                                                                                                     |
| **Pré-condições:** O usuário deve estar logado e selecionar a opção de fazer download do arquivo em PDF, assiná-lo e realizar a submissão.                                     |
| **Saída:** Confirmação de submissão do documento assinado.                                                                                                                     |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi assinada com sucesso.                                                                     |

| RF 021 - Ratificar requisição                                                                                                      |
| ---------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a.                      |
| **Atores:** Coordenador                                                                                                            |
| **Prioridade:** Alta                                                                                                               |
| **Entrada:** Nenhuma                                                                                                               |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ter passado pela comissão.              |
| **Saída:** Confirmação da ratificação da requisição                                                                                |
| **Pós-condições:** O coordenador recebe uma mensagem informando que a requisição foi ratificada e encaminhada para a escolaridade. |

| RF 022 - Atribuir perfil para a comissão                                                       |
| ---------------------------------------------------------------------------------------------- |
| **Descrição:** O coordenador pode atribuir perfis de comissão para os usuários da sua escolha. |
| **Atores:** Coordenador.                                                                       |
| **Prioridade:** Média.                                                                         |
| **Entrada:** Informar o usuário que deseja adicionar as permissões de comissão.                |
| **Pré-condições:** O usuário deve estar logado no sistema.                                     |
| **Saída:** Confirmação da atribuição do perfil.                                                |
| **Pós-condições:** O usuário que recebeu as permissões deve receber por e-mail a notificação.  |

| RF 016 - Visualizar indicadores sobre as requisições enviadas |
| ------------------------------------------------------------- |
| **Descrição:** Em construção.                                 |
| **Atores:** Coordenador.                                      |
| **Prioridade:** Média.                                        |
| **Entrada:** Em construção.                                   |
| **Pré-condições:** Em construção.                             |
| **Saída:** Em construção.                                     |
| **Pós-condições:** Em construção.                             |

### Perfil Comissão

A comissão desempenha um papel fundamental na avaliação das requisições de atividades complementares. Sua responsabilidade principal é verificar cuidadosamente os dados da requisição e os certificados apresentados. Além disso, é sua responsabilidade atribuir a quantidade de horas correspondente às atividades e definir o status da requisição como deferido ou indeferido, com base nas informações fornecidas e nos critérios estabelecidos.

| RF 024 - Consultar lista de requisições                                                                                                                                                                                                   |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de visualizar a lista de requisições encaminhadas para a comissão do seu respectivo curso. Também deve ser possível filtrar as requisições por campos de interesse, como data, semestre e aluno. |
| **Atores:** Comissão.                                                                                                                                                                                                                     |
| **Prioridade:** Média.                                                                                                                                                                                                                    |
| **Entrada:** Nenhuma.                                                                                                                                                                                                                     |
| **Pré-condições:** O usuário deve estar logado.                                                                                                                                                                                           |
| **Saída:** Não possui saídas.                                                                                                                                                                                                             |
| **Pós-condições:** Caso selecione alguma requisição, o usuário é redirecionado para a tela de requisição selecionada.                                                                                                                     |

| RF 025 - Adicionar quantidade de horas nas atividades complementares                                            |
| --------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de adicionar a quantidade de horas por certificados de uma requisição. |
| **Atores:** Comissão                                                                                            |
| **Prioridade:** Alta                                                                                            |
| **Entrada:** Inserir quantidade de horas para o certificado                                                     |
| **Pré-condições:** O usuário deve estar logado                                                                  |
| **Saída:** Confirmação da inserção das horas dos certificados                                                   |
| **Pós-condições:** O usuário retorna para a tela da requisição                                                  |

| RF 026 - Validar requisição                                                                                                                                                      |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** A comissão deve ser capaz de finalizar o fluxo da requisição, deferindo-a ou indeferindo-a. Após isso, é submetido para a coordenação realizar a validação final. |
| **Atores:** Comissão.                                                                                                                                                            |
| **Prioridade:** Alta.                                                                                                                                                            |
| **Entrada:** Nenhuma.                                                                                                                                                            |
| **Pré-condições:** O usuário deve estar logado e, em casos de aprovação, a requisição deve ser enviada para a coordenação.                                                       |
| **Saída:** Confirmação da ratificação da requisição.                                                                                                                             |
| **Pós-condições:** O coordenador recebe um e-mail informando que a requisição foi finalizada pela comissão.                                                                      |

## Requisitos não funcionais

Os requisitos não funcionais fornecem diretrizes e critérios para avaliar a qualidade do sistema ou software, além de definir os padrões e metas a serem alcançados em relação a essas características. Eles desempenham um papel fundamental na satisfação dos usuários finais, garantindo que o sistema ou software atenda aos requisitos e expectativas não apenas em termos de funcionalidade, mas também em relação a outros atributos que afetam sua usabilidade, desempenho e segurança.

### Desempenho

A velocidade de resposta, a capacidade de processamento e a eficiência são fatores críticos que influenciam diretamente a experiência do usuário e o sucesso de um sistema. Logo, os requisitos abaixo definem as métricas de desempenho que deverão ser atingidas para alcançar uma boa usabilidade e experiência do usuário.

| RNF 001 - Tempo de Resposta                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deverá apresentar tempos de resposta inferiores a 1000 ms, de forma a apresentar um carregamento suficientemente rápido. |
| **Prioridade:** Alta.                                                                                                                                |

| RNF 002 - Usuários online                                                                                                                                                                                                          |
| ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deve ser altamente eficiente e capaz de gerenciar perfeitamente a conexão de até 100 usuários online simultaneamente, proporcionando uma experiência fluida e sem interrupções para todos os usuários. |
| **Prioridade:** Alta.                                                                                                                                                                                                              |

### Disponibilidade

A disponibilidade é um fator crítico para a confiabilidade e eficácia de um sistema, especialmente em ambientes onde a interrupção de serviços pode resultar em perdas financeiras, danos à reputação e insatisfação dos usuários.Os requisitos a seguir estabelecem métricas que determinam o nível de disponibilidade do sistema, ou seja, a capacidade do sistema de estar prontamente disponível para executar um serviço solicitado por um usuário.

| RNF 003 - Período ativo                                                                                                                                                                                           |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O aplicativo deve permanecer online 24 horas por dia, 7 dias por semana, com tolerância a interrupções de no máximo 2 horas em situações excepcionais para manutenções ou atualizações planejadas. |
| **Prioridade:** Média                                                                                                                                                                                             |

### Hardware

É fundamental considerar as características e limitações do hardware que será utilizado, para permitir que os desenvolvedores entendam claramente quais requisitos são necessários para garantir o desempenho, a compatibilidade e a estabilidade do sistema.

| RNF 004 - Compatibilidade                                                                                                                                                                                                                                               |
| ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** Para o perfeito funcionamento do sistema, é necessário apenas possuir um navegador com acesso à internet. Essa simplicidade na exigência de recursos garante que o aplicativo seja facilmente acessível e utilizado por uma ampla variedade de usuários. |
| **Prioridade:** Alta                                                                                                                                                                                                                                                    |

### Segurança

São descritas as medidas necessárias para proteger o sistema contra ameaças internas e externas, garantindo a confidencialidade, integridade e disponibilidade dos dados. Com isso, garantir que os desenvolvedores compreendam claramente os desafios e requisitos de segurança envolvidos no projeto, fornecendo diretrizes claras para a implementação de medidas de proteção eficazes.

| RNF 005  Criptografia                                                                                                                                                                                                                                                                                                                                                                                                    |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **Descrição:** O sistema deve priorizar a segurança dos dados e a proteção da privacidade dos usuários, adotando o uso do protocolo HTTPS (Hyper Text Transfer Protocol Secure) como uma camada de criptografia confiável. Ao utilizar o HTTPS, todas as informações transmitidas entre o aplicativo e os usuários serão criptografadas, garantindo a confidencialidade e a integridade dos dados durante a comunicação. |
| **Prioridade:** Baixa.                                                                                                                                                                                                                                                                                                                                                                                                   |

| RNF 006  Autenticação                                                                                                                                                                                                                             |
| ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** O usuário deve ser capaz de realizar login através de sua conta Google utilizando o serviço SSO (Single Sign-On) da Google além de poder fazer pelo próprio sistema utilizando a lógica de autenticação com Spring security e JWT. |
| **Prioridade:** Alta.                                                                                                                                                                                                                             |

### Documentação

A documentação de sistemas desempenha um papel fundamental no desenvolvimento, implementação e manutenção eficazes de um software ou sistema. A importância de documentar sistemas reside em fornecer um registro completo e estruturado de informações essenciais sobre o sistema, suas funcionalidades, configurações, requisitos, fluxos de trabalho e outras características relevantes. Abaixo são descritas as documentações de caráter importante para o desenvolvimento do sistema.

| RNF 007  Documentação APIs REST                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Descrição:** É fundamental que o endpoint do aplicativo seja cuidadosamente documentado, a fim de facilitar integrações futuras com outros sistemas e permitir correções eficientes de implementações no front-end. Nesse sentido, o uso da ferramenta Swagger desempenha um papel crucial. O Swagger proporciona uma abordagem estruturada e padronizada para documentação de API, permitindo que os desenvolvedores compreendam facilmente a funcionalidade e os parâmetros do endpoint. |
| **Prioridade:** Alta.|
