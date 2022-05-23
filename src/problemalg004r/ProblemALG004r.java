 
package problemalg004r;

import java.util.Scanner;

/**
 *
 * @author tresorkl
 */
public class ProblemALG004r {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[][] magicSquare;

        boolean isOddNumber = false;

        int size;
        
        do{
          System.out.println("Please enter the size: ");
          size = input.nextInt();
          
          if(size%2>0){
              isOddNumber = true;
             magicSquare = generateMagicSquare(size);

             displayMagicSquare(magicSquare);
          }else{
             System.out.println("INVALID SIZE: the size must be an odd number");
             isOddNumber = false;
          }
        
        
        }while(!isOddNumber);

 

    }
    
//--------------------------------------------------------------
// the generateMagicSquare method helps to generate a magic square 
// of a specific size   
//---------------------------------------------------------------    

    public static int [][] generateMagicSquare(int size){
    int[][] magicSquare = new int[size][size];
    
    // initilize position
    int row = size / 2;
    int column = size - 1;
    
    for (int num = 1; num <= size * size;) {
        
        //prevent if  If the calculated row position == -1 and column position == size
            if (row == -1 && column == size)
            {
                column = size - 2;
                row = 0;
            }
            else {
               
           //prevent if next number to go out of square's right side
                if (column == size){
                    column = 0;
                }
             
          //prevent if next number to go out of square's upper side
                if (row < 0){
                    row = size - 1;
                }
            }
 
         //prevent If the magic square already contains a number at the current position
            if (magicSquare[row][column] != 0) {
                column -= 2;
                row++;
               // continue;
            }else{
                // set number
                magicSquare[row][column] = num++;
 
            // determining The position of next number
            column++;
            row--;
            }
        }
    
    return magicSquare;
    }
//--------------------------------------------------------------
// this method helps to display the magic square
//---------------------------------------------------------------  

    private static void displayMagicSquare(int[][] magicSquare) {

        int size = magicSquare.length;
      
        String rowStr ="";

        
        for (int j = 0; j < (magicSquare.length); j++) {

            for (int k = 0; k < (magicSquare[j].length); k++) {

                rowStr =rowStr+(magicSquare[j][k] + " ");
                
               
            }
           
            rowStr = rowStr.concat("\n");
 
         

        }
         System.out.println(rowStr);
         
         

        System.out.println("The Magic constant is " + size* (size * size + 1) / 2);
    }

}
