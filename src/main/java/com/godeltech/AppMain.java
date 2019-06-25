package com.godeltech;

import com.godeltech.config.ApplicationConfig;
import com.godeltech.model.dao.CarDao;
import com.godeltech.model.dto.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        CarDao carDao = context.getBean(CarDao.class);
        carDao.persist(new Car(1L, "dsd","asa",1993));

    }
}
