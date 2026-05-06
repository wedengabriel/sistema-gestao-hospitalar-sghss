# Documentação dos Endpoints - SGHSS

## Auth

### POST /auth/login

Realiza autenticação do usuário e retorna um token JWT.

#### Requisição

```json
{
  "cpf": "99999999999",
  "senha": "123"
}
```
#### Resposta esperada

```json
{
  "token": "jwt-token"
}
```
---
## Perfis

### GET /perfis

Lista todos os perfis cadastrados.

### POST /perfis

Cria um novo perfil.

```json
{
  "nomePerfil": "Paciente"
}
```
---
## Usuários

### GET /usuarios

Lista todos os usuários cadastrados.

### POST /usuarios

Cria um novo usuário.

````json
{
  "nomeUsuario": "Weden",
  "cpf": "12345678900",
  "idPerfil": 1,
  "senhaHash": "123"
}
````
---
## Pacientes

### GET /pacientes

Lista todos os pacientes cadastrados.

### POST /pacientes

Cria um novo paciente vinculado a um usuário.

````json
{
  "idUsuario": 1,
  "dataNascimento": "2001-05-10",
  "tipoSanguineo": "O+"
}
````
---
## Médicos

### GET /medicos

Lista todos os médicos cadastrados.

### POST /medicos

Cria um novo médico vinculado a um usuário.

````json
{
  "idUsuario": 2,
  "registroProfissional": "CRM-12345",
  "especialidade": "Clínico Geral"
}
````
---
## Consultas

### GET /consultas

Lista todas as consultas cadastradas.

### POST /consultas

Cria uma nova consulta.

````json
{
  "idPaciente": 1,
  "idMedico": 1,
  "dataConsulta": "2026-05-06",
  "horaConsulta": "14:30",
  "tipoConsulta": "Presencial",
  "status": "Agendada"
}
````