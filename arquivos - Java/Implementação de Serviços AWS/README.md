__RELATORIO DE IMPLEMENTAÇÃO DE SERVIÇOS AWS__

Data: 11/08/2025 -
Empresa: Secury-bag -
Responsável: João Vitor de Souza.

__INTRODUÇÃO__
Este relatório apresenta o processo de implementação de ferramentas na empresa Secury-bag, realizado por João Vitor. 
O objetivo do projeto foi elencar e implementar 3 serviços AWS, visando a segurança e a criptografia dos dados dos clientes, 
além de diminuir custos operacionais e aumentar a escalabilidade da infraestrutura.

A Secury-bag é uma empresa especializada na segurança de bagagens, onde cada cliente recebe um QR Code único para ser inserido em sua mala. 
Esse QR Code contém todas as informações do cliente e, ao ser escaneado pelo celular, fornece os dados necessários para garantir 
que a mala seja devolvida corretamente ao seu dono, evitando confusões durante a viagem. 
As informações precisam ser armazenadas na nuvem de forma segura e protegidas por criptografia.

__DESCRIÇÃO DO PROJETO__
O projeto de implementação foi dividido em 3 etapas, com foco em segurança, escalabilidade e facilidade de acesso aos dados armazenados. 
A seguir, são descritas as etapas do projeto:

**ETAPA 1:** Implementação de AWS S3 e AWS KMS (Key Management Service).
**NOME DA FERRAMENTA:** AWS S3 (Simple Storage Service) foi escolhido para o armazenamento seguro de dados dos clientes. 
As informações do cliente (como nome, contato, número de voo e QR Code gerado) serão armazenadas de forma centralizada em buckets do S3, 
garantindo escalabilidade e facilidade de acesso.
**NOME DA FERRAMENTA:** AWS KMS (Key Management Service) foi implementado para garantir que as senhas e dados confidenciais dos clientes 
sejam criptografados antes de serem armazenados. O KMS gerencia as chaves de criptografia utilizadas para proteger os dados, 
garantindo que a comunicação entre o aplicativo e o armazenamento seja feita de maneira segura.
**DESCRIÇÃO DE CASO DE USO:** A Secury-bag precisa de um local seguro para armazenar as informações sensíveis dos clientes. 
A implementação do S3 com KMS permite que todos os dados sejam armazenados de forma eficiente e protegida, sem risco de exposição de dados críticos.

**ETAPA 2:** Implementação de AWS IAM (Identity and Access Management) e AWS Cognito.
**NOME DA FERRAMENTA:** AWS IAM foi utilizado para gerenciar o acesso aos recursos AWS de forma segura. 
Cada funcionário e desenvolvedor da Secury-bag tem permissões controladas, 
garantindo que apenas usuários autorizados possam acessar ou modificar os dados dos clientes.
**NOME DA FERRAMENTA:** AWS Cognito foi implementado para o gerenciamento de autenticação e geração de senhas seguras. 
Ao ler o QR Code da mala, o cliente será autenticado por meio do app, e a senha será gerada de forma segura, 
utilizando o Cognito, e criptografada pelo KMS.
**DESCRIÇÃO DE CASO DE USO:** Quando o cliente deseja acessar suas informações de bagagem, ele precisa autenticar sua identidade de maneira segura. 
O uso do AWS Cognito com a integração do IAM garante que a autenticação seja realizada de forma segura, 
sem comprometer a privacidade dos dados.

**ETAPA 3:** Implementação de AWS Lambda com API Gateway e AWS Route 53.
**NOME DA FERRAMENTA:** AWS Lambda foi utilizado para processar as solicitações de autenticação e manipulação dos dados do cliente de maneira eficiente e sem a necessidade de servidores dedicados. Quando o cliente lê o QR Code no app, o Lambda é acionado para validar a senha e retornar os dados da mala.
**NOME DA FERRAMENTA:** API Gateway foi implementado para gerenciar as APIs RESTful que conectam o aplicativo da Secury-bag com a infraestrutura de backend. 
Ele também proporciona escalabilidade automática, sem a necessidade de gerenciamento de servidores.
**NOME DA FERRAMENTA:** AWS Route 53 foi configurado para gerenciar o DNS de forma eficiente, 
garantindo a alta disponibilidade e o rápido acesso aos serviços da Secury-bag, especialmente durante picos de tráfego de clientes
**DESCRIÇÃO DE CASO DE USO:** Ao acessar as informações por meio do app, o cliente recebe uma resposta em tempo real sobre o status da mala. 
O uso de Lambda e API Gateway proporciona uma experiência rápida e sem latência, 
enquanto o Route 53 assegura que o tráfego DNS seja direcionado corretamente.

__CONCLUSÃO__
A implementação de ferramentas na empresa Secury-bag trouxe uma série de benefícios, como segurança aprimorada para os dados dos clientes com KMS, 
armazenamento escalável com S3, e autenticação segura com Cognito. A arquitetura serverless com Lambda e API Gateway permite escalabilidade eficiente 
e redução de custos operacionais. Além disso, a integração com Route 53 garante alta disponibilidade e desempenho.

Recomenda-se a continuidade da utilização dessas tecnologias e o monitoramento contínuo para garantir o crescimento seguro da infraestrutura da Secury-bag, 
com ênfase em novos serviços da AWS que possam melhorar ainda mais a experiência do cliente e a segurança de dados.

__ANEXOS__
- Manual de Configuração AWS S3 e KMS
- Diagrama de Arquitetura de Armazenamento e Criptografia
- Guia de Implementação de Cognito e IAM
- Documentação de Implementação de Lambda e API Gateway
- Manual de Configuração DNS com Route 53

__Assinatura do responsavel pelo projeto__
João Vitor S. Ferreira

__NOTAS FINAIS__
A implementação desse modelo garantirá que a Secury-bag possa não só proteger as informações dos clientes de forma eficiente, mas também oferecer uma experiência rápida e segura para os usuários, mantendo os custos sob controle e garantindo que a infraestrutura esteja preparada para escalar conforme a demanda.

