/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reformatstring;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Vlad
 */
public class Console {
    static void WriteLine(Object obj) {
    System.out.println(obj);
    }

    static void Write(Object obj) {
        System.out.print(obj);
    }

    static String ReadLine() {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        s.close();
        return input;
    }

    static char Read() {
        Scanner s = new Scanner(System.in);
        char input = s.next().charAt(0);
        return input;
    }

    static InputStream In() {
        return System.in;
    }

    static PrintStream Out() {
        return System.out;
    }
}
