/**
 * RuntimeExceptionsSimpleEx
 */
 import java.util.InputMismatchException;
 import java.util.Scanner;
public class RuntimeExceptionsSimpleEx {

    public static void main(String[] args) {
        
        getValueAndPrint();

    }

    public static int readValue(){
        Scanner in = new Scanner (System.in);
        System.out.print("Enter an integer number :");
        int value = 0;
        value = in.nextInt();

        return value;
    }

    public static void getValueAndPrint(){
        try{
            int value = readValue();
            System.out.println("You've entered: " + value);
        }catch(InputMismatchException e){
            System.out.println("ERROR: CANNOT ENTER NON-INTEGER VALUE !!!");
        }
    }
} 

//____________________________________Call Stack diagrame____________________________________________

//   main ()
//     |
//     |
//     |
//     |
//    ...
//    call getValueAndPrint() ----+
//    return;                     |
//    ...                         |
//     |   ^                      |
//     |   |                      |
//     |   |                      |
//     |   |                      v
//     v   |    +----------getValueAndPrint()-------------+
//         |    |                                         |
//         |    |                  call readValue()  ------------------------+
//         |    |               v        ^                |                  |
//         |    +---------------|--------|----------------+                  |
//         |                    |        |                                   v
//         |                    |        |                        +----------readValue()--------------------+
//         +------ return ------+        |                        |         value = in.nextInt();           |
//                                       |                        |                                         |
//                                       |                        +-----------------------------------------+                                           
//                                       |                                               V
//                                       |                                               |
//                                       |                                               |
//                                       +-------------------- return value -------------+


//_________________exception propagation WITHOUT try/catch____________________________________________________________________________________

//    main ()
//     |
//     |
//     |
//     |
//    ...
//    call getValueAndPrint() 
//    RuntimeExceptionsSimpleEx.java:10
//    ...                         
//     |   ^                      
//     |   |                      
//     |   |                      
//     |   |                      
//     v   |    +----------getValueAndPrint()-------------+
//         |    |                                         |
//         |    |                  call readValue()       |
//         |    |   RuntimeExceptionsSimpleEx.java:25     |
//         |    |               v        ^                |                  
//         |    +---------------|--------|----------------+                  
//         |                    |        |                                   
//         |                    |        |                        +----------readValue()--------------------+
//         +- return exception--+        |                        |         value = in.nextInt();           |
//                                       |                        |   RuntimeExceptionsSimpleEx.java:18     |
//                                       |                        +-----------------------------------------+                                           
//                                       |                                               V
//                                       |                                               |
//                                       |                                               |
//                                       +-------------------- return exception ---------+
//
//
//_________________exception propagation WITH try/catch____________________________________________________________________________________

//    main ()
//     |
//     |
//     |
//     |
//    ...
//    call getValueAndPrint() 
//    return;
//    ...                         
//     |   ^                      
//     |   |                      
//     |   |                      
//     |   |                      
//     v   |    +----------getValueAndPrint()-------------+
//         |    |                                         |
//         |    |                  call readValue()       |
//         |    |   catch(InputMismatchException e)       |
//         |    |               v        ^                |                  
//         |    +---------------|--------|----------------+                  
//         |                    |        |                                   
//         |                    |        |                        +----------readValue()--------------------+
//         +- return value -----+        |                        |         value = in.nextInt();           |
//                                       |                        |   RuntimeExceptionsSimpleEx.java:18     |
//                                       |                        +-----------------------------------------+                                           
//                                       |                                               V
//                                       |                                               |
//                                       |                                               |
//                                       +-------------------- return exception ---------+
//
//
//
//




