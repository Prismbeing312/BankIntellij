package Objects;

public class PlatinumClient extends Client{


    public PlatinumClient(String clientName) {
        super(clientName);
        commisionRate = 0.01;
        interestRate = 0.005;
    }

    public PlatinumClient(String clientName, double balance) {
        super(clientName, balance);
        commisionRate = 0.01;
        interestRate = 0.005;
    }
}
