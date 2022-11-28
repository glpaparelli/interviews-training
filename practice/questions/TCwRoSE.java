package questions;
/*
 * > QUESTION: what happens if we use > Try-Catch with Return or System.exit < ?
 *   What happens when we have a return or a System.exit() inside 
 *   the try or the catch block? Will the finally will be executed?
 * 
 * > SOLUTION: 
 *   The finally is alsways executed when we have return statements inside the 
 *   try/catch, it will never be executed if inside the try/catch we have System.exit()
 * 
 *   > The finally block will always execute, with or without an exception. 
 *     The only cases where the finally block is not executed is by System.exit, 
 *     jvm crash, power faliure, ... 
 *  
 *   > the System.exit() exit the current program by TERMINATING the JVM, so it is 
 *     normal that everything after is not executed*   
 */
public class TCwRoSE {
    public final String string = "hello";

    public static void main(String[] args) {
        TCwRoSE test = new TCwRoSE();

        test.returnInTry();
        test.returnInCatch();

        test.exitInTry();
        test.exitInCatch();
    }

    public void returnInTry(){
        try{
            return;
        }catch(StringIndexOutOfBoundsException e){
        }finally{
            // this will be printed despite the return in the try!
            System.out.println("[finally] despite return in try");
        }
    }

    public void returnInCatch(){
        try{
            System.out.println(this.string.charAt(1000));
        }catch(StringIndexOutOfBoundsException e){
            return;
        }finally{
            // this will be printed despite the return in the catch
            System.out.println("[finally] despite return in cath");
        }
    }

    public void exitInTry(){
        try{
            System.exit(0);
        }catch(StringIndexOutOfBoundsException e){
            
        }finally{
            // this will not be printed because the exit in try
            System.out.println("exit in try, never printed");
        }
    }

    public void exitInCatch(){
        try{
            System.out.println(this.string.charAt(1000));
        }catch(StringIndexOutOfBoundsException e){
            System.exit(0);
        }finally{
            // this will not be printed because the exit in try
            System.out.println("exit in catch, never printed");
        }
    }

}
