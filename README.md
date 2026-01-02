🎁 App Doar - Sistema de Gestão de Doações
O App Doar é um projeto Android desenvolvido para facilitar a conexão entre doadores e instituições de caridade. O objetivo principal é oferecer uma plataforma onde pessoas possam doar objetos, alimentos e outros itens de forma organizada e eficiente.

🚀 Tecnologias e Ferramentas Utilizadas
Linguagem: Kotlin.

Arquitetura: Repository Pattern (Camada de Dados).

Testes Unitários: JUnit e MockK.

Injeção de Dependência: Implementada manualmente para facilitar a testabilidade.

Controle de Versão: Git e GitHub.

🧪 Foco em Qualidade: Testes Unitários
Atualmente, o projeto conta com uma cobertura de testes focada na camada de repositório (DoacaoRepository). Através do uso de Mocks, simulamos respostas de APIs externas para garantir que:

O aplicativo trate corretamente os dados recebidos.

O sistema seja resiliente a falhas de conexão (tratamento de erros).

A lógica de negócio esteja isolada da infraestrutura.

📂 Estrutura do Projeto
O código está organizado seguindo as melhores práticas de desenvolvimento Android:

app/src/main/java: Contém a lógica principal e interface.

app/src/test/java: Contém os testes unitários automatizados.
