package com.scaler.Splitwise.service.strategy;

public class SettleUpStrategyFactory {
    //TODO : add an enum for different strategies, and then update this method accordingly
    public static SettleUpStrategy getSettleUpStrategy(){
        return new HeapBasedSettleUpStrategy();
    }
}
