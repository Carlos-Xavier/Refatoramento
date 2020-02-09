package cineflex.manager;

import cineflex.exceptions.Exceptions;
import cineflex.person.Person;
import cineflex.movies.Movie;
import java.util.Scanner;

public final class Messages {

    static Scanner input = new Scanner(System.in);
    public static String message;
    
    public static String welcome() {
        message = "### Bem vindo ao CineFlex ### \n"
                + " 1 - Cadastrar \n"
                + " 2 - Entrar \n"
                + " 3 - Exit \n";
        return message;
    }
    
    public static String panel() {
        message = "=== Painel Inicial === \n"
                + " 1 - Gerenciar Perfil \n"
                + " 2 - Filmes \n"
                + " 3 - Histórico de Compra \n"
                + " 4 - Cancelar Compra \n"
                + " 5 - Exit \n";
        return message;
    }
    
    public static String manage(String name, int age, String gender, String city, String email, String password, Person type) {
        message = "=== Gerenciar pefil === \n"
                + "1 - Nome: " + name + "\n"
                + "2 - Idade: " + age + "\n"
                + "3 - Sexo: " + gender + "\n"
                + "4 - Cidade: " + city + "\n"
                + "5 - Senha: " + password + "\n"
                + "6 * Email: " + email + "\n"
                + "7 * Ocupação: " + type.getType() + "\n"
                + "8 * Dinheiro: " + type.getMoney() + "\n"
                + "9 * Coins: " + type.getCoins() + "\n"
                + "10 - Exit \n"
                + " =====================  \n"
                + " Qual campo deseja alterar? ";
        return message;
    }
    
    public static String movies(String movie, int sala, String[] schedules, int i) {
        message = "===================== " + i + " ===================== \n"
                + " Nome: " + movie + "   \n"
                + " Sala: " + sala + "    \n"
                + " Horário: " + schedules[0] + " (2D) | " + schedules[1] + " (2D) | " + schedules[2] + "(3D) \n"
                + ""; 
        return message;
    }
    
    public static int[] seats(Movie aux, int idSeat) {
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " - ");
            for (int j = 0; j < 5; j++) {
                if (aux.seats[idSeat].getSeats(i, j))
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }  
        for (int i = 0; i < 5; i++)
            System.out.print("  " + i);
        System.out.println();
        
        int[] values = new int[2]; 
        do {
            System.out.print("Número da linha da fileira: ");
            values[0] = Exceptions.intNum();
            System.out.print("Número da coluna da fileira: ");
            values[1] = Exceptions.intNum();
        } while (!(check(values[0]) && check(values[1])));
        
        if (!aux.seats[idSeat].getSeats(values[0], values[1])) {
            return values;
        } else {
            System.out.print("Assento indisponível!");
            return seats(aux, idSeat);
        }   
    }
    
    public static boolean check(int values) {
        return !(values > 4 || values < 0);
    }  
    
    public static String completeMovieCoin(Movie aux, Person type, String schedule, float priceFood) {
        message = " =================== \n"
                + " Filme: " + aux.getName() + "\n"
                + " Horário: " + schedule + "\n"
                + " Preço do filme: " + aux.getCoins()+ " moedas \n"
                + " Preço do lanche: " + priceFood + " reais \n"
                + " Total: " + aux.getCoins() + " moedas e " + priceFood + " reais\n"
                + " Saldo atual: " + type.getCoins() + " moeda(s)\n"
                + " =================== \n";
        return message;
    }
    
    public static String completeMovieMoney(Movie aux, Person type, String schedule, float priceFood, float value_3D) {
        message = " =================== \n"
                + " Filme: " + aux.getName() + "\n"
                + " Horário: " + schedule + "\n"
                + " Preço do filme: " + aux.getPrice() + " reais\n"
                + " Preço do lanche: " + priceFood + " reais\n"
                + " Preço do 3D: " + value_3D + " reais\n"
                + " Desconto: " + type.getDiscount() + " reais \n"
                + " Total: " + (aux.getPrice() - type.getDiscount() + priceFood + value_3D) + " reais\n"
                + " Saldo atual: " + type.getMoney() + " reais\n"
                + " =================== \n";
        return message;
    }
    
    public static String completeFood(Person tipo, float priceFood, float value_3D) {
        message = " =================== \n"
                + " Filme: Nenhum \n"
                + " Horário: Nenhum \n"
                + " Preço do filme: 0.00 \n"
                + " Preço do lanche: " + priceFood + "\n"
                + " Preço do 3D: 0.00 \n"
                + " Desconto: 0.00 \n"
                + " Total: " + priceFood + "\n"
                + " Saldo atual: " + tipo.getMoney() + "\n"
                + " =================== \n";
        return message;
    }
    
    public static String food(float popcorn, float beverage, float sweet) {
        message = " =================== \n"
                + "1 - Pipoca: R$ " + popcorn + "\n"
                + "2 - Bebida: R$ " + beverage + "\n"
                + "3 - Doce: R$ " + sweet + "\n"
                + "4 - Sair \n" 
                + " =================== \n"
                + " O que você deseja comprar ? ";        
        return message;
    }
    
    public static String payment(Movie aux) {
        message = " ### Formas de Pagamentos ### \n"
                + "1 - Dinheiro ( " + aux.getPrice() + " reais ) \n"
                + "2 - Moedas ( " + aux.getCoins() + " Moedas ) \n"
                + " ========================== \n";
        return message;
    }
    
    public static String day(String day) {
        message = "================\n"
                + " Dia: " + day + " \n"
                + "================\n";
        
        return message;
    }
    
    public static String historic(int i, Profile user) {
        message = "\n============================== \n"
                + " Filme: " + user.getHistoric(i, 0) + "\n"
                + " Horário: " + user.getHistoric(i, 1) + "\n"
                + " Dinheiro: " + user.getHistoric(i, 2) + "\n"
                + " Coins: " + user.getHistoric(i, 3) + "\n"
                + " Assento: (" +  user.getHistoric(i, 4) + ", " + user.getHistoric(i, 5) + ") \n"
                + "============================== \n"; 
        return message;
    }
}
