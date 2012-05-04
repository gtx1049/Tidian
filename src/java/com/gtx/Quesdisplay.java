/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

/**
 *
 * @author Administrator
 */
public class Quesdisplay 
{
    private Users theuser;
    private Questions question;
    private String content;
    private String level;
    private String date;
    private String asker;
    
    public Quesdisplay()
    {
        
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Questions getQuestion() {
        return question;
    }

    public void setQuestion(Questions question) {
        this.question = question;
        this.content = new String(question.getContent());
        this.date = this.question.getDate().toString();
        switch(this.question.getPoint() / 10)
        {
            case 0:
                level = "铁皮";
                break;
            case 1:
                level = "青铜";
            case 2:
                level = "白银";
            case 3:
                level = "黄金";
        }
    }

    public Users getTheuser() {
        return theuser;
    }

    public void setTheuser(Users theuser) {
        asker = theuser.getNickname() + "(" + theuser.getUsrName() + ")";
        this.theuser = theuser;
    }

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
