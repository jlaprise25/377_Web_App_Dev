public class MultipleChoiceQuestion extends Question {
    private String[] choices;
    private int ansIndex;

    // Constructs a MultipleChoiceQuestion with the given prompt, answer, and choices.
    public MultipleChoiceQuestion(String prompt, String answer, String[] choices)
    {
        super(prompt, answer);
        this.choices = choices;

        ansIndex = ((int) (answer.toUpperCase().charAt(0))) - 65;
    }

    /**
     * Checks if the user's answer matches this MultipleChoiceQuestion's expected answer. 
     * This method will consider either the letter of the choice to be correct 
     * OR the actual text of the response (both checks are case-insensitive).
     * For example, if the correct answer is C and the choices are:
     * A. Do
     * B. Re
     * C. Mi
     * Then both "C" and "Mi" (and any variation of upper/lower case for either) would be considered valid responses.
     */
    @Override
    public boolean checkAnswer(String ans)
    {
        String upAns = ans.toUpperCase();

        if(upAns.equals(getAnswer().toUpperCase()) || upAns.equals(choices[ansIndex]))
        {
            return true;
        }

        return false;
    }

    // Returns the prompt for this MultipleChoiceQuestion followed by the list of choices.
    @Override
    public String getPrompt()
    {
        return super.getPrompt() + "\nA. " + choices[0] + "\nB. " + choices[1] + "\nC. " + choices[2] + "\nD. " + choices[3];
    }
    
}
