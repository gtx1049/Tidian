<%-- 
    Document   : test
    Created on : 2012-4-19, 2:02:22
    Author     : Administrator
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.sql.*, javax.naming.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn=null;
PreparedStatement stmt=null;
ResultSet rs=null;

String sql=null;
String username=null;
String alias=null;
String pwd=null;
String strMsg=null;
try{
    Context cxt = new InitialContext();
    DataSource ds = (DataSource)cxt.lookup("java:/comp/env/jdbc/tidiandb");
    conn = ds.getConnection();
    sql="SELECT * from users";
    stmt=conn.prepareStatement(sql);
    rs=stmt.executeQuery(sql);
    if( rs.next() ){
        strMsg="连接ok";

        out.println("连接ok");
    }else{
        out.println("rs.next() fail");
    }
    rs.close();
    
} catch(Exception e){
    out.println("连接失败:"+e.getMessage());
    //e.printStackTrace();
}

try{
    if(stmt!=null) stmt.close();
}catch(Exception e){}

try{
    if(conn!=null) conn.close();
}catch(Exception e){}


%>
</body>
</html>

