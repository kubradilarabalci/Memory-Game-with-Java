

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
import java.io.*;

public class Server {
    public static void main(String args[]) throws IOException {
        boolean correcto = true;
        Random rand = new Random();
        int userNumber, result, randomNumber, counter = 0;

        randomNumber = rand.nextInt(10) + 1;
        ServerSocket s1 = new ServerSocket(1342);
        Socket ss = s1.accept();

        PrintWriter socketOutput = new PrintWriter(ss.getOutputStream(), true);
        socketOutput.println(randomNumber);

        Scanner sc = new Scanner(ss.getInputStream());

        while (correcto) {
            InputStream in = ss.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            userNumber = Integer.parseInt(bin.readLine());
           
            if (counter == 2 && userNumber != randomNumber) {
                result = 4;
                socketOutput.println(result);
                System.out.println("User's Number:"+userNumber);
                System.out.println("WRONG");
                System.out.println("Random Number:"+randomNumber);
                correcto = false;   
            }

            if (userNumber == randomNumber) {
                result = 1;
                socketOutput.println(result);
                System.out.println("User's Number:"+userNumber);
                System.out.println("Random Number:"+randomNumber);
                System.out.println("TRUE");
                correcto = false;
            }
            
            else if (userNumber > randomNumber) {
                result = 3;
                counter++;
                socketOutput.println(result);
                if(counter < 3){
                    System.out.println("User's Number:"+userNumber);
                    System.out.println("Random Number:"+randomNumber);
                }
                System.out.println("LOWER");
            }
            
            else if (userNumber < randomNumber) {
                result = 2;
                counter++;
                socketOutput.println(result);
                if(counter < 3){
                    System.out.println("User's Number:"+userNumber);
                    System.out.println("Random Number:"+randomNumber);
                }
                System.out.println("HIGHER");
            }
        }
        ss.close();

    }
}
