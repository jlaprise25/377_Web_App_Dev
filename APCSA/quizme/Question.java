public class Question {
    private String prompt;
    private String answer;

    // Constructs a Question with the given prompt and answer.
    public Question(String prompt, String answer)
    {
        this.prompt = prompt;
        this.answer = answer;
    }

    //Returns the prompt for this Question.
    public String getPrompt()
    {
        return prompt;
    }

    // Returns the answer for this Question.
    public String getAnswer()
    {
        return answer;
    }

    // Checks if the user's answer matches this Question's expected answer, ignoring case.
    public boolean checkAnswer(String answer)
    {
        if(answer.toUpperCase().equals(this.answer.toUpperCase()))
        {
            return true;
        }
        return false;
    }

    // Returns the String representation of this Question.
    public String toString()
    {
        return getPrompt();
    }

}
