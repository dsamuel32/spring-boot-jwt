# spring-boot-jwt
Exemplo de aplicação REST com autenticação usando JWT.

- Tecnologias Utilizadas
- Spring Boot
- Spring Security
- Spring Security OAuth
- Spring MVC
- Spring Data JPA
- Liquibase
- ModelMapper
- Swagger(Pendente)
- Mysql

### Instruções

- Criar um schema chamado acessos;

- E executar o comando 

### Build/Start do sistema

```
mv clean install spring-boot:run
```
### Chamando as APIs

- Efetue uma requisição para o endpont público:
```sh
curl http://localhost:8080/autenticacao/publico/v1/home
```
Resposta
```sh
{
  "Pagina": "Página sem segurança!!!!"
}


- Efetue uma requisição para o endpont protegido:

```sh
curl http://localhost:8080/autenticacao/v1/usuario
```
Resposta 
```sh
{
  "error": "unauthorized",
  "error_description": "An Authentication object was not found in the SecurityContext"
}
```

- Endpoint de autentição
```sh
curl -X POST -vu testjwtclientid:XY7kmzoNzl100  http://localhost:8080/autenticacao/oauth/token -H "Accept: application/json" -d grant_type=password -d username=teste -d password=123

```

Resposta
```sh
{
	"access_token":"eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidGVzdGUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI4Mjg4MzczLCJhdXRob3JpdGllcyI6WyJBRE0iXSwianRpIjoiMDEyZGNhMDMtMGYxNy00YzE4LWE1Y2QtMTU5MmFlNWRmNGNkIiwiY2xpZW50X2lkIjoidGVzdGp3dGNsaWVudGlkIn0.gAKUbBpHw_kkntUE2D2IB_De_usekG8KbTkc-7MHNKE",
	"token_type":"bearer",
	"expires_in":43199,
	"scope":"read write",
	"jti":"012dca03-0f17-4c18-a5cd-1592ae5df4cd"
}
```

- Use o access_token para se autenticar
```sh
curl http://localhost:8080/autenticacao/v1/usuario -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOlsidGVzdGp3dHJlc291cmNlaWQiXSwidXNlcl9uYW1lIjoidGVzdGUiLCJzY29wZSI6WyJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTI4Mjg4MzczLCJhdXRob3JpdGllcyI6WyJBRE0iXSwianRpIjoiMDEyZGNhMDMtMGYxNy00YzE4LWE1Y2QtMTU5MmFlNWRmNGNkIiwiY2xpZW50X2lkIjoidGVzdGp3dGNsaWVudGlkIn0.gAKUbBpHw_kkntUE2D2IB_De_usekG8KbTkc-7MHNKE"
```
Resposta 
```sh
{
    "nome": "teste",
    "userName": "teste",
    "enabled": true,
    "permissoes": [
        {
            "id": 1,
            "descricao": "ADM"
        }
    ]
}
```



