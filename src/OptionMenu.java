import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormate = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your Customar Number: ");
                setCustomarNumber(menuInput.nextInt());

                System.out.println("Enter your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            }
            catch (Exception e){
                System.out.println("\nInvalid Character(s), Only Numbers.\n");
                x = 2;
            }

            int cn = getCustomarNumber();
            int pn = getPinNumber();
            if(data.containsKey(cn) && data.get(cn) == pn){
                getAccountType();
            }else
                System.out.println("\nWrong Customar Number or Pin Number.\n");
        }while (x == 1);
    }

    public void getAccountType(){
        System.out.println("Select The Account You Want To Access: ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You for using this ATM. Bye \n");
                break;
            default:
                System.out.println("\nInvalid Choice \n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Checking Account Balance: "+moneyFormate.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM. Bye \n");
                break;
            default:
                System.out.println("\nInvalid Choice \n");
                getChecking();
            }
        }

    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.print("Choice: ");

        int selection = menuInput.nextInt();

        switch (selection){
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormate.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You for using this ATM. Bye \n");
                break;
            default:
                System.out.println("\nInvalid Choice \n");
                getChecking();
        }
    }
}
