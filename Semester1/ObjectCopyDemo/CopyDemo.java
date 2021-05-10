import java.awt.Rectangle;
public class CopyDemo {
  public static void main(String[] args){
  Rectangle box = new Rectangle(5, 10, 20, 30);
  Rectangle box2 = box;

  System.out.println("box: " + box);
  System.out.println("box2: " + box2);

  box2.translate(15, 15);

  System.out.println("box: " + box);
  System.out.println("box2: " + box2);

  }
}
