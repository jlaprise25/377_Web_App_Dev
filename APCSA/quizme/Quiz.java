import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Quiz {
    private List<Question> questions = new ArrayList<>();

    // Creates a Quiz object from a local CSV resource named questions.csv and runs the quiz.
    public static void main(String[] args) {
        Quiz q = new Quiz("questions.csv");
        q.run();
    }

    // Constructs a Quiz with questions loaded from the given CSV file.
    public Quiz(String csvName)
    {
        try
        {
            InputStream stream =
                Quiz.class.getClassLoader().getResourceAsStream(csvName);
            BufferedReader reader =
                new BufferedReader(new InputStreamReader(stream));
            
            while (reader.ready())  
            {  
                String line = reader.readLine();
                String[] elements = line.split(",");

                if(elements[0].equals("FR"))
                {
                    questions.add(new Question(elements[1], elements[2]));
                }
                else if (elements[0].equals("MC")) 
                {
                    String[] choices = new String[elements.length - 3];
                    for(int i = 3; i < elements.length; i++)
                    {
                        choices[i-3] = elements[i];
                    }

                    questions.add(new MultipleChoiceQuestion(elements[1], elements[2], choices));
                }
                else
                {
                    questions.add(new TrueFalseQuestion(elements[1], Boolean.parseBoolean(elements[2])));
                }
            }
            reader.close();
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

    // Runs the quiz by asking each question and checking whether the user's response is correct. 
    // The order of the questions will be shuffled every time the quiz is run.
    public void run()
    {
        double numCorrect = 0;

        Collections.shuffle(questions);
        
        Scanner input = new Scanner(System.in);

        System.out.println("=======================\n \"Quiz Me\" Test Review  \n=======================");

        for(int i = 0; i < questions.size(); i++)
        {
            System.out.println("Question #" + (i + 1) + "\n------------\n" + questions.get(i).getPrompt());
            String answer = input.nextLine();

            if(questions.get(i).checkAnswer(answer))
            {
                System.out.println("Correct!");
                System.out.println();
                numCorrect++;
            }
            else
            {
                System.out.println("Incorrect");
                System.out.println();
            }
        }
        
        input.close();

        System.out.println("Your score: " + ((int) (numCorrect/questions.size() * 100)) + "%");
    }
}
