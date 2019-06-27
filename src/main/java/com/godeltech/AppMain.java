package com.godeltech;

import com.godeltech.config.AppConfig;
import com.godeltech.model.dao.*;
import com.godeltech.model.dto.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;


public class AppMain {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        LocationDao locationDao = context.getBean(LocationDao.class);
        CarDao carDao = context.getBean(CarDao.class);
        CompanyDao companyDao = context.getBean(CompanyDao.class);
        CustomerDao customerDao = context.getBean(CustomerDao.class);
        RentalDao rentalDao = context.getBean(RentalDao.class);

        //        Saving Customer in DB
        Customer johnCustomer = customerDao.create(new Customer("John_Login", "John", "Snow"));
        Customer mikeCustomer = customerDao.create(new Customer(  "Mike_Login", "Mike", "Lukyaniuk"));
        Customer hannaCustomer = customerDao.create(new Customer("Hanna_Login", "Hanna", "Karenina"));
        Customer denisCustomer = customerDao.create(new Customer( "Denis_Login", "Denis", "Nichipor"));

        //        Saving Locations in DB
        Location minsk = locationDao.create(new Location(
                "Belarus", "Minsk", "Bogdanchuka", "221"));
        Location brest = locationDao.create(new Location(
                "Belarus", "Brest", "lefler", "11/7"));

        //        Saving Companies in DB
        Company firstRentalCompany = companyDao.create(
                new Company("FastRoad", minsk));
        Company secondRentalCompany = companyDao.create(
                new Company("BestCars", minsk));
        Company thirdRentalCompany = companyDao.create(
                new Company("YourChise", brest));

        //        Saving Car in DB
        Car renoCar = carDao.create(
                new Car("Reno", "Logan", 2005, firstRentalCompany));
        Car fordCar = carDao.create(
                new Car("Ford", "Fusion", 2009, firstRentalCompany));
        Car hundaiCar = carDao.create(
                new Car("Hundai", "Solaris", 2013, firstRentalCompany));
        Car ladaCar = carDao.create(
                new Car("Lada", "Granta", 2013, secondRentalCompany));
        Car citroenCar = carDao.create(
                new Car("Citroen", "Xara", 2013, secondRentalCompany));
        Car hondaCar = carDao.create(
                new Car("Honda", "Civic", 2013, thirdRentalCompany));
        Car bmwCar = carDao.create(
                new Car("BMW", "X7", 2018, thirdRentalCompany));

//          Saving Rental in DB
        rentalDao.create(new Rental(LocalDate.of(2019, 6, 9),
                LocalDate.of(2019, 6, 12), renoCar, mikeCustomer));
        rentalDao.create(new Rental(LocalDate.of(2019, 6, 9),
                LocalDate.of(2019, 6, 12), fordCar, hannaCustomer));
        rentalDao.create(new Rental(LocalDate.of(2019, 6, 7),
                LocalDate.of(2019, 6, 10), hundaiCar, johnCustomer));
        rentalDao.create(new Rental(LocalDate.of(2019, 6, 7),
                LocalDate.of(2019, 1, 10), ladaCar, denisCustomer));

        for (Car car : carDao.findAll()) {
            System.out.println(car);
        }
        for (Company company : companyDao.findAll()) {
            System.out.println(company);
        }
        for (Customer customer : customerDao.findAll()) {
            System.out.println(customer);
        }
        for (Location location : locationDao.findAll()) {
            System.out.println(location);
        }
        for (Rental rental : rentalDao.findAll()) {
            System.out.println(rental);
        }

        hannaCustomer.setLogin("Update_Login_of_HANNA");
        customerDao.update(hannaCustomer);
        System.out.println("Update the login of customer :"
                + customerDao.findOne(hannaCustomer.getId()));

        System.out.printf(
                "\nSearch available car by OUNTRY, CITY and PERIOD of time");
        String countryCode = "Belarus";
        String city = "Minsk";
        LocalDate startDate = LocalDate.of(2019, 6, 10);
        LocalDate endDate = LocalDate.of(2019, 6, 11);
        System.out.printf("\nCountry code IS : " + countryCode + "\nCity IS : "
                + city + "\nStart period of rent IS : " + startDate
                + "\nEnd period of rent IS : " + endDate + "\n");

        System.out.println("HERE ARE AVALIABLE CARS ACCORDING TO YOUR REQUEST : ");

        for (Car car : carDao.findCarByLocationAndDate(countryCode, city, startDate, endDate)) {
            System.out.println(car);
        }

        System.out.printf("\nSearch available car by COMPANY NAME and PERIOD of time");
        String companyName = "FastRoad";
        LocalDate startDateSearch = LocalDate.of(2019, 6, 10);
        LocalDate endDateSearch = LocalDate.of(2019, 6, 11);
        System.out.printf("\nCompany Name IS : " + companyName
                + "\nStart period of rent IS : " + startDateSearch
                + "\nEnd period of rent IS : " + endDateSearch + "\n");

        System.out.println("HERE ARE AVALIABLE CARS ACCORDING TO YOUR REQUEST : ");

        for (Car car : carDao.findCarByCompanyNameAndDate(companyName, startDate, endDate)) {
            System.out.println(car);
        }
    }
}