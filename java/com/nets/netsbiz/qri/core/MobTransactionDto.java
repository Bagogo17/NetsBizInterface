package com.nets.netsbiz.qri.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MobTransactionDto {

    @JsonProperty("retrieval_ref")
    String retrievalRef;
    String mti;
    @JsonProperty("process_code")
    String processCode;
    String amount;
    String stan;
    @JsonProperty("transaction_time")
    String transactionTime;
    @JsonProperty("transaction_date")
    String transactionDate;
    @JsonProperty("response_code")
    String responseCode;
    @JsonProperty("approval_code")
    String approvalCode;
    @JsonProperty("host_tid")
    String hostTid;
    @JsonProperty("host_mid")
    String hostMid;
    @JsonProperty("SOF_uri")
    String SOFUri;
    @JsonProperty("currency_code")
    String currencyCode;
    @JsonProperty("payment_type_id")
    String paymentTypeId;
    @JsonProperty("transaction_id")
    String transactionId;
    @JsonProperty("transaction_status")
    String transactionStatus;
}
