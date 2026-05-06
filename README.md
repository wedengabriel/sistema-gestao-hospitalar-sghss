# SGHSS - Sistema de Gestão Hospitalar

Projeto Back-end desenvolvido em **Java com Spring Boot**, criado do zero para gerenciamento de dados hospitalares.

---

## 🚀 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT
- H2 Database (arquivo)
- Maven
- Swagger (OpenAPI)
- Docker Desktop

---

## ✅ Pré-requisitos

Para executar o projeto localmente, é necessário ter instalado:

- Git
- Java JDK 21
- Docker Desktop (opcional, recomendado para execução sem instalar Java manualmente)
- Navegador web

Para verificar o Java:

```powershell
java -version
```

Para verificar o Docker:

```PowerShell
docker --version
docker compose version
```

---


---

## ▶️ Como rodar o projeto localmente

Primeiro, clone o repositório:

```powershell
git clone https://github.com/wedengabriel/sistema-gestao-hospitalar-sghss.git
```

Entre na pasta do projeto:

```powershell
cd sistema-gestao-hospitalar-sghss
```

Execute o projeto:

```PowerShell
.\mvnw spring-boot:run
```

Importante: o comando deve ser executado dentro da pasta raiz do projeto, onde está localizado o arquivo pom.xml.
---

## 🐳 Como rodar com Docker

Com o Docker Desktop aberto, execute na pasta raiz do projeto:

Se for a primeira vez rodando o projeto

```powershell
docker compose up --build
```

Após a primeira execução, para iniciar novamente sem reconstruir a imagem:

```PowerShell
docker compose up
```

Para parar o container:

```PowerShell
docker compose down
```

Usando Docker, não é necessário instalar o Java manualmente na máquina, pois o ambiente é criado dentro do container.
---

## 📦 Funcionalidades atuais

- API REST funcionando
- Autenticação com JWT
- Login de usuários
- Cadastro de Perfis
- Cadastro de Usuários
- Cadastro de Pacientes
- Cadastro de Médicos
- Cadastro de Consultas
- Banco de dados persistente (H2 em arquivo)
- Integração completa API ↔ Banco
- Estrutura profissional em camadas
- Documentação Swagger/OpenAPI

---

## 🔐 Autenticação JWT

Endpoint de login:

```http
POST /auth/login
```

Exemplo:

```json
{
  "cpf": "99999999999",
  "senha": "123"
}
```

Resposta:

```json
{
  "token": "jwt-token"
}
```

---

## 🏗️ Estrutura do projeto

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── sghss/
    │           └── backend/
    │               ├── config/
    │               │   └── SecurityConfig.java
    │               │
    │               ├── controller/
    │               │   ├── AuthController.java
    │               │   ├── ConsultaController.java
    │               │   ├── MedicoController.java
    │               │   ├── PacienteController.java
    │               │   ├── PerfilController.java
    │               │   ├── RootController.java
    │               │   └── UsuarioController.java
    │               │
    │               ├── dto/
    │               │   ├── ConsultaCreateDTO.java
    │               │   ├── ConsultaDTO.java
    │               │   ├── LoginRequestDTO.java
    │               │   ├── LoginResponseDTO.java
    │               │   ├── LogAuditoriaDTO.java
    │               │   ├── MedicoCreateDTO.java
    │               │   ├── MedicoDTO.java
    │               │   ├── PacienteCreateDTO.java
    │               │   ├── PacienteDTO.java
    │               │   ├── PerfilDTO.java
    │               │   ├── ProntuarioDTO.java
    │               │   ├── UsuarioCreateDTO.java
    │               │   ├── UsuarioDTO.java
    │               │   └── UsuarioUpdateDTO.java
    │               │
    │               ├── entity/
    │               │   ├── Consulta.java
    │               │   ├── LogAuditoria.java
    │               │   ├── Medico.java
    │               │   ├── Paciente.java
    │               │   ├── Perfil.java
    │               │   ├── Prontuario.java
    │               │   └── Usuario.java
    │               │
    │               ├── repository/
    │               │   ├── ConsultaRepository.java
    │               │   ├── LogAuditoriaRepository.java
    │               │   ├── MedicoRepository.java
    │               │   ├── PacienteRepository.java
    │               │   ├── PerfilRepository.java
    │               │   ├── ProntuarioRepository.java
    │               │   └── UsuarioRepository.java
    │               │
    │               ├── service/
    │               │   ├── AuthService.java
    │               │   ├── ConsultaService.java
    │               │   ├── JwtService.java
    │               │   ├── MedicoService.java
    │               │   ├── PacienteService.java
    │               │   ├── PerfilService.java
    │               │   └── UsuarioService.java
    │               │
    │               └── BackendApplication.java
    │
    └── resources/
        ├── application.properties
        ├── static/
        └── templates/
```

---

## 🌐 Acessos

Após iniciar o projeto, acesse:

### API
```http
http://localhost:8080
```

### Swagger
```PowerShell
http://localhost:8080/swagger-ui/index.html
```

### H2 Console
```http
http://localhost:8080/h2-console
```
---

## 🗄️ Configuração do banco (H2)

```text
JDBC URL: jdbc:h2:file:./data/sghss  
User: sa  
Password: (vazio)
```
---

## 📡 Endpoints disponíveis

### Auth

```http
POST /auth/login
```

---

### Perfis

```http
GET /perfis
POST /perfis
GET /perfis/{id}
DELETE /perfis/{id}
```

---

### Usuários

```http
GET /usuarios
POST /usuarios
GET /usuarios/{id}
PUT /usuarios/{id}
DELETE /usuarios/{id}
```

---

### Pacientes

```http
GET /pacientes
POST /pacientes
GET /pacientes/{id}
DELETE /pacientes/{id}
```

---

### Médicos

```http
GET /medicos
POST /medicos
GET /medicos/{id}
DELETE /medicos/{id}
```

---

### Consultas

```http
GET /consultas
POST /consultas
GET /consultas/{id}
DELETE /consultas/{id}
```

---

## 📌 Observação

Este projeto foi desenvolvido como evolução prática para aprendizado de desenvolvimento Back-end com Java, incluindo:

- criação de API REST
- autenticação JWT
- persistência de dados
- organização em camadas
- integração com banco de dados
- segurança de autenticação com BCrypt
- documentação Swagger/OpenAPI

---

## 👨‍💻 Autor

Weden Gabriel  
RU: 4170826
