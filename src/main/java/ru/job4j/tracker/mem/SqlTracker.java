package ru.job4j.tracker.mem;

import ru.job4j.tracker.mem.tracker.model.Item;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement stat =
                     cn.prepareStatement("create table if not exists items(id serial primary key, name text, created timestamp);")) {
            stat.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement =
                     cn.prepareStatement("insert into items(name, created) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            long millis = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(millis);
            statement.setString(1, item.getName());
            statement.setTimestamp(2, timestamp);
            statement.execute();
            try (ResultSet generatedKeys  = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("update items set name = ? where id = ?")) {
            statement.setString(1, item.getName());
            statement.setInt(2, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     cn.prepareStatement("delete from items where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    long millis = System.currentTimeMillis();
                    Timestamp timestamp = new Timestamp(millis);
                    LocalDateTime localDateTime = timestamp.toLocalDateTime();
                    Timestamp timestampFromLDT  = Timestamp.valueOf(localDateTime);

                   /* items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTime("created")
                    ));*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item;
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where id = ?")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                statement.setInt(1, id);
                /*item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("created")
                );         */
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return /* item*/ null;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement statement =
                     cn.prepareStatement("select * from items where name = ?")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                statement.setString(1, key);
                while (resultSet.next()) {
                    /*Timestamp timestamp = Timestamp.valueOf(items.getDate);
                    items.add(new Item(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getTimestamp("created")
                    ));*/
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }
}
