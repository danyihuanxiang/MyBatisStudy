package mybatisone.study;

import com.study.domain.School;

import java.sql.*;
import java.util.concurrent.Executor;

public class StudySimpleExecutor implements StudyExexutor {

    @Override
    public <T> T query(String statement, String paramerer) {
        Connection connection = null;
        School school = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://101.132.181.107:3306/study?useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "TaoJin@13554386");
            String sql = String.format(statement, Integer.valueOf(paramerer));
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                school = new School();
                school.setSchoolid(resultSet.getInt(1));
                school.setSchoolname(resultSet.getString(2));
                school.setStudentids(resultSet.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return (T)school;
    }
}
