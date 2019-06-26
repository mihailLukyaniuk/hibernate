package com.godeltech;

import com.godeltech.config.ApplicationConfig;
import com.godeltech.model.dao.*;
import com.godeltech.model.dto.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.Month;



public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        LocationDao locationDao = context.getBean("locationDao", LocationDao.class);
        CarDao carDao = context.getBean(CarDao.class);
        CompanyDao companyDao = context.getBean(CompanyDao.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        RentalDao rentalDao = context.getBean(RentalDao.class);

        //        Saving Customer in DB
        Customer johnCustomer = customerDao.create(new Customer("John_Login", "John", "Snow"));
        Customer mikeCustomer = customerDao.create(new Customer("Mike_Login", "Mike", "Lukyaniuk"));
        Customer hannaCustomer = customerDao.create(new Customer("Hanna_Login", "Hanna", "Karenina"));
        Customer denisCustomer = customerDao.create(new Customer("Denis_Login", "Denis", "Nichipor"));

        //        Saving Locations in DB
        Location minsk = locationDao.create(new Location("220000", "Minsk", "Bogdanchuka", "221"));
        Location grodno = locationDao.create(new Location("220000", "Grodno", "Bogdanchuka", "221"));
        Location gomel = locationDao.create(new Location("220000", "Gomel", "Bogdanchuka", "221"));
        Location brest = locationDao.create(new Location("224000", "Brest", "Moskovskaya", "108"));

        //        Saving Companies in DB
        Company firstRentalCompany = companyDao.create(new Company("Nissan Centre", minsk));
        Company secondRentalCompany = companyDao.create(new Company("Toyota Centre", minsk));
        Company thirdRentalCompany = companyDao.create(new Company("Subaru Centre", brest));
        Company fourthRentalCompany = companyDao.create(new Company("Mitsubishi centre", brest));

        //        Saving Car in DB
        Car renoCar = carDao.create(new Car("Reno", "Logan", 2005, firstRentalCompany));
        Car fordCar = carDao.create(new Car("Ford", "Fusion", 2009, firstRentalCompany));
        Car hundaiCar = carDao.create(new Car("Hundai", "Solaris", 2013, secondRentalCompany));
        Car bmwCar = carDao.create(new Car("BMW", "X7", 2018, secondRentalCompany));

//          Saving Rental in DB
        Rental firstRental = rentalDao.create(new Rental(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 4), renoCar, mikeCustomer));
        Rental secondRental = rentalDao.create(new Rental(LocalDate.of(2019, Month.JULY, 1), LocalDate.of(2019, Month.JULY, 4), fordCar, hannaCustomer));
        Rental thirdRental = rentalDao.create(new Rental(LocalDate.of(2019, Month.JULY, 2), LocalDate.of(2019, Month.JULY, 9), hundaiCar, johnCustomer));
        Rental forthRental = rentalDao.create(new Rental(LocalDate.of(2019, Month.JULY, 2), LocalDate.of(2019, Month.JULY, 9), bmwCar, denisCustomer));

        firstRentalCompany.getCars().add(renoCar);
        firstRentalCompany.getCars().add(fordCar);
        secondRentalCompany.getCars().add(hundaiCar);
        secondRentalCompany.getCars().add(bmwCar);

        mikeCustomer.getRentals().add(firstRental);
        hannaCustomer.getRentals().add(secondRental);
        johnCustomer.getRentals().add(thirdRental);
        denisCustomer.getRentals().add(forthRental);

        renoCar.getRentals().add(firstRental);
        fordCar.getRentals().add(secondRental);
        hundaiCar.getRentals().add(thirdRental);
        bmwCar.getRentals().add(forthRental);
    }
}