public class TrueFalseQuestion extends Question {

    public TrueFalseQuestion(String prompt, boolean answer)
    {
        super(prompt, Boolean.toString(answer));
    }


    @Override
    public boolean checkAnswer(String answer)
    {
        String upAns = answer.toUpperCase();

        if(upAns.equals("TRUE") || upAns.equals("T") || upAns.equals("YES") || upAns.equals("Y"))
        {
            if(Boolean.parseBoolean(getAnswer()) == true)
            {
                return true;
            }
            
            return false;
        } 
        else
        {
            if(Boolean.parseBoolean(getAnswer()) == false)
            {
                return true;
            }

            return false;
        }
    }

    @Override
    public String getPrompt()
    {
        return "True or False: " + super.getPrompt();
    }
}

