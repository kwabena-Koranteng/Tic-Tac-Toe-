import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Board{
  List<Coordinate> Free;
  String player1 = "X";
  String player2 = "O"; 
  Scanner scan = new Scanner(System.in);
  public String[][] Board = new String[3][3];
  
  public Board(){
    System.out.println("New board created");
  }
  
  public void play(Coordinate cod, int player){
    String turn="";
    if (player==1)
      turn=player1;
    else if (player==2)
      turn=player2;
    Board[cod.x][cod.y]=turn;
  }
  
  public void getFree(){
    Free = new ArrayList();
    for (int i=0; i<3; i++){
      for (int j=0; j<3; j++){
        if (Board[i][j]==null)
          Free.add(new Coordinate(i,j));
      }
    }
    System.out.println("The free coordinates are: "); 
    System.out.println(Free); 
  }
  public void Input(){
    System.out.println("Your turn");
    getFree();
    System.out.println("Which player are you (1 or 2)? ");
    int player = scan.nextInt();
    System.out.println("Where do you wish to play? ");
    System.out.println("Enter x coordinate: ");
    int x = scan.nextInt();
    System.out.println("Enter y coordinate: ");
    int y = scan.nextInt();
    Coordinate cod = new Coordinate(x,y);
    play(cod,player);
  }
  
  public void display(){
    for (int i=0; i<3; i++){
      for (int j=0; j<3; j++){
        System.out.print(Board[i][j]+" ");
      }
      System.out.println();
    }
  }
  
  public static void main(String[] args){
    Board b = new Board();
    b.Input();
    b.display();
    b.Input();
  }
}