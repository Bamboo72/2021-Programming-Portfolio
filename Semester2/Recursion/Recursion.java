// Jacob Schwartz - 3/9/2021

public class Recursion{

  static public int traditionalFactorialLoop(int n){
    for(int i = n-1; i > 1; i--){
       n = n * i;
    }
    return n;
  }

  static public int recursiveFactorialLoop(int n){
    if(n == 1) {
      return 1;
    } else {
      return n * recursiveFactorialLoop(n-1);
    }
  }

  static public int traditionalFibonacciLoop(int n){
    int firstNum = 1;
    int secondNum = 1;
    int placeholder = 1;
    for(int i = n-1; i > 1; i--){
      placeholder = secondNum;
      secondNum = firstNum + secondNum;
      firstNum = placeholder;
    }
    return secondNum;
  }

  static public int recursiveFibonacciLoop(int n){
    if(n == 0){
      return 0;
    } else if(n == 1) {
      return 1;
    } else {
      return recursiveFibonacciLoop(n-1) + recursiveFibonacciLoop(n-2);
    }
  }

  public static void main(String[] args){
   System.out.println(traditionalFactorialLoop(12));
   System.out.println(recursiveFactorialLoop(12));
  //  System.out.println(traditionalFibonacciLoop(46));
  //  System.out.println(recursiveFibonacciLoop(46));
  }

}
