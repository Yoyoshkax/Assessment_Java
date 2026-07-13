package database;

import java.sql.*;

public class JdbcConnector {
    public static void main(String[] args) {
        String databaseUrl = "jdbc:postgresql://adress:port/mydatabase";
        String user = "user";
        String password = "password";

        //Создание, открытие соединения
        //Управляет транзакциями (отключить автокоммиты, закоммитить, откатить, включить автокоммиты и т.д)
        //Установка времени сессии, установка работы (Рид онли или нет), можно выбрать каталог/схему
        //Создание statement
        //Закрытие соединения, проверка закрыт ли или живо ли
        Connection connection = null;

        //Statement — это объект для отправки SQL-запросов в БД. Он содержит запрос и получает результаты.
        //Обычный statement выполняет функции все те же что и при обращении через СУБД (select, update и тд)
        //PreparedStatment позволяет не привязываться строго к конкретному запросу, а конфигурировать уже существующий запрос в котором есть знаки ?
        Statement statement = null;

        //ResultSet — это курсор, указывающий на текущую строку результатов. Это как итератор по строкам ответа от БД.
        //
        ResultSet resultSet = null;

        //Конфигурация обычного statement
        try {
            connection = DriverManager.getConnection(databaseUrl);

            statement = connection.createStatement();

            //только тех запросов которые возвращают данные
            resultSet = statement.executeQuery("SELECT * FROM table");
            //только для тех запросов, которые как-то изменяют данные (update, delete и тд)
//            resultSet = statement.execute("SELECT * FROM table");

            while (resultSet.next()) {
                System.out.println("Колонки и их вэлью");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка SQL" + e.getMessage());
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                System.err.println("Ошибка закрытия ресурсов" + e.getMessage());
            }

        }
    }
}
