public class MultipleChoiceQuestion extends Question {
    private String[] choices;
    private int ansIndex;

    public MultipleChoiceQuestion(String prompt, String answer, String[] choices)
    {
        super(prompt, answer);
        this.choices = choices;

        ansIndex = ((int) (answer.toUpperCase().charAt(0))) - 65;
    }

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

    @Override
    public String getPrompt()
    {
        return super.getPrompt() + "\nA. " + choices[0] + "\nB. " + choices[1] + "\nC. " + choices[2] + "\nD. " + choices[3];
    }
    
}
