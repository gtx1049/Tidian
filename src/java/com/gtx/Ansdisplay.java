/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

import com.entity.Answers;
import com.entity.Users;
import java.text.SimpleDateFormat;

/**
 *
 * @author Administrator
 */
public class Ansdisplay 
{
    private Users theuser;
    private Answers answers;
    private String content;
    private int score;
    private String date;
    private String respondent;
    private int ansID;
    
    public Ansdisplay()
    {
        
    }

    public String getRespondent() {
        return respondent;
    }

    public void setRespondent(String respondent) {
        this.respondent = respondent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Answers getAnswers() {
        return answers;
    }

    public void setAnswers(Answers answers) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        this.answers = answers;
        content = new String(this.answers.getContent());
        this.date = formatter.format(this.answers.getDate());
        this.score = this.answers.getPoint();
        this.ansID = this.answers.getAnwId();
    }

    public Users getTheuser() {
        return theuser;
    }

    public void setTheuser(Users theuser) {
        respondent = theuser.getNickname() + "(" + theuser.getUsrName() + ")";
        this.theuser = theuser;
    }

    public int getAnsID() {
        return ansID;
    }

    public void setAnsID(int ansID) {
        this.ansID = ansID;
    }
    
}
