package org.example;

import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.internet.MimeMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * AAAAAAAAAAA
 */
public class Main {

    static private Logger logger = Logger.getLogger(Main.class.getName());

    /**
     * BBBBBBBBBB
     * @param args BBBB
     */
    public static void main(String[] args) {
        new Paradox(1000);
        printTestFile();

        String k = System.getProperty("environment");
        System.out.println("environment = " + k);

        empty();
    }

    /**
     * CCCCCCCCCCCCC
     */
    public static void printTestFile() {
        System.out.println("\nЧтение ресурсного файла test_packet.txt.");
        try ( InputStream inputStream = Main.class.getResourceAsStream("test_packet.txt") ) {
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            reader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nЧтение ресурсного файла test.txt.");
        try ( InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("test.txt") ) {
            InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(streamReader);
            reader.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String mavenProperty = System.getProperty("propertyForJavaCode");
        System.out.println(" mavenProperty = " + mavenProperty);
    }

    /**
     * DDDDDDDDDDDDDDD
     * @return DDDDDDD
     */
    public static boolean empty() {
        System.out.println("\n\n\nПустышка.");

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            System.out.println(botsApi);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
/*
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433","1","1");
            System.out.println(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }
*/
        Properties prop = new Properties(); prop.put("1","1");
        Session session = Session.getInstance(prop);
        Message msg = new MimeMessage(session);
        System.out.println(msg);

        class BaseTelegramBot extends TelegramLongPollingBot {

            @Override
            public void onUpdateReceived(Update update) {

            }

            @Override
            public String getBotUsername() {
                return null;
            }
        }
        BaseTelegramBot btb = new BaseTelegramBot();
        System.out.println(btb);

        logger.warning("12345");
        logger.info("12345");
        return true;
    }

    /**
     * isTrue() чтобы javadoc не ругался
     */
    public boolean isTrue() { System.out.println("isTrue()"); return true;}

    /**
     * myEmpty() чтобы javadoc не ругался
     */
    public void myEmpty() {}

}