/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gtx;

import com.entity.Tag;

/**
 *
 * @author Administrator
 */
public class Tagdisplay 
{
    String tag;
    int tagid;
    Tag thetag;
    
    public Tagdisplay()
    {
        
    }
    
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public Tag getThetag() {
        return thetag;
    }

    public void setThetag(Tag thetag) {
        this.thetag = thetag;
        this.tag = thetag.getTag();
        this.tagid = thetag.getTagid();
    }
    
}
