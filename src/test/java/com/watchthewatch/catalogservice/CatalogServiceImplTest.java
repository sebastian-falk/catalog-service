package com.watchthewatch.catalogservice;

import com.watchthewatch.catalogservice.domain.model.Watch;
import com.watchthewatch.catalogservice.domain.service.CatalogServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Executable;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CatalogServiceImplTest {

    private final CatalogServiceImpl catalogService;

    @Autowired
    public CatalogServiceImplTest(CatalogServiceImpl catalogService) {
        this.catalogService = catalogService;
    }

    @Test
    void testCalculateDiscountedTotalSumWithoutDiscount() {
        Watch watch1 = new Watch("003", "Swatch", new BigDecimal("50.00"), null, null);
        List<Watch> watches = List.of(watch1);
        List<String> checkoutWatchIds = List.of("003");

        BigDecimal result = catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds);

        assertEquals(new BigDecimal("50.00"), result);
    }

    @Test
    void testCalculateDiscountedTotalSumAmountLowerThanDiscountQuantity() {
        Watch watch1 = new Watch("001", "Rolex", new BigDecimal("100.00"), 3, new BigDecimal("200.00"));
        List<Watch> watches = List.of(watch1);
        List<String> checkoutWatchIds = List.of("001");

        BigDecimal result = catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds);

        assertEquals(new BigDecimal("100.00"), result);
    }

    @Test
    void testCalculateDiscountedTotalSumWithSingleDiscount() {
        Watch watch1 = new Watch("001", "Rolex", new BigDecimal("100.00"), 3, new BigDecimal("200.00"));
        List<Watch> watches = List.of(watch1);
        List<String> checkoutWatchIds = List.of("001", "001", "001");

        BigDecimal result = catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds);

        assertEquals(new BigDecimal("200.00"), result);
    }

    @Test
    void testCalculateDiscountedTotalSumWithMultipleWatchesAndDiscounts() {
        Watch watch1 = new Watch("001", "Rolex", new BigDecimal("100.00"), 3, new BigDecimal("200.00"));
        Watch watch2 = new Watch("002", "Michael Kors", new BigDecimal("80.00"), 2, new BigDecimal("120.00"));
        List<Watch> watches = List.of(watch1, watch2);
        List<String> checkoutWatchIds = List.of("001", "001", "001", "001", "001", "001", "001", "002", "002", "001");

        BigDecimal result = catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds);

        assertEquals(new BigDecimal("720.00"), result);
    }

    @Test
    void testCalculateDiscountedTotalSumWatchWithNoMatches() {
        Watch watch1 = new Watch("001", "Rolex", new BigDecimal("100.00"), 3, new BigDecimal("200.00"));
        List<Watch> watches = List.of(watch1);
        List<String> checkoutWatchIds = List.of("999");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds));
        assertEquals("Some ids in checkoutWatchIds do not have corresponding watches.", exception.getMessage());
    }

    @Test
    void testCalculateDiscountedTotalSumCheckoutWatchIdsWithNoMatches() {
        Watch watch1 = new Watch("001", "Rolex", new BigDecimal("100.00"), 3, new BigDecimal("200.00"));
        Watch watch2 = new Watch("002", "Michael Kors", new BigDecimal("80.00"), 2, new BigDecimal("120.00"));
        List<Watch> watches = List.of(watch1, watch2);
        List<String> checkoutWatchIds = List.of("001");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> catalogService.calculateDiscountedTotalSum(watches, checkoutWatchIds));
        assertEquals("Some watches are not present in checkoutListWatchIds.", exception.getMessage());
    }

}
