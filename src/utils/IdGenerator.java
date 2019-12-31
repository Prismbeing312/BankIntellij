package utils;

public class IdGenerator {
    private static int accountId;
    private static int clientId;

    public static int generateAccountId() {

        return ++accountId;
    }

    public static int generateClientId() {

        return ++clientId;
    }
}