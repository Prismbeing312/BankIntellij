package Objects;

public class Bank {
    Client[] clients;
    protected double bankBalance;
    protected static double sumComission;

    public Bank() {
        clients = new Client[100];
    }

    public void setBankBalance(){
        for (Client sum:clients) {
            bankBalance += sum.getFortune();
        }
        bankBalance += sumComission;
    }

    public double getBankBalance(){
        return bankBalance;
    }

    public void addClient(Client client){
        boolean canAdd = false;
        int index = -1;
        for (int i = 0; i < clients.length ; i++) {
            if (clients[i] == null){
                index = i;
                canAdd = true;
                break;
            }
        }
        if (canAdd){
            clients[index] = client;
            bankBalance += clients[index].getFortune();
        }
        else{
            System.out.println("Cannot add more clients");
        }
    }

    public void removeClient(int id){
        for (int i = 0; i < clients.length ; i++) {
            clients[i].equals(id);
        }
    }

    public static void addComission(double comission){
        sumComission += comission;
    }


}
