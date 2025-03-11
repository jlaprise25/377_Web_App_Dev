public class Question {
    private String prompt;
    private String answer;

    public Question(String prompt, String answer)
    {
        this.prompt = prompt;
        this.answer = answer;
    }

    public String getPrompt()
    {
        return prompt;
    }

    public String getAnswer()
    {
        return answer;
    }

    public boolean checkAnswer(String answer)
    {
        if(answer.toUpperCase().equals(this.answer.toUpperCase()))
        {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return getPrompt();
    }

}
