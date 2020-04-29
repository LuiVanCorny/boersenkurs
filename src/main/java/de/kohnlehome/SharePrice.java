package de.kohnlehome;

public class SharePrice implements ISharePrice {
    private IStockExchangeReader stockExchangeReader;

    public SharePrice(IStockExchangeReader stockExchangeReader) {
        this.stockExchangeReader = stockExchangeReader;
    }

    @Override
    public double getMaxPriceIncrease(String sharename, int year) {
        return 0;
    }

    @Override
    public double getMaxCourseFall(String sharename, int year) {
        return 0;
    }
}
