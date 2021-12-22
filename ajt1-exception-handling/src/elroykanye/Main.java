package elroykanye;

import elroykanye.methods.TryCatch;

public class Main {
    public static void main(String[] args) {
        new TryCatch().divisionByZero();
    }

    /*
     * Note: To see examples used in this module, visit the 'examples' package.
     *
     * There are five keywords used for exception handling:
     *      try, catch, throw, throws and finally
     * In this mechanism, we place the vulnerable code in a block called a try block.
     * When an exception occurs during execution of the code in the try block, JVM creates an exception object and
     * declares something wrong has happened. The exception object contains useful info such as name of the thread, file
     * name, line of code at which exception occurred, name of exception and description.
     *
     * This process of creating an exception object and disclosing its info is known as 'throwing' the exception.
     *
     * After this, the JVM tries to find the code which wants to handle (resolve) the exceptional situation called the
     * handler. If found, it passes the newly created object to this handler (catching the exception). The handler is
     * specified by catch block immediately after the try block.
     */
}
