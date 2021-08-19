package edu.eci.cvds.patterns;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args)
    {
        if(args.length > 0){ 
            System.out.println( "Hello " + Arrays.toString(args).replace("[", "").replace("]", "").replace(",", "") + "!");
        }
        else{
            System.out.println( "Hello World!!");
        }
        
    }
}
