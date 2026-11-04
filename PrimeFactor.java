import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeFactor {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        try{
            System.out.print("Enter Number to check: ");
            int number = input.nextInt();
            String response = checkPrime(number);
            System.out.println(response);
        }catch(InputMismatchException e){
            System.out.println("Must be an integer");
        }

        input.close();
    }

    public static String checkPrime(int num){
        if(num < 2){
            return "Not a prime number";
        }

        for(int i = 2; i < 10; i++){
            if(num % i == 0 && num != i){
                return "Not a prime number";
            } 
        }
        return "Is a prime number";
    }
}
