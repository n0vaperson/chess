/*Author: Roi Porat-Shliom (with starter code from Mr. Menchukov)
 *Final Version Date: 3/5/2025
 *Purpose: Create a visually accurate chess board with the functionality of one special piece working
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
public class Piece {
    private final boolean color;
    private BufferedImage img;
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> ctrlSqrs = new ArrayList<Square>();
      if(start.getCol()+2<8){
        if (((board[start.getRow()][start.getCol()+2]).isOccupied() == false) || (board[start.getRow()][start.getCol()+2]).getOccupyingPiece().getColor()==!start.getColor()){                  
          ctrlSqrs.add(board[start.getRow()][start.getCol()+2]);
         }
        }

        if(start.getCol()-2>=0){
          if (((board[start.getRow()][start.getCol()-2]).isOccupied() == false) || (board[start.getRow()][start.getCol()-2]).getOccupyingPiece().getColor()==!start.getColor()){                  
            ctrlSqrs.add(board[start.getRow()][start.getCol()-2]);
           }
        }

        if(start.getRow()+2<8){
          if (((board[start.getRow()+2][start.getCol()]).isOccupied() == false) || (board[start.getRow()+2][start.getCol()]).getOccupyingPiece().getColor()==!start.getColor()){                  
            ctrlSqrs.add(board[start.getRow()+2][start.getCol()]);
           }
        }

        if(start.getRow()-2>=0){
          if (((board[start.getRow()-2][start.getCol()]).isOccupied() == false) || (board[start.getRow()-2][start.getCol()]).getOccupyingPiece().getColor()==!start.getColor()){                  
            ctrlSqrs.add(board[start.getRow()-2][start.getCol()]);
           }
        }
     return ctrlSqrs;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    /*
     * Piece logic: The Jester piece can move in an xy plane in increments of two, meaning that it can jump over a piece (or move two without jumping) directly next to it 
     *and land/capture two squares away from its original square in the vertical or horizontal directions
     */
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        //start by declaring the arrayList we wish to return at the end
        ArrayList<Square> moves = new ArrayList<Square>();
                 if(start.getCol()+2<8){
                  if (((b.getSquareArray()[start.getRow()][start.getCol()+2]).isOccupied() == false) || (b.getSquareArray()[start.getRow()][start.getCol()+2]).getOccupyingPiece().getColor()==!start.getColor() || b.getSquareArray()[start.getRow()][start.getCol()+2].getColor()!=start.getColor()){                  
                    moves.add(b.getSquareArray()[start.getRow()][start.getCol()+2]);
                   }
                  }

                  if(start.getCol()-2>=0){
                    if (((b.getSquareArray()[start.getRow()][start.getCol()-2]).isOccupied() == false) || (b.getSquareArray()[start.getRow()][start.getCol()-2]).getOccupyingPiece().getColor()==!start.getColor() || b.getSquareArray()[start.getRow()][start.getCol()-2].getColor()!=start.getColor()){                  
                      moves.add(b.getSquareArray()[start.getRow()][start.getCol()-2]);
                     }
                  }

                  if(start.getRow()+2<8){
                    if (((b.getSquareArray()[start.getRow()+2][start.getCol()]).isOccupied() == false) || (b.getSquareArray()[start.getRow()+2][start.getCol()]).getOccupyingPiece().getColor()==!start.getColor() || b.getSquareArray()[start.getRow()+2][start.getCol()].getColor()!=start.getColor()){                  
                      moves.add(b.getSquareArray()[start.getRow()+2][start.getCol()]);
                     }
                  }

                  if(start.getRow()-2>=0){
                    if (((b.getSquareArray()[start.getRow()-2][start.getCol()]).isOccupied() == false) || (b.getSquareArray()[start.getRow()-2][start.getCol()]).getOccupyingPiece().getColor()==!start.getColor() || b.getSquareArray()[start.getRow()-2][start.getCol()].getColor()!=start.getColor()){                  
                      moves.add(b.getSquareArray()[start.getRow()-2][start.getCol()]);
                     }
                  }

             return moves;
      }     
    }