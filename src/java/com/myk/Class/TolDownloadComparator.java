/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.Class;

import com.entity.Materials;
import java.util.Comparator;

/**
 *
 * @author Michael
 */
public class TolDownloadComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Materials m1 = (Materials)o1;
        Materials m2 = (Materials)o2;
        if(m1.getMtoldownload() > m2.getMtoldownload()){
            return 1;
        }
        else if(m1.getMtoldownload() == m2.getMtoldownload()){
            return 0;
        }
        else return -1;
    }
}
