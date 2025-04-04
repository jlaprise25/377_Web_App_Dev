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

public class aoc12Part1 {
    static int count = 0;
    static int hits = 0; 
    private static Map<String, Integer> cache = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try
        {
            cache.clear();
            InputStream stream =
                Quiz.class.getClassLoader().getResourceAsStream("input.csv");
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(stream));
            
            while (reader.ready())  
            {  
                String line = reader.readLine();
                // String left  = line.split(" ")[0];
                String[] right = line.split(" ")[1].split(",");

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

                count += findAllValid(valid, line);
            }
            reader.close();

            System.out.println(count + ", " + hits);
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

    public static int findAllValid(List<String> validSolution, String input)
    {
        if(cache.containsKey(input))
        {
            hits++;
            return cache.get(input);
        }
        

        int index = input.indexOf("?");
        if(index == -1)
        {
            String pattern = input.split(" ")[0];
            //validate
            List<String> hashesInPattern = new ArrayList<>(Arrays.asList(pattern.split("\\.")));            
            hashesInPattern.removeAll(Arrays.asList(""));

            if(hashesInPattern.equals(validSolution))
            {
                return 1;
            }
            
            return 0;
        }

        String dot = input.substring(0, index) + "." + input.substring(index+1);
        String hash = input.substring(0, index) + "#" + input.substring(index+1);

        int validDot = findAllValid(validSolution, dot);
        int validHash = findAllValid(validSolution, hash);
        
        cache.put(dot, validDot);
        cache.put(hash, validHash);

        int result = validDot + validHash;
        cache.put(input, result);

        return result;
    }
}