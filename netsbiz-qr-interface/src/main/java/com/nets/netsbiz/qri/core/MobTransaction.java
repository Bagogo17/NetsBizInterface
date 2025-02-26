package com.nets.netsbiz.qri.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MobTransaction {

    private String mobTerminalRid;
    private String mobTerminalTid;
    private String stan;
    private String iconRef;
    private BigDecimal amount;
    private String currencyCode;
    private String paymentTypeId;
    private String retrievalRef;
    private String transactionId;
    private String transactionDate;
    private String transactionTime;
    private String status;
}
