/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

/**
 *
 * @author crist
 */
public class Money {
    private static double totalMoney=300;

    public Money() {
    }

    public static void setTotalMoney(double totalMoney) {
        Money.totalMoney = totalMoney;
    }

    public static double getTotalMoney() {
        return totalMoney;
    }
    
}
