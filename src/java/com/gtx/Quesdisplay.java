/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

import com.entity.Questions;
import com.entity.Users;
import java.text.SimpleDateFormat;

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
    private int quesID;
    
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
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.question = question;
        this.content = new String(question.getContent());
        this.date = formatter.format(this.question.getDate());
        this.quesID = this.question.getQueId();
        switch(this.question.getPoint() / 10)
        {
            case 0:
                level = "铁皮";
                break;
            case 1:
                level = "青铜";
                break;
            case 2:
                level = "白银";
                break;
            case 3:
                level = "黄金";
                break;
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

    public int getQuesID() {
        return quesID;
    }

    public void setQuesID(int quesID) {
        this.quesID = quesID;
    }
    
    
    
}
