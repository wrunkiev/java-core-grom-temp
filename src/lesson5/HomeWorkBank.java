package lesson5;

public class HomeWorkBank {
    public static void main(String[] args) {
        String [] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int [] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(withdraw(names, balances, "Ann", 600));
    }

    public static int withdraw(String [] clients, int [] balances, String client, int money){
        if(balances[findClientIndexByName(clients, client)] < money){
            return -1;
        }
        else {
            updateBalance(clients, balances, client, money);
            return balances[findClientIndexByName(clients, client)];
        }
    }

    public static int findClientIndexByName(String [] clients, String client){
        int clientIndex = 0;
        for(String cl : clients){
            if(cl == client){
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }

    public static void updateBalance(String [] clients, int [] balances, String client, int money){
        balances[findClientIndexByName(clients, client)] -= money;
    }
}
