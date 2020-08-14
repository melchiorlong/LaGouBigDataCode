package com.homework.Stage1.Section2.Topic3;

public class SimCard {

    private String CardType;
    private String CardNum;
    private String UserName;
    private String Password;
    private double AccountBalance;
    private int CallingDuration;
    private int NetworkFlow;

    public SimCard() {
    }

    public SimCard(String cardType, String cardNum, String userName, String password, double accountBalance, int callingDuration, int networkFlow) {
        CardType = cardType;
        CardNum = cardNum;
        UserName = userName;
        Password = password;
        AccountBalance = accountBalance;
        CallingDuration = callingDuration;
        NetworkFlow = networkFlow;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public String getCardNum() {
        return CardNum;
    }

    public void setCardNum(String cardNum) {
        CardNum = cardNum;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        AccountBalance = accountBalance;
    }

    public int getCallingDuration() {
        return CallingDuration;
    }

    public void setCallingDuration(int callingDuration) {
        CallingDuration = callingDuration;
    }

    public int getNetworkFlow() {
        return NetworkFlow;
    }

    public void setNetworkFlow(int networkFlow) {
        NetworkFlow = networkFlow;
    }

    public void simCardShow() {
        System.out.println("卡号、用户名、当前余额分别为：" + getCardNum() + ", " + getUserName() + ", " + getAccountBalance());
    }


}
