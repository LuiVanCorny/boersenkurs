package de.kohnlehome;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class SharePriceTest {
    private SharePrice sharePrice;

    @BeforeEach
    public void init(){
        //Arrange
        IStockExchangeReader stockExchangeReader = mock(IStockExchangeReader.class);
        when(stockExchangeReader.readCourse("Telekom", 2019)).thenReturn(new double[]{20.1, 22.3, 2.0, 37.99, 35, 22.4});
        when(stockExchangeReader.readCourse("VW", 2019)).thenReturn(new double[]{200.00, 302.39, 288.30, 240.3, 220, 150});
        when(stockExchangeReader.readCourse("Vodafone", 2017)).thenReturn(new double[]{12.3, 13.4, 123.4, 1.0});
        sharePrice = new SharePrice(stockExchangeReader);
    }

    @Test
    public void getMaxPriceIncrease_Telekom_2019_Test(){
       double result = sharePrice.getMaxCourseFall("Telekom",2019);
        assertThat(result).isEqualTo(35.99);
    }

    @Test
    public void getMaxPriceIncrease_VW_2019_Test(){
        double result = sharePrice.getMaxCourseFall("VW",2019);
        assertThat(result).isEqualTo(102.39);
    }

    @Test
    public void getMaxPriceIncrease_Vodafone_2017_Test(){
        double result = sharePrice.getMaxCourseFall("Vodafone",2017);
        assertThat(result).isEqualTo(110.0);
    }

    @Test
    public void getMaxCourseFall_Telekom_2019_Test(){
        double result = sharePrice.getMaxCourseFall("Telekom",2019);
        assertThat(result).isEqualTo(20.3);
    }

    @Test
    public void getMaxCourseFall_VW_2019_Test(){
        double result = sharePrice.getMaxCourseFall("VW",2019);
        assertThat(result).isEqualTo(70);
    }

    @Test
    public void getMaxCourseFall_Vodafone_2017_Test(){
        double result = sharePrice.getMaxCourseFall("Vodafone",2017);
        assertThat(result).isEqualTo(122.4);
    }




}
