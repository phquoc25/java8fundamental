/**
 *
 * Copyright (C) 2018 Deveryware S.A. All Rights Reserved.
 *
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Quoc PHAN on 05/02/2018.
 */
public class StreamAPITest {
    public static void main(String[] args) throws IOException
    {
        String contents = null; // Read file into string
        contents = new String(Files.readAllBytes(
                Paths.get("alice.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));
        // Split into words; nonletters are delimiters
        int count = countLongWordsJ8(words);
        System.out.println("Number of long words: " + count);
    }

    private static int countLongWords(List<String> words)
    {
        int count = 0;
        for (String w : words) {
            if (w.length() > 10) count++;
        }
        return count;
    }

    private static int countLongWordsJ8(List<String> words)
    {
        return (int) words.stream().filter(word -> word.length() > 10).count();
    }
}
