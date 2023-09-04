import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 * The presented code is a Java file that contains two classes: main2 and heapi. 
 * The code creates a program that performs operations on the heap data structure.
 * The main2 class is the entry point of the program. Inside the class, 
 * there is a method named "main" that serves as the entry point for the program.
 * The method contains code that performs operations on an array and the heap.
 *The heapi class contains functions that represent actions related to the process of constructing
 *and managing the heap. Additionally, the class includes functions that perform operations such as 
 *adding and removing elements from the heap, sorting the heap, and more.
 * The purpose of the program is to build a heap from a given array and allow the user to 
 * perform additional operations on the heap through a menu called. The menu offers the user
 * options to perform actions such as extracting the maximum or minimum element, deleting an element, 
 * adding an element, sorting the heap, rebuilding the heap, and exiting the program.
 *
 * @author (Leah Kronengold,214087173)
 * @author (Ester Gotliv,213497878)
 * @version (24/06/2023)
 */
public class main2
{
    public static void main(String[] args){
        int FLAG = 0;
        Scanner scan = new Scanner(System.in); 
        int response;

        System.out.println("Enter values for heap:");
        double A[] = new double[512];//Variable definition of an array of size 512

        System.out.println("Enter numbers (Enter any non-number character to stop):");
        List<Double> numbers = new ArrayList<>();
        int point = 0;
        while (numbers.size() <= 512 && scan.hasNext()) {
            if (scan.hasNextInt()) {//Checking whether to stop
                double number = scan.nextDouble();
                numbers.add(number);
            } 
            else {
                String input = scan.next();
                if(isPrideString(input)==true)
                {
                    numbers.add(Double.parseDouble(input));  
                }
                else{
                    System.out.println("Invalid input: " + input);
                    break;
                }
            }
        }
        int i;
        for (i = 0; i < numbers.size(); i++) {
            A[i] = numbers.get(i);
        }

        heapi.size = i;//Setting the length of the array to be the number of numbers entered
        heapi.BUILDHEAP(A);//Building the stack

        System.out.print("The correct stack for the conditions is:\t");
        heapi.PrintHeap(A);

        while(FLAG == 0){
            System.out.println("\nChoose the function you want:");
            System.out.println("1. Extract maximum from the heap");
            System.out.println("2. Extract minimum from the heap");
            System.out.println("3. To delete a value instead of the index (an index must be inserted)");
            System.out.println("4. Insert a value into the array");
            System.out.println("5. Use the given heap to sort it's keys (deletes heap,for to stay and build a new heap press 6)");
            System.out.println("6. build the heap again (overrides current values)");
            System.out.println("7. Exit");
            response = scan.nextInt();

            switch(response){
                case 1:
                    System.out.println("The heap's max is:\t" + A[0]);
                    heapi.HEAPEXTRACTMAX(A);
                    System.out.print("The new heap:\t");
                    heapi.PrintHeap(A);
                    break;

                case 2:
                    if(A[1]>A[2])
                        System.out.println("The heap's min is:\t" + A[2]);
                    else
                        System.out.println("The heap's min is:\t" + A[1]);
                    heapi.HEAPEXTRACTMIN(A);
                    System.out.print("The new heap:\t");
                    heapi.PrintHeap(A);
                    break;

                case 3:
                    if (scan.hasNextInt()) {
                        System.out.print("Enter index for removal:\t");
                        response = scan.nextInt();
                        heapi.HEAPDELETE(A,response);
                        System.out.print("The heap after removal:\t");
                        heapi.PrintHeap(A);
                        break;
                    } 
                    else {
                        String number = scan.next();
                        System.out.println("Error:You did not enter a number or Integer");
                        break;
                    }

                case 4:
                    System.out.print("Enter key for insertion:\t");
                    if (scan.hasNextInt()) {
                        int number = scan.nextInt();
                        System.out.println("The input is: " + number);
                        heapi.HEAPINSERT(A,number);
                        System.out.print("The heap after insertion:\t");
                        heapi.PrintHeap(A);
                        break;
                    } 
                    else {
                        String number = scan.next();
                        if(isPrideString(number)==true)
                        {  
                            System.out.println("The input is: " + Double.parseDouble(number));
                            heapi.HEAPINSERT(A,(Double.parseDouble(number)));
                            System.out.print("The heap after insertion:\t");
                            heapi.PrintHeap(A);
                            break;
                        }
                        else{
                            System.out.println("Error:You did not enter a number");
                            break;
                        }

                    }

                case 5:
                    heapi.heapSort(A);
                    break;

                case 6:
                    heapi.size=0;
                    System.out.println("Enter numbers (enter any non-numeric value to stop):");
                    numbers.clear();
                    point = 0;
                    while (numbers.size() <= 512 && scan.hasNext()) {
                        if (scan.hasNextInt()) {//Checking whether to stop
                            double number = scan.nextDouble();
                            numbers.add(number);
                        } 
                        else {
                            String input = scan.next();
                            if(isPrideString(input)==true)
                            {
                                numbers.add(Double.parseDouble(input));  
                            }
                            else{
                                System.out.println("Invalid input: " + input);
                                break;
                            }
                        }
                    }

                    for (i = 0; i < numbers.size(); i++) {
                        A[i] = numbers.get(i);
                    }

                    heapi.size = i;
                    heapi.BUILDHEAP(A);

                    System.out.print("The heap (after correction):\t");
                    heapi.PrintHeap(A);
                    break;

                case 7:
                    FLAG = 1;
                    break;
            }
        }

    }

    public static boolean isPrideString(String str) {
        int dotCount = 0;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                if (c == '.') {
                    dotCount++;
                } else {
                    return false;
                }
            }
        }
        return dotCount == 1;
    }
}
