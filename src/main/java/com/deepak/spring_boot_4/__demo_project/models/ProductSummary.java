package com.deepak.spring_boot_4.__demo_project.models;

import java.math.BigDecimal;

public interface ProductSummary {
     String getBarCode();
     String getItem();
     String getCategory();
     BigDecimal getPrice();

}
