package test;

import org.ufox.rubik.optimus.archer.business.customer.entity.Customer;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import org.avaje.datasource.DataSourceConfig;

public class Demo {

    public static void main(String[] args) {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriver("org.h2.Driver");
        dsc.setUrl("jdbc:h2:mem:demo_db;INIT=RUNSCRIPT FROM 'classpath:/db-schema.ddl';");
        dsc.setUsername("sa");
        dsc.setPassword("sa");
        //
        ServerConfig sc = new ServerConfig();
        sc.setDataSourceConfig(dsc);
        sc.setDatabaseBooleanTrue("1");
        sc.setDatabaseBooleanFalse("0");
        sc.setRegister(true);
        sc.setDefaultServer(true);
        //
        EbeanServer db = EbeanServerFactory.create(sc);
        ////
        System.out.println(db.find(Customer.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(db.find(Gift.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(db.find(Hotel.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(db.find(Order.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(db.find(Room.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(db.find(Schedule.class).setDisableLazyLoading(true).findList().size());
        //System.out.println(new QOrder().where().room);
        //System.out.println(new QOrder(db).room);
    }
}
