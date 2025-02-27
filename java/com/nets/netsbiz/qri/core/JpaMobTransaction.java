package com.nets.netsbiz.qri.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "qr_transaction")
public class JpaMobTransaction {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "mob_terminal_rid", length = 11, nullable = false)
    private String mobTerminalRid;

    @Column(name = "mob_terminal_tid", length = 8, nullable = false)
    private String mobTerminalTid;

    @Column(name = "stan", length = 20)
    private String stan;

    @Column(name = "icon_ref", length = 30)
    private String iconRef;

    @Column(name = "amount", precision = 16, scale = 2, nullable = false)
    @ColumnDefault("0.00")
    private BigDecimal amount;

    @Column(name = "currency_code", length = 3)
    private String currencyCode;

    @Column(name = "payment_type_id", length = 20)
    private String paymentTypeId;

    @Column(name = "retrieval_ref", length = 30)
    private String retrievalRef;

    @Column(name = "transaction_id", length = 10)
    private String transactionId;

    @Column(name = "transaction_date", length = 8)
    private String transactionDate;

    @Column(name = "transaction_time", length = 6)
    private String transactionTime;

    @Column(name = "status", length = 2)
    private String status;
    @CreationTimestamp
    private LocalDateTime createdDatetime;
    @UpdateTimestamp
    private LocalDateTime modifiedDatetime;
}
