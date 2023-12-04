package cugb.xg.javaee.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cugb.xg.javaee.jdbc.bean.Student;
import cugb.xg.javaee.jdbc.utils.JDBCUtils;

public class StuDAO implements IStuDAO {
	/* (non-Javadoc)
	 * @see cugb.xg.javaee.jdbc.dao.IStuDAO#findStudents()
	 */
	@Override
	public ArrayList findStudents(){
		ArrayList stus = new ArrayList();
		Connection conn = JDBCUtils.getConnection();
		String sql = "select * from student";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Student stu = new Student();
				stu.setStuid(rs.getInt(1));
				stu.setSbirth(rs.getTimestamp(5));
				stus.add(stu);
			}
			JDBCUtils.free(ps, rs, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stus;
	}
	
	/* (non-Javadoc)
	 * @see cugb.xg.javaee.jdbc.dao.IStuDAO#insertStu(cugb.xg.javaee.jdbc.bean.Student)
	 */
	@Override
	public int insertStu(Student stu){
		Connection conn = JDBCUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into student(stuid,sbirth) values(?,?)";
		try {
			ps = conn.prepareCall(sql);
			ps.setInt(1, stu.getStuid());
			ps.setTimestamp(2, stu.getSbirth());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtils.free(ps, null, conn);
		}
		return 0;
	}
}
