import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
// import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class aoc12 {
    static int count = 0;
    public static void main(String[] args) {
        try
        {
            InputStream stream =
                Quiz.class.getClassLoader().getResourceAsStream("input.csv");
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(stream));
            
            while (reader.ready())  
            {  
                String line = reader.readLine();
                String left  = line.split(" ")[0];
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

                findAllValid(left, valid);
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

    public static void findAllValid(String input, List<String> validSolution)
    {
        int index = input.indexOf("?");
        if(index == -1)
        {
            //validate
            List<String> hashesInInput = new ArrayList<>(Arrays.asList(input.split("\\.")));            
            hashesInInput.removeAll(Arrays.asList(""));

            if(hashesInInput.equals(validSolution))
            {
                count++;
            }
            
            return;
        }

        String dot = input.substring(0, index) + "." + input.substring(index+1);
        findAllValid(dot, validSolution);

        String hash = input.substring(0, index) + "#" + input.substring(index+1);
        findAllValid(hash, validSolution);

    }
}
