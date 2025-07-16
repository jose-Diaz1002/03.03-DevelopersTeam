// Interface InputReader.java
package org.escaperoom.input;

public interface InputReader {
    String readLine();
    int readInt(String prompt);
    default String readLine(String prompt) {
        System.out.print(prompt);
        return readLine();
    }


}
