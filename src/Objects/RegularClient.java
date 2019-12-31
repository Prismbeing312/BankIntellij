package Objects;

public class RegularClient extends Client{


    public RegularClient(String clientName) {
        super(clientName);
        commisionRate = 0.03;
        interestRate = 0.001;
    }

    public RegularClient(String clientName, double balance) {
        super(clientName, balance);
        commisionRate = 0.03;
        interestRate = 0.001;
    }
}
