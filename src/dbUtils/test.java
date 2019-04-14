package dbUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test {
	// 需求：向user表插入一条数据
	public void test1() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "insert into user values(?,?,?,?)";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			
			int update = qr.update(sql,6,"狗蛋",18,"北京");
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 需求：修改id为2的数据
	public void test2() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "update user set name = ? where id = ?";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			int update = qr.update(sql, "小柳", 2);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 需求：删除id为3的数据
	public void test3() {
		// 第一步：创建queryRunner对象，用来操作sql语句
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// 第二步：创建sql语句
		String sql = "delete from user where id = ?";
		// 第三步：执行sql语句,params:是sql语句的参数
		// 注意，给sql语句设置参数的时候，按照user表中字段的顺序
		try {
			int update = qr.update(sql, 3);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询数据表中所有数据
	public void test4() {
		//创建连接
		QueryRunner qr=new QueryRunner(new ComboPooledDataSource());
		String sql="select * from user";
		try {
			List<User> user=qr.query(sql, new BeanListHandler<User>(User.class));
			for(User u:user) {
				System.out.println(u.getId()+"\t"+u.getName()+"\t"+u.getAge()+"\t"+u.getAddress());
			}
			JDBCUtils.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		test t=new test();
		t.test1();
	}
}