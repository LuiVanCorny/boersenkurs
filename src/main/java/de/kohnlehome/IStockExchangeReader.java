package de.kohnlehome;

public interface IStockExchangeReader {
    double[] readCourse(String sharename, int year);
}
