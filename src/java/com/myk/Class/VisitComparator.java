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
public class VisitComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Materials m1 = (Materials)o1;
        Materials m2 = (Materials)o2;
        if(m1.getMtolvisit() > m2.getMtolvisit()){
            return 1;
        }
        else if(m1.getMtolvisit() == m2.getMtolvisit()){
            return 0;
        }
        else return -1;
    }
}
