import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class aoc12Part2 {
    private static int count = 0;
    private static Map<String, Integer> cache = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try
        {
            InputStream stream =
                Quiz.class.getClassLoader().getResourceAsStream("testInput.csv");
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(stream));
            
            while (reader.ready())  
            {  
                String line = reader.readLine();
                String foldedLeft  = line.split(" ")[0];
                List<String> foldedRight = new ArrayList<String>(Arrays.asList(line.split(" ")[1].split(",")));

                // Unfold left
                String left = "";
                for(int i = 0; i < 4; i++)
                {
                    left = left + foldedLeft + "?";
                }
                left = left + foldedLeft;

                // Unfold right
                ArrayList<String> right = new ArrayList<String>();
                for(int i = 0; i < 5; i++)
                {
                    right.addAll(foldedRight);
                }

                List<String> valid = new ArrayList<String>();
                for(String num : right)
                {
                    String hastags = "";
                    for(int i = 0; i < Integer.parseInt(num); i++)
                    {
                        hastags = hastags + "#";
                    }
                    valid.add(hastags);
                }

                count += findAllValid(left, valid);
            }
            reader.close();

            System.out.println(count);
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File not found: " + fnfe.getMessage());
        }
        catch (IOException ioe)
        {
            System.out.println("Error reading line: " + ioe.getMessage());
        }
    }

    public static int findAllValid(String input, List<String> validSolution)
    {
        if(cache.containsKey(input))
        {
            return cache.get(input);
        }

        int index = input.indexOf("?");
        if(index == -1)
        {
            //validate
            List<String> hashesInInput = new ArrayList<>(Arrays.asList(input.split("\\.")));            
            hashesInInput.removeAll(Arrays.asList(""));

            if(hashesInInput.equals(validSolution))
            {
                return 1;
            }
            
            return 0;
        }

        String dot = input.substring(0, index) + "." + input.substring(index+1);
        String hash = input.substring(0, index) + "#" + input.substring(index+1);

        int validDot = findAllValid(dot, validSolution);
        int validHash = findAllValid(hash, validSolution);
        
        cache.put(dot, validDot);
        cache.put(hash, validHash);

        return cache.get(dot) + cache.get(hash);
    }
}