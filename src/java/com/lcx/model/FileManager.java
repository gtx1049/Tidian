/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lcx.model;


import com.entity.Users;
import com.sun.xml.internal.ws.client.RequestContext;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;


/**
 *
 * @author Administrator
 */
public class FileManager {
    public synchronized void upLoad(HttpServletRequest request, EntityManager entityManager,UserTransaction userTransaction) throws UnsupportedEncodingException, NamingException, SQLException{
        ServletRequestContext requestContext = new ServletRequestContext(request);
        
        if (FileUpload.isMultipartContent(requestContext)) {  
            
            DiskFileItemFactory factory = new DiskFileItemFactory();
           
             ServletContext s1=request.getServletContext(); 
             String path=s1.getRealPath("/");
             path +="resource/";
             path = path.replaceAll("\\\\", "/");
             System.out.println(path);
            Users user = (Users)(request.getSession().getAttribute("user"));
            String username = user.getUsrName();
            String _username = username;
            String value = "resource/" + username;
            user.setPortrait(value);
            factory.setRepository(new File(path));  
            ServletFileUpload upload = new ServletFileUpload(factory);  
             upload.setHeaderEncoding("gbk");  
            upload.setSizeMax(2000000);  
            List items = new ArrayList();  
            try {  
                items = upload.parseRequest(request);  
            } catch (FileUploadException e1) {  
                System.out.println("文件上传发生错误" + e1.getMessage());  
            }  
  
            Iterator it = items.iterator();  
            while (it.hasNext()) {  
                FileItem fileItem = (FileItem) it.next();  
                if (fileItem.isFormField()) {  
                    System.out.println(fileItem.getFieldName()  
                            + " "  
                            + fileItem.getName()  
                            + " "  
                            + new String(fileItem.getString().getBytes(  
                                    "iso8859-1"), "gbk"));  
                } else {  
                    System.out.println(fileItem.getFieldName() + " "  
                            + fileItem.getName() + " " + fileItem.isInMemory()  
                            + " " + fileItem.getContentType() + " "  
                            + fileItem.getSize());  
  
                    if (fileItem.getName() != null && fileItem.getSize() != 0) {  
                        File fullFile = new File(fileItem.getName());
                        String suffix = fullFile.getName();
                        int count = 0;
                        boolean flag = false;
                        for(int i = suffix.length()-1; i >0; i--){
                            if(suffix.charAt(i) == '.'){
                                break;
                            }
                            else{
                                count++;
                            }
                        }
                        suffix = suffix.substring(suffix.length() - count-1, suffix.length());
                        username += suffix;
                        value += suffix;
                        System.out.println(value);
                        File newFile = new File(path + username);
                        Users olduser= new Users();
                        try {  
                            fileItem.write(newFile);
                            userTransaction.begin();
                            olduser = entityManager.find(Users.class, user.getUsrId());
                            olduser.setPortrait(value);
                            entityManager.merge(olduser);
                            userTransaction.commit();
                            
                        } catch (Exception e) {  
                            e.printStackTrace();
                            
                        }  
                    } else {  
                        System.out.println("文件没有选择 或 文件内容为空");  
                    }  
                }  
  
            }  
        }
    }
}
