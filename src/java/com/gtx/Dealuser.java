/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class Dealuser 
{
    private HttpSession usersession;
    public Dealuser(HttpSession usersession)
    {
        this.usersession = usersession;
    }
    public int judgeUser()
    {
        return 1;
    }
}
