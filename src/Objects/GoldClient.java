package Objects;

public class GoldClient extends Client{


    public GoldClient(String clientName) {
        super(clientName);
        commisionRate = 0.02;
        interestRate = 0.003;
    }

    public GoldClient(String clientName, double balance) {
        super(clientName, balance);
        commisionRate = 0.02;
        interestRate = 0.003;
    }
}
