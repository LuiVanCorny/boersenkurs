package de.kohnlehome;

public interface ISharePrice {

    double getMaxPriceIncrease(String sharename, int year);
    double getMaxCourseFall(String sharename, int year);


}
