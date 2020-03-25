package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 把通用的方法封装在这个类，如果需要用到这个类的方法，认他为父类即可
 * @author Administrator
 *
 */
public class BaseDao {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	Connection conn=null;//负责连接数据库
	PreparedStatement pstmt=null;//负责编译发送SQL命令到数据库
	ResultSet rs=null;//查询返回的结果集合

	//静态代码块作用：加载类的时候执行;
	static{
		init();
	}


	private static void init() {
		//创建Properties对象，加载database.properties文件的配置信息
		Properties pro=new Properties();
		InputStream is= BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			//加载database.properties配置文件
			pro.load(is);
			driver=pro.getProperty("jdbc.driver");
			url=pro.getProperty("jdbc.url");
			user=pro.getProperty("jdbc.user");
			password=pro.getProperty("jdbc.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		try {
			//加载驱动
			Class.forName(driver);
			//建立连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}





	/**
	 * 关闭数据库资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (pstmt!=null) {
				pstmt.close();
			}
			if (conn!=null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增删改通用方法
	 * @param sql
	 * @param param
	 * @return
	 */
	public int executeUpdate(String sql,Object[] param){
		int count=0;
		conn=this.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			if (param!=null) {
				for(int i=0;i<param.length;i++){
					pstmt.setObject((i+1),param[i]);
				}
			}
			count=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll(conn, pstmt, rs);
		}
		//返回受影响行数
		return count;
	}


}
