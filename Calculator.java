import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;

import javax.swing.JOptionPane;

public class Calculator {
    public static void main(String[] args){

        Object[] options = {"Calculator", "Pascal triangle", "Give me a cookie", "Study Hours", "Sleep calculator"};
        String input;
        int n = JOptionPane.showOptionDialog(null, "What would you like to calculate?", 
        "JarWise", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
        System.out.println("Option number "+n);
        switch (n) {
            case 0: 
                input = JOptionPane.showInputDialog(null, "Equation: ", "Calculator.exe", JOptionPane.QUESTION_MESSAGE);
                calculate(input);
                break;
            case 1:
                //input = JOptionPane.showInputDialog(null, "Number of layers ", "Pascal.exe", JOptionPane.QUESTION_MESSAGE);
                //int x = input;
                Scanner scany = new Scanner(System.in);
                int x = scany.nextInt();
                pascal(x);
                break;
            case 2: 
                JOptionPane.showMessageDialog(null, "A Cookie", "CookieGiver.exe", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 3: 
                JOptionPane.showMessageDialog(null, "Option 4", "Virus.exe", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 4:
                JOptionPane.showMessageDialog(null, "Option 5", "Virus.exe", JOptionPane.INFORMATION_MESSAGE);
                break;
            default: break;
        }
    }

    public static void calculate(String text){
        long x = 0, y = 0, v=1;
        char b = '+';
        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c<='9' && c>='0'){
                x *= 10;
                x += (c-'0');
            }
            if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^' || c=='%'){ b = c; y = x; x = 0;}
            else {if(c>'9' && c<'0'){System.out.println("Probably some error, anyway I have this: "+x);}}
        }
        switch(b){
            case '+': v = y + x; break;
            case '-': v = y - x; break;
            case '*': v = y * x; break;
            case '/': v = y / x; break;
            case '%': v = y % x; break;
            case '^': for(int i=0; i<x; i++){ v *= y;} break;
        }
        System.out.println(y+""+b+""+x+" = "+v+"\n");
        JOptionPane.showMessageDialog(null, y+""+b+""+x+" = "+v, "Calculator.exe", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void pascal(int x){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list);
        for(int i=1; i<x; i++){
            int prev = 1;
            for(int j=1; j<list.size(); j++){
                list.set(j, (prev + list.get(j)));
                prev = list.get(j) - prev;
            }
            list.add(1);
            System.out.println(list);
        }
    }
}
