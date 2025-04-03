/*Author: Roi Porat-Shliom (with starter code from Mr. Menchukov)
 *Final Version Date: 3/18/2025
 *Piece: The Jester piece moves in a xy coordinate plane (up, down, left, and right) by jumping over the square that it is touching in that direction,
  moving a total of two squares in a certain direction
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Jester extends Piece{

    
    public Jester(boolean isWhite, String img_file) {
      super(isWhite,img_file);  
    }
    
    
  public String toString(){
    return "A "+ this.getColor()+" Jester";

  }

    /*
     * Precondition: Board and start are not null
     * Postcondition: getControlledSquares returns an arrayList of squares that the Jester piece controls, i.e can move or capture there
     */
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> ctrlSqrs = new ArrayList<Square>();
      if(start.getCol()+2<8){                      
          ctrlSqrs.add(board[start.getRow()][start.getCol()+2]);       
        }

        if(start.getCol()-2>=0){                           
            ctrlSqrs.add(board[start.getRow()][start.getCol()-2]);          
        }

        if(start.getRow()+2<8){                           
            ctrlSqrs.add(board[start.getRow()+2][start.getCol()]);           
        }

        if(start.getRow()-2>=0){                           
            ctrlSqrs.add(board[start.getRow()-2][start.getCol()]);  
        }
     return ctrlSqrs;
    }
    
    /*
     * Piece logic: The Jester piece can move in an xy plane in increments of two, meaning that it can jump over a piece (or move two without jumping) directly next to it 
     *and land/capture two squares away from its original square in the vertical or horizontal directions
     */
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        //start by declaring the arrayList we wish to return at the end
        ArrayList<Square> moves = new ArrayList<Square>();
                 if(start.getCol()+2<8){
                  if ((b.getSquareArray()[start.getRow()][start.getCol()+2]).isOccupied() == false || (b.getSquareArray()[start.getRow()][start.getCol()+2]).getOccupyingPiece().getColor()==!color){                  
                    moves.add(b.getSquareArray()[start.getRow()][start.getCol()+2]);
                   }
                  }

                  if(start.getCol()-2>=0){
                    if (b.getSquareArray()[start.getRow()][start.getCol()-2].isOccupied() == false || b.getSquareArray()[start.getRow()][start.getCol()-2].getOccupyingPiece().getColor()==!color){                  
                      moves.add(b.getSquareArray()[start.getRow()][start.getCol()-2]);
                     }
                  }

                  if(start.getRow()+2<8){
                    if ((b.getSquareArray()[start.getRow()+2][start.getCol()]).isOccupied() == false || (b.getSquareArray()[start.getRow()+2][start.getCol()]).getOccupyingPiece().getColor()==!color){                  
                      moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()]);
                     }
                  }

                  if(start.getRow()-2>=0){
                    if (b.getSquareArray()[start.getRow()-2][start.getCol()].isOccupied() == false || b.getSquareArray()[start.getRow()-2][start.getCol()].getOccupyingPiece().getColor()==!color){                  
                      moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()]);
                     }
                  }

             return moves;
      }     
    }