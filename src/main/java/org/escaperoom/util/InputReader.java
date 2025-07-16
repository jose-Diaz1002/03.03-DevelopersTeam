// Interface InputReader.java
package org.escaperoom.util;

import java.math.BigDecimal;

public interface InputReader {

    int readInt(String prompt);
    String readLine(String prompt);
    BigDecimal readBigDecimal(String prompt);
    boolean readBoolean(String prompt);

}
