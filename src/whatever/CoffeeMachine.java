/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whatever;

/**
 *
 * @author vitco
 */
public class CoffeeMachine {
    
//    public String[] drinkNames = {"Капучино", "Эспрессо", "Water", "Milk"};
//    public int[] drinkPrices = {150, 80, 20, 50};

    // Объявдяем переменные, но значения им будут присваиваться в методе Main.
    public String[] drinkNames;
    public int[] drinkPrices;
    
    public CoffeeMachine(int[] drinkPrices, String[] drinkNames) {
        this.drinkPrices = drinkPrices;
        this.drinkNames = drinkNames;
        
    }
    
    
    
    
    public void checkPrices(int moneyAmount) {
       //int totalMoneyAmount;     
    //   String[] drinkNames = {"Капучино", "Эспрессо", "Water", "Milk"};
    //    int[] drinkPrices = {150, 80, 20, 50};
         
        
        
        try {
            System.out.println("Try to print un-wrote element " + drinkPrices[5]);
        }
        catch(Exception ex){
            System.out.println("exception :(");
            ex.printStackTrace();
        }
        boolean canBuySomething = false;
        
        for (int i=0; i < drinkPrices.length; i++){
            if(moneyAmount >= drinkPrices[i]) {
                System.out.println("Вы можете купить: " + drinkNames[i]);
                canBuySomething = true;
            }
         }
        
        if(canBuySomething == false) {
            System.out.println("Средств недостаточно для покупки, пополните счет!");
        }
        }
    
    
}
