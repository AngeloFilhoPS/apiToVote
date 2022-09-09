# apiToVote

## Situação
Objetivo
No cooperativismo, cada associado possui um voto e as decisões são tomadas em assembleias, por votação. Imagine que você deve criar uma solução backend para gerenciar essas sessões de votação.

Objetivos
---

* Cadastrar uma nova pauta <br>
* Abrir uma sessão de votação em uma pauta (a sessão de votação deve ficar aberta por um tempo determinado na chamada de abertura ou 1 minuto por default) <br>
* Receber votos dos associados em pautas (os votos são apenas 'Sim'/'Não'. Cada associado é identificado por um id único e pode votar apenas uma vez por pauta) <br>
* Contabilizar os votos e dar o resultado da votação na pauta <br>

---
# Estrutura do projeto

![portsadapters](https://user-images.githubusercontent.com/49157485/189348690-7492abe9-8843-4dd0-92e0-52af052cb897.png)

# Endpoints
Para fazer os testes, importe as requisições no Insominia ou Postman



# Pautas
___
## POST - Criar uma pauta
```
curl --location --request POST 'localhost:8080/schedule' \
--header 'Content-Type: application/json' \
--data-raw '{
    "scheduleName":"ASSEMBLEIA DE TES",
   "scheduleDescription":"convocação geral"
}'
```

## GET - Listar as pautas

```
curl --location --request GET 'localhost:8080/schedule' \
--header 'Content-Type: application/json' \
--data-raw '{
    "scheduleDescription":"todo tipo de porcentagem"
}'
```

# Sessão de Votação

---
# POST - Iniciar uma sessão
```
curl --location --request POST 'localhost:8080/votesession' \
--header 'Content-Type: application/json' \
--data-raw '{
    "idScheduleVote":1,
    "minDurationSession":60
}'
```
# PATCH - Encerra uma sessão

```
curl --location --request PATCH 'localhost:8080/votesession?id=1'
```

# POST - Enviar um voto
```
curl --location --request POST 'localhost:8080/vote' \
--header 'Content-Type: application/json' \
--data-raw '{
    "idScheduleVote":1,
    "idVoteSession":1,
    "vote":"SIM",
    "cpf":"02315527260"
}'
```
