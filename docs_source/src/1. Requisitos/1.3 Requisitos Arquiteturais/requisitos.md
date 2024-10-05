| RA 001 | Fluxo de requisição |
|----------|----------|
| Referência:| RF 011, 014, 019, 020, 021, 025, 026. |
| Descrição:| Este requisito é de grande importância arquitetural, pois é responsável pelo fluxo das solicitações que envolvem alunos, coordenação e comissão. |
| Prioridade:  | Essencial.  |
| Decisão arquitetural:  | Utilização de estratégias no backend para realizar o fluxo de cadastro e avaliação da requisição.  |
| Atributo de qualidade:  | Performance. |

| RA 002 | Desempenho |
|----------|----------|
| Referência:  | RNF 001, 002.  |
| Descrição:  | Esse requisito impacta na percepção das informações e carregamento de telas pelo usuário.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização de estratégias no back e front para evitar carregamento de informações desnecessárias que podem aumentar o tempo de resposta.  |
| Atributo de Qualidade:  | Performance.  |

| RA 003 | Disponibilidade |
|----------|----------|
| Referência:  | RNF 003. |
| Descrição:  | Esse requisito influencia o quanto o sistema estará disponível para os usuários efetuarem suas atividades.  |
| Prioridade:  | Essencial.  |
| Decisão Arquitetural:  | Utilização de servidor pessoal de um dos membros da equipe para disponibilização da API.|
| Atributo de Qualidade:  | Disponibilidade.  |

| RA 004 | Segurança |
|----------|----------|
| Referência:  | RNF 005, 006. |
| Descrição:  | Esse requisito impacta na segurança do sistema, sendo vital para preservar a privacidade dos usuários e sua segurança.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização no HTTPs e Autenticação/autorização via sistema e OAuth2.|
| Atributo de Qualidade:  | Segurança.  |

| RA 005 | Documentação |
|----------|----------|
| Referência:  | RNF 007. |
| Descrição:  | O requisito impacta na capacidade de realizar manutenções, sendo vital para um bom entendimento do webservice.  |
| Prioridade:  | Importante.  |
| Decisão Arquitetural:  | Utilização do Swagger para gerar documentação dos endpoits da API.|
| Atributo de Qualidade:  | Manutenabilidade.  |