package dbUtils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test {
	// ������user�����һ������
	public void test1() {
		// ��һ��������queryRunner������������sql���
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// �ڶ���������sql���
		String sql = "insert into user values(?,?,?,?)";
		// ��������ִ��sql���,params:��sql���Ĳ���
		// ע�⣬��sql������ò�����ʱ�򣬰���user�����ֶε�˳��
		try {
			
			int update = qr.update(sql,6,"����",18,"����");
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// �����޸�idΪ2������
	public void test2() {
		// ��һ��������queryRunner������������sql���
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// �ڶ���������sql���
		String sql = "update user set name = ? where id = ?";
		// ��������ִ��sql���,params:��sql���Ĳ���
		// ע�⣬��sql������ò�����ʱ�򣬰���user�����ֶε�˳��
		try {
			int update = qr.update(sql, "С��", 2);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// ����ɾ��idΪ3������
	public void test3() {
		// ��һ��������queryRunner������������sql���
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		// �ڶ���������sql���
		String sql = "delete from user where id = ?";
		// ��������ִ��sql���,params:��sql���Ĳ���
		// ע�⣬��sql������ò�����ʱ�򣬰���user�����ֶε�˳��
		try {
			int update = qr.update(sql, 3);
			System.out.println(update);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��ѯ���ݱ�����������
	public void test4() {
		//��������
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