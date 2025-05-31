# 🏥 Sistema de Agendamento de Consultas - Clínica Nilton Canto

Este projeto é um sistema web desenvolvido em **Java com JSP/Servlets**, voltado para o agendamento de consultas em uma clínica médica. O objetivo principal foi aplicar conhecimentos de desenvolvimento fullstack em Java, organizando o fluxo de usuários, profissionais de saúde e administração de horários, em um ambiente intuitivo, funcional e seguro.

## Tecnologias Utilizadas

- Java 21  
- Maven  
- Servlet & JSP  
- SQLite  
- Jetty (servidor embarcado)  
- HTML5 + CSS3  

## Perfis de Acesso

- **Administrador (Admin)**: Cadastro de médicos e pacientes, acesso às fichas e agendas  
- **Paciente (James)**: Visualiza e edita seus dados pessoais, agenda consultas com os médicos existentes  
- *Observação:* Pacientes e médicos criados para testes, funcionalidades ainda em desenvolvimento.

# Funcionalidades:

- Login com controle de tipo (admin ou paciente)
- Cadastro de médicos e pacientes
- Visualização e edição de dados pessoais
- Ficha clínica simples (estrutura inicial)
- **Design responsivo com CSS**  
  *(As páginas se adaptam ao tipo de tela em que são abertas: layout legível em qualquer dispositivo)*

## veja abaixo imagens do nosso sistema:

### Nosso primeiro contato com a aplicação, onde todos os usuarios podem fazer o seu Login
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/admPainel.jpeg)


### Aqui temos nossa Home para o perfil administrativo, onde conseguimos vizualizar todas as funcionalidades da aplicação
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/admPainel.jpeg)

### Aqui temos nossa agenda administrativa, onde nosso administrador pode conferir todas as consultas e realizar buscas
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/agenda.jpeg)

### Aqui pode ser verificado o prontuario de pacientes
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/fichaClinica.jpeg)

### Agora exlorando na nossa area do paciente, podemos vizualizar todas as opções possiveis
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/pacientePainel.jpeg)

### Aqui podenos vizualizar os dados pesoais do paciente logado, ode ele também pode alterar
![](https://github.com/EmanuelaCaetano/ProjetoClinicaNiltonCanto/blob/main/src/main/webapp/img/meuCadastroP.jpeg)


### Confira nosson pototipo na integra [aqui](https://www.canva.com/design/DAGlrrGQW1Y/SgdnRW5kgnkSFl65PftyqA/edit?utm_content=DAGlrrGQW1Y&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton)

## Como Executar:

**Via VS Code**

```bash
git clone https://github.com/usuario/ProjetoClinicaNiltonCanto.git
cd ProjetoClinicaNiltonCanto
mvn clean install
mvn jetty:run
```


# **Atenção:**

* Certifique-se de estar usando **JDK 21**
* Verifique o caminho correto onde o projeto foi salvo (pode precisar ajustar o `realPath` para o banco)

---

## Desenvolvedores:

Esse projeto foi desenvolvido por: [Nilton Canto](), [EmanuelaCaetano]() e [Giovanna]()

---

Este projeto tem caráter didático e demonstrativo, representando um mini-sistema realista com:

* Separação de responsabilidades (MVC);
* Manipulação de formulários e sessões;
* Boas práticas de design de interface (CSS customizado);
* Uso de JSTL e integração com banco de dados.
