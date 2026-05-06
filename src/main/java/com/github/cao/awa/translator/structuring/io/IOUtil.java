package com.github.cao.awa.translator.structuring.io;

import java.io.IOException;
import java.io.Reader;

public class IOUtil {
    /**
     * Read input.
     *
     * @param input Input
     * @throws IOException Happened IO error
     * @author cao_awa
     * @since 1.0.0
     */
    public static String read(Reader input) throws IOException {
        char[] chars = new char[4096];
        int length;
        StringBuilder builder = new StringBuilder();
        while ((length = input.read(chars)) != - 1) {
            builder.append(
                    chars,
                    0,
                    length
            );
        }
        input.close();
        return builder.toString();
    }
}
