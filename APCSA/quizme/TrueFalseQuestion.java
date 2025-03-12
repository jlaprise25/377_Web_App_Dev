public class TrueFalseQuestion extends Question {
    //Constructs a TrueFalseQuestion with the given prompt and answer.
    public TrueFalseQuestion(String prompt, boolean answer)
    {
        super(prompt, Boolean.toString(answer));
    }

    /** 
    * Checks if the user's answer matches this TrueFalseQuestion's expected answer. 
    * This method will consider any of the following values (case-insensitive) to be true:
    * T
    * True
    * Y
    * Yes
    * All other values will be considered false.
    */
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

    // Returns the prompt for this Question prefixed with the text: "True or false: ".
    @Override
    public String getPrompt()
    {
        return "True or False: " + super.getPrompt();
    }
}