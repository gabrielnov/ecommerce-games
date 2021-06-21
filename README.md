# Ecommerce-games

### Documentação completa disponível em

``` http://localhost:8080/swagger-ui.html ```


<br/>


### Para utilizar o programa, rode o método *Main* na classe 

``` src/main/java/dev/gabriel/ecommercegames/EcommerceGamesApplication.java ```

<br/>



### Rotas

<br/>


#### ``` /api/adicionarItem    ```  >    __*POST*__

##### Exemplo de uso:

```
{
  "idProduto": 1,
  "quantidade": 2
} 
```

<br/>
<br/>


#### ``` /api/cadastrarProduto ```  >    __*POST*__

##### Exemplo de uso:

```
{
  "nomeProduto": "Smartphone",
  "popularidade": 10,
  "precoProduto": 700
} 
```

<br/>
<br/>


#### ``` /api/checkout ```  >    __*GET*__ 

##### Exemplo de resultado:

```
{
  "frete": 0,
  "subtotal": 1400,
  "total": 1400
}
```
