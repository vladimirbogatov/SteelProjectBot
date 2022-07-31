import counter.*;
import dao.DaoController;
import dao.DaoModel;
import dao.DaoSQLModel;
import data.Data;
import model.Flat;
import model.counters.Counter;
import model.counters.CounterType;
import model.counters.Water_Counter;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import user.User;

public class Solution {
    public static void main(String[] args) {
/*
        JSK jsk = JSK.getJSK(); // создаём синглтон ЖСК. Сейчас этот объект не будет никак исользоваться. В дальнейшем, можно будет организовать проверку, что база для даноо ЖСК существует
        //TODO организовать проверку, что база для даноо ЖСК существует
        Data_model data_model = new Fake_data(); // подготавливаем фейковую модель данных.

        Data_controll data_controll = new Data_controll(jsk, data_model);// передаём в Controll данные по ЖСК и базе. С этого момента, всё взаимодейсвие с базой будет через data_controll

        //Подготовим Thread_executer_pool для дальнейшей работы с ним
        //Оптимальное количество тредов, которое мы будем использовать
        int max_threads_count = Runtime.getRuntime().availableProcessors() + 1;
        //Минимальное количество тредов, которео мы будем использовать
        int min_threads_count = max_threads_count / 2;

        int max_command_in_queue = data_controll.getMembersCount()/2;// максимальное длина очереди задачи для обработки тредами равно количеству пользователей / 2
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(max_command_in_queue);
        // далее нужно обрабатывать значения в очереди. Для этого мы будем использовать ThreadPoolExecuter
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(min_threads_count, max_threads_count, 5, TimeUnit.MILLISECONDS, linkedBlockingQueue );
        threadPoolExecutor.prestartAllCoreThreads();

        // теперь у нас что-то там обрабатывается.
        // а здесь мы можем обрабатывать консоль, чтобы можно было аккуратно остановить всё
        // TODO добавить обработку останова тредов
        // TODO нужно не забыть остановить threadPoolExecuter
        // TODO добавить логгирование
        */
        // TODO Instantiate Telegram Bots API
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new SteelProject_bot(Constant.BOT_TOKEN, Constant.BOT_NANE));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        DaoModel daoModel = new DaoSQLModel();
        DaoController daoController = new DaoController();
        daoController.setDaoModel(daoModel);

        Flat flat = new Flat(188);
        Counter counter_cold = new Water_Counter(flat, 9999, CounterType.COLD_WATER);
        Counter counter_hot = new Water_Counter(flat, 9998, CounterType.HOT_WATER);
        User user = new User(245523456987698L, flat);
        daoController.saveToBase(counter_cold, counter_hot, flat,user);
        Data data = new Data(user, flat, counter_cold, 78, daoController);
        Data data1 = new Data(user, flat, counter_hot, 79, daoController);
        daoController.saveToBase(data, data1);

/*        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();*/



/*        Session session;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction  = session.beginTransaction();
            session.persist(counter_cold);
            session.persist(counter_hot);
            session.persist(flat);
            session.persist(user);
            session.persist(data);
            session.persist(data1);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println(e.getStackTrace());
            throw e;
        }*/



/*        SessionFactory factory = new Configuration()
                .configure()
                .buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(counter);
        session.getTransaction().commit();
        session.close();*/


/*

        String url = "jdbc:mysql://sql11.freesqldatabase.com:3306/sql11411324";
        String username = "sql11411324";
        String password = "ieMscwJ3lF";
        System.out.println("Connecting...");


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection successful!");
            Statement statement = connection.createStatement();

            statement.execute("INSERT INTO `main`( `FlatNumber`, `SN`, `Data`) VALUES(100,3333,STR_TO_DATE('21,5,2055','%d,%m,%Y'))");
          ResultSet resultSet = statement.executeQuery("SELECT * FROM main");
            while(resultSet.next()){

                int id = resultSet.getInt(1);
                int flatNumber = resultSet.getInt(2);
                int sn = resultSet.getInt(3);
                Date date = resultSet.getDate(4);
                System.out.print(id + " ");
                System.out.print(flatNumber + " ");
                System.out.print(sn  + " ");
                System.out.print(date);
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
*/


        // TODO Register our bot


    }

}
