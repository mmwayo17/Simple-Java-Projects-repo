import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);

            System.out.print("Enter length of fibonnaci sequence: ");
            int amount = input.nextInt();

            int[] numbers = generateSequence(amount);

            for(int i = 0; i < amount; i++){
                System.out.println(numbers[i]);
            }

            input.close();
        }catch(InputMismatchException e){
            System.out.println("Input must be an integer.");
        }catch(NegativeArraySizeException e){
            System.out.print("Input must be greater than 0.");
        }
    }

    public static int[] generateSequence(int amount){
        int[] sequence = new int[amount];
        if(amount > 2){ 
            sequence[0] = 0;
            sequence[1] = 1;

            for(int i = 2; i < amount; i++){
                sequence[i] = sequence[i-2] + sequence[i-1];
            }
        }else{
            for(int i = 0; i < amount; i++){
                sequence[i] = i;
            }
        }

        return sequence;
    }
}