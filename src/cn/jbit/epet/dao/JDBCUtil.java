package cn.jbit.epet.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 设计模式：单例模式——懒汉式 创建 JDBC 工具类
 *
 */
public class JDBCUtil {
    //?useSSL=false&serverTimezone=UTC

    private final static String PATH = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/ppet";
    private final String USER = "root";
    private final String PASSWORD = "123456";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private static JDBCUtil jdbcUtil = null;

    /**
     * 无参构造函数私有化
     */
    public JDBCUtil() {
    }

    public static synchronized JDBCUtil getInitJDBCUtil() {
        if (jdbcUtil == null) {
            jdbcUtil = new JDBCUtil();
        }
        return jdbcUtil;
    }

    /**
     * 加载驱动
     */
    static {
        try {
            Class.forName(PATH);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库
     *
     * @return
     */
    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 执行 增、删、改 方法
     *
     * @param sql
     * @return
     */
    public int executeUpdate(String sql) {
        int affectLine = 0;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            affectLine = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectLine;
    }

    /**
     * 执行 增、删、改 方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object[] params) {
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                System.out.println(i + "  " + params[i]);
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 返回结果集  执行 预编译
     * @param sql
     * @param params
     * @return ResultSet
     */
    public ResultSet executeQueryRS(String sql, Object[] params) {
        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    /**
     * 返回结果集 列表
     * @param sql
     * @param params
     * @return
     */
    public List<HashMap> executeQuery(String sql, Object[] params) {
        List<HashMap> list = new ArrayList<HashMap>();
        ResultSetMetaData resultSetMataData = null;
        int columunCount = 0;
        try {
            resultSet = executeQueryRS(sql, params);
            // 取 resultSetMataData 中的 列resultSet.getMetaData();
            resultSetMataData =resultSet.getMetaData();
            // 取 resultSetMataData 的数目
            columunCount = resultSetMataData.getColumnCount();

            while (resultSet.next()) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                for (int i = 1; i <= columunCount; i++) {
                    map.put(resultSetMataData.getColumnLabel(i), resultSet.getObject(i));
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeAll();
        }
        return list;
    }

    /**
     * 关闭流
     */
    public void closeAll() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}