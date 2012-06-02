/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myk.Class;

import com.entity.Collect;
import com.entity.Mark;
import com.entity.Materials;
import com.myk.Constants.MyStatus;
import com.myk.JPAEntityControllers.CollectJpaController;
import com.myk.JPAEntityControllers.MarkJpaController;
import com.myk.JPAEntityControllers.MaterialsJpaController;
import com.myk.JPAEntityControllers.UsersJpaController;
import com.myk.JPAEntityControllers.exceptions.PreexistingEntityException;
import com.myk.JPAEntityControllers.exceptions.RollbackFailureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author Michael
 */
public class MaterialFunction {
    private String name = null;
    private String password = null;
    UserTransaction ut;
    EntityManagerFactory emf;
    
    //类的构造函数
    public MaterialFunction(UserTransaction ut, EntityManagerFactory emf) {
        this.ut = ut;
        this.emf = emf;
    }
    
    //类的构造函数
    public MaterialFunction(String name, String password, UserTransaction ut, EntityManagerFactory emf) {
        this.ut = ut;
        this.emf = emf;
        this.name = name;
        this.password = password;
    }
    
    //得到类里存储的用户名
    public String getName() {
        return name;
    }
    
    //更改类里存储的用户名
    public void setName(String name) {
        this.name = name;
    }
    
    //得到类里存储的密码
    public String getPassword() {
        return password;
    }

    //更改类里存储的密码
    public void setPassword(String password) {
        this.password = password;
    }
    
