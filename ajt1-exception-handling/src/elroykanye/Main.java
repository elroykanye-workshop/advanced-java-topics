package elroykanye;


import elroykanye.examples.Finally;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Finally().readFile();
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }

    /* A) Intro
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

    /*
     * B) Types of Exceptions
     *
     * At the top of the exception class hierarchy is the Throwable class. Under the Throwable, are two classes called
     * Exception and Error.
     *
     * The Error class represents serious scenarios that apps can neither expect nor recover from. Examples are memory,
     * stack overflow, class format, no definition found etc.
     *
     * The Exception class represents the rest of the exceptional cases that apps can catch and handle.
     * Exceptions are usually categorized into 2 groups: Checked and Unchecked
     *
     * Checked exceptions are those that must be caught or declared to be thrown. Java considers Throwable and any of
     * its subclass that is not also a subclass of either RuntimeException or Error as checked Exceptions. These
     * exceptions should be handled in the code to avoid compile time errors.
     *
     * Unchecked exceptions are those which need not be caught or declared to be thrown explicitly.
     */

    /*
     * C) Catching Exceptions
     *
     * Java exceptions are organised into a hierarchy. The advantage of this arrangement is that if we write a catch
     * to catch a certain exception in the hierarchy, then it can also catch all subclasses of that exception too.
     */

    /*
     * D) Stack Tracing
     *
     * The Throwable class and all inheriting classes of this class have very useful methods to collect detailed
     * information about an exception.
     * One of such is the e.printStackTrace() methods (where 'e' is the Throwable object) prints a stack trace of the
     * current throwable, e.
     */

    /*
     * E) Throwing
     *
     * a) Throw: Also, it is possible to explicitly throw an exception using the 'throw' keyword. Check the throwing
     * method in the methods package.
     *
     * b) Throws: A method must specify the list of checked exceptions that it might (directly/indirectly) raise but
     * does not handle them using 'throws' clause. This specification enables callers of the method either to guard
     * themselves by using appropriate try-catch blocks or to re-declare it.
     */

    /*
     * F) Finally
     *
     * This is a block used together with the try block to include some piece of code that should be executed regardless
     * of the state of execution of the code in the try or catch blocks. Operations that can be performed here include
     * closing a database connection, removing the reference to a file, etc.
     */
}
