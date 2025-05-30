Projeto Clínica Nilton Canto

Aplicação web desenvolvida em Java com Maven, JSP e Servlets. 
Permite o gerenciamento de pacientes, médicos, suas respectivas agendas e fichas clínicas.

---

Tecnologias Utilizadas:
- Java 21
- Maven
- Servlet & JSP
- SQLite
- Jetty (servidor embarcado)
- HTML5 + CSS3
- VS Code

---

Estrutura do Projeto:

src/
├── main/
│ ├── java/com/mack/clinica/
│ │ ├── controller/ -> Servlets
│ │ ├── model/ -> DAO e classes de domínio
│ │ └── util/ -> Conexão com BD
│ └── webapp/
│ ├── *.jsp -> Páginas
│ ├── css/ -> Estilos
│ └── WEB-INF/
│ ├── pom.xml
│ └── db.db -> SQLite


---

Perfis de Acesso:
- Administrador (Admin): Cadastro de médicos e pacientes, acesso às fichas e agendas;
- Paciente (James): Visualiza e edita seus dados pessoais, agenda consultas com os médicos existentes;
- Paciente e medicos criados para testes, ainda não funcionais.

---

Funcionalidades:
- Login com controle de tipo
- Cadastro de médicos e pacientes
- Visualização de dados pessoais
- Alteração de informações do cadastro
- Ficha clínica simples (não funcional)
- Design responsivo com CSS (as páginas se adaptam ao tipo de tela em que são abertas: layout legivel em qualquer dispositivo)

---

Como Executar:

Execução no VSCode
1) git clone https://github.com/usuario/ProjetoClinicaNiltonCanto.git
2) cd ProjetoClinicaNiltonCanto
3) mvn clean install
4) mvn jetty:run
5) Na barra de URL do seu navegador: http://localhost:8080
   
ATENÇÃO
-> confira a versão do jdk instalado, o projeto se usa da versão do jdk 21
-> se atente às pastas em que o projeto foi salvo, você pode precisar copiar o caminho para que ele funcione corretamente

Equipe
Professor Nilton Canto
Emanuela Caetano
Giovanna Dias - 10436553  