    //生成一个在materials表里生成一个资料
    public boolean createMaterial(Materials material){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        for(int i = 1; i <= ujc.getUsersCount(); i++){
            if(material != null && ujc.findUsers(i).getUsrName().equals(name) && ujc.findUsers(i).getPassword().equals(password)){
                try {
                    mjc.create(material);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }
    
    //生成一个在materials表里生成一个资料
    public boolean createMaterial(String mname, String mintroduction, String mpath, String msize, String mtype, String msubject, String mgrade, String mregion){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        if(mname == null || mintroduction == null || mtype == null || msubject == null || mgrade == null || mregion == null){
            return false;
        }
        for(int i = 1; i <= ujc.getUsersCount(); i++){
            if(ujc.findUsers(i).getUsrName().equals(name) && ujc.findUsers(i).getPassword().equals(password)){
                Materials m = new Materials();
                m.setMaterialId(mjc.getMaterialsCount() + 1);
                m.setMcreatedate(new Date());
                m.setMgrade(mgrade);
                m.setMintroduction(mintroduction);
                m.setMlevelamount(0);
                m.setMmarknumber(0);
                m.setMname(mname);
                m.setMpath(mpath);
                m.setMsize(msize);
                m.setMstatus(MyStatus.ON);
                m.setMsubject(msubject);
                m.setMtolcollect(0);
                m.setMtolcomment(0);
                m.setMtoldownload(0);
                m.setMtolvisit(0);
                m.setMtype(mtype);
                m.setMweekdownload(0);
                m.setUsrId(i);
                try {
                    mjc.create(m);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }

    //收藏指定的资料
    public boolean collect (int material_id){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        CollectJpaController cjc = new CollectJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        boolean materialIdExist = false;
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMaterialId() == material_id){
                materialIdExist = true;
                break;
            }
        }
        if(!materialIdExist){
            return false;
        }
        for(int j = 1; j <= ujc.getUsersCount(); j++){
            if(ujc.findUsers(j).getUsrName().equals(name) && ujc.findUsers(j).getPassword().equals(password)){
                for(int k = 1; k <= cjc.getCollectCount() + 1; k++){
                    if(cjc.findCollect(k).getMaterialId() == material_id && cjc.findCollect(k).getUsrId() == j){
                        return false;
                    }
                }
            }
        }
        for(int k = 1; k <= ujc.getUsersCount(); k++){
            if(ujc.findUsers(k).getUsrName().equals(name) && ujc.findUsers(k).getPassword().equals(password)){
                Collect collect = new Collect();
                collect.setCollectId(cjc.getCollectCount() + 1);
                collect.setMaterialId(material_id);
                collect.setUsrId(k);
                try {
                    cjc.create(collect);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                }
                return true;
            }
        }
        return false;
    }
    
    //判断是否已经收藏
    public boolean isCollected (int material_id){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        CollectJpaController cjc = new CollectJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        boolean materialIdExist = false;
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMaterialId() == material_id){
                materialIdExist = true;
                break;
            }
        }
        if(!materialIdExist){
            return false;
        }
        for(int j = 1; j <= ujc.getUsersCount(); j++){
            if(ujc.findUsers(j).getUsrName().equals(name) && ujc.findUsers(j).getPassword().equals(password)){
                for(int k = 1; k <= cjc.getCollectCount() + 1; k++){
                    if(cjc.findCollect(k).getMaterialId() == material_id && cjc.findCollect(k).getUsrId() == j){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //判断是否打分
    public boolean idMarked(int material_id){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        MarkJpaController mkjc = new MarkJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        boolean materialIdExist = false;
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMaterialId() == material_id){
                materialIdExist = true;
                break;
            }
        }
        if(!materialIdExist){
            return false;
        }
        for(int j = 1; j <= ujc.getUsersCount(); j++){
            if(ujc.findUsers(j).getUsrName().equals(name) && ujc.findUsers(j).getPassword().equals(password)){
                for(int k = 1; k <= mkjc.getMarkCount() + 1; k++){
                    if(mkjc.findMark(k).getMaterialId() == material_id && mkjc.findMark(k).getUsrId() == j){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    //打分
    public boolean mark(int material_id, int level){
        if(name == null || password == null){
            return false;
        }
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        MarkJpaController mkjc = new MarkJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        boolean materialIdExist = false;
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMaterialId() == material_id){
                materialIdExist = true;
                break;
            }
        }
        if(!materialIdExist){
            return false;
        }
        for(int j = 1; j <= ujc.getUsersCount(); j++){
            if(ujc.findUsers(j).getUsrName().equals(name) && ujc.findUsers(j).getPassword().equals(password)){
                for(int k = 1; k <= mkjc.getMarkCount() + 1; k++){
                    if(mkjc.findMark(k).getMaterialId() == material_id && mkjc.findMark(k).getUsrId() == j){
                        return false;
                    }
                }
            }
        }
        for(int k = 1; k <= mkjc.getMarkCount(); k++){
            if(ujc.findUsers(k).getUsrName().equals(name) && ujc.findUsers(k).getPassword().equals(password)){
                Mark mark = new Mark();
                mark.setMarkId(mkjc.getMarkCount() + 1);
                mark.setMaterialId(material_id);
                mark.setUsrId(k);
                try {
                    mkjc.create(mark);
                } catch (PreexistingEntityException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(MaterialFunction.class.getName()).log(Level.SEVERE, null, ex);
                }
                mjc.findMaterials(material_id).setMmarknumber(mjc.findMaterials(k).getMmarknumber() + 1);
                mjc.findMaterials(material_id).setMlevelamount(level + mjc.findMaterials(k).getMlevelamount());
                return true;
            }
        }
        return false;
    }
    
    //得到一个资料的平均打分
    public double getMaterialAvgLevel(int material_id){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        MarkJpaController mkjc = new MarkJpaController(ut, emf);
        UsersJpaController ujc = new UsersJpaController(ut, emf);
        boolean materialIdExist = false;
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMaterialId() == material_id){
                materialIdExist = true;
                break;
            }
        }
        if(!materialIdExist){
            return -1;
        }
        double levelamount = mjc.findMaterials(material_id).getMlevelamount();         
        return levelamount / mjc.findMaterials(material_id).getMmarknumber();
    }
    
    public ArrayList<Materials> getArrayListBySubject(String subject){
        ArrayList<Materials> list = new ArrayList<Materials>();
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        for(int i = 1; i <= mjc.getMaterialsCount() && i < 9; i++){
            if(mjc.findMaterials(i).getMsubject().equals(subject)){
                list.add(mjc.findMaterials(i));
            }
        }
        return list;
    }
    
    //得到一个某个年级的所有的资料
    public ArrayList<Materials> getArrayListByGrade(String grade){
        ArrayList<Materials> list = new ArrayList<Materials>();
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMgrade().equals(grade)){
                list.add(mjc.findMaterials(i));
            }
        }
        return list;
    }
    
    //得到某个地区的所有的资料
    public ArrayList<Materials> getArrayListByRegion(String region){
        ArrayList<Materials> list = new ArrayList<Materials>();
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        for(int i = 1; i <= mjc.getMaterialsCount(); i++){
            if(mjc.findMaterials(i).getMregion().equals(region)){
                list.add(mjc.findMaterials(i));
            }
        }
        return list;
    }
    
    //得到按下总载量排名的资料表
    public List<Materials> getListSortedByTolDownload(){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        List<Materials> list = mjc.findMaterialsEntities();
        Collections.sort(list, new TolDownloadComparator());
        return list;          
    }
    
    //得到按周下载量排名的资料表
    public List<Materials> getListSortedByWeekDownload(){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        List<Materials> list = mjc.findMaterialsEntities();
        Collections.sort(list, new WeekDownloadComparator());
        return list;          
    }
    
    //得到按收藏量排名的资料表
    public List<Materials> getListSortedByCollect(){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        List<Materials> list = mjc.findMaterialsEntities();
        Collections.sort(list, new CollectComparator());
        return list;          
    }
    
    //得到按总访问量排名的资料表
    public List<Materials> getListSortedByVisit(){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        List<Materials> list = mjc.findMaterialsEntities();
        Collections.sort(list, new VisitComparator());
        return list;          
    }
    
    //把所有资料的周访问量归零
    public void clearWeekDownload(){
        MaterialsJpaController mjc = new MaterialsJpaController(ut, emf);
        for(int i = 1; i <=mjc.getMaterialsCount(); i++){
            mjc.findMaterials(i).setMweekdownload(0);
        }
    }
}
