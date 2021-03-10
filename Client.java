//Kübra Dilara Balcı - 16290079

import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;

public class Client {

    public static void main(String args[]) throws UnknownHostException, IOException {
        int userNumber, result, randomNumber;
        boolean correct = true;

        Scanner keyboard = new Scanner(System.in);
        Socket s = new Socket("127.0.0.1", 1342);

        InputStream socketInput = s.getInputStream();
        BufferedReader bin = new BufferedReader(new InputStreamReader(socketInput));
        randomNumber = Integer.parseInt(bin.readLine());

        while (correct) {

            System.out.println("Enter a number between 1 and 10");
            userNumber = keyboard.nextInt();

            PrintWriter socketOutput = new PrintWriter(s.getOutputStream(), true);
            socketOutput.println(userNumber);
            result = Integer.parseInt(bin.readLine());

            if (result == 1) {
                System.out.println("TRUE");
                correct = false;
            } 

            else if (result == 2) {
                System.out.println("HIGHER");
            } 
            
            else if (result == 3) {
                System.out.println("LOWER");
            }

            if (result == 4) {
                System.out.println("WRONG");
                System.out.println("Random Number:"+randomNumber);
                correct = false;
            }
        }
        s.close();
    }
}