package com.tigerit.exam;


import com.tigerit.exam.io.InputReader;
import com.tigerit.exam.work.Solver;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader inputReader = new InputReader(System.in);
        new Solver().solve(inputReader);
    }
}
