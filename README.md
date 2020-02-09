
# Refatoramento

O código escolhido para o refatoramento foi o [https://github.com/Carlos-Xavier/P3-Projects/tree/master/O.O-Project](https://github.com/Carlos-Xavier/P3-Projects/tree/master/O.O-Project) .

# Code smells

Os smells tratados nesse refatoramento foram **_Long method_**, **_Lazy class_** e **_Duplicated code_**.

## Duplicated code

Esse smell esta localizado no arquivo **Messages.java**.  A classe possuí 3 funções  para **_seats_** que divergem apenas pela chamada dos métodos (sala 1, sala 2 e sala 3). 
O problema central desse smell está em torno do arquivo **Movie.java** que possuí atributos e métodos diferentes para os 3 assentos.

Antes da correção: 
> [https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/manager/Messages.java](https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/manager/Messages.java)
> [https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/movies/Movie.java](https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/movies/Movie.java)

A solução encontrada foi criar uma classe **_seats_**, eliminando assim os métodos e atributos desnecessários. Dessa forma, os códigos duplicados também sumiram.

Depois da correção:
> [https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/manager/Messages.java](https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/manager/Messages.java)
> [https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/movies/Movie.java](https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/movies/Movie.java) <br>
> [https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/movies/Seats.java](https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/movies/Seats.java)


## Lazy class

Esse smell esá localizado nos arquivos **Beverage.java**, **Popcorn.java** e **Sweet.java**. A criação dessas classes foi desnecessária, elas apenas herdam da classe **food.java** passando o seu preço.

Antes da correção: 
> [https://github.com/Carlos-Xavier/P3-Projects/tree/master/O.O-Project/cineflex/food](https://github.com/Carlos-Xavier/P3-Projects/tree/master/O.O-Project/cineflex/food)

A solução encontrada foi adicionar o atributo **_name_** com seus métodos na classe **food.java**. Dessa forma, uma lista de **_food_** foi criada passando o nome e o preço para cada posição.

Depois da correção:
> [https://github.com/Carlos-Xavier/Refatoramento/tree/master/cineflex/food](https://github.com/Carlos-Xavier/Refatoramento/tree/master/cineflex/food)

## Long method

Esse smell está localizado no arquivo **Profile.java**. A função em questão é a **_cancelPurchase_** que possuí um elevado número de linhas, dificultando a compreensão dela.

Antes da correção: 
> [https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/manager/Profile.java](https://github.com/Carlos-Xavier/P3-Projects/blob/master/O.O-Project/cineflex/manager/Profile.java)

A solução encontrada foi a divisão da função, dessa forma, as funções **_getMovieIndex_**, **_getRoomIndex_**, **_setMoney_** e **_setSeats_** foram criados. Tornando assim, a compreensão da **_cancelPurchase_** mais fácil.

Depois da correção:
> [https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/manager/Profile.java](https://github.com/Carlos-Xavier/Refatoramento/blob/master/cineflex/manager/Profile.java)

