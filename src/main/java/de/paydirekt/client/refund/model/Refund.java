package de.paydirekt.client.refund.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.paydirekt.client.rest.HalResource;
import de.paydirekt.client.rest.Link;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

/**
 * A refund transaction.
 * The merchant returns money to the customer.
 */
public class Refund extends HalResource {

    private final String type;
    private final String transactionId;
    private final BigDecimal amount;
    private final String note;
    private final String merchantRefundReferenceNumber;
    private final String paymentInformationId;
    private final RefundStatus status;
    private final String merchantReconciliationReferenceNumber;

    /**
     * Constructor.
     *
     * @param type                                  Type of the transaction, always REFUND.
     * @param transactionId                         Id of the transaction, generated by the paydirekt system.
     * @param amount                                The value of the refund.
     * @param note                                  Comment for the buyer.
     * @param merchantRefundReferenceNumber         Internal reference number, provided by the merchant.
     * @param paymentInformationId                  Payment information id of the transaction, used to combine single transactions.
     * @param status                                Status of the refund.
     * @param merchantReconciliationReferenceNumber Internal reconciliation number, provided by the merchant.
     * @param embedded                              Embedded resources.
     * @param links                                 Links to resources.
     */
    public Refund(@JsonProperty("type") String type,
                  @JsonProperty("transactionId") String transactionId,
                  @JsonProperty("amount") BigDecimal amount,
                  @JsonProperty("note") String note,
                  @JsonProperty("merchantRefundReferenceNumber") String merchantRefundReferenceNumber,
                  @JsonProperty("paymentInformationId") String paymentInformationId,
                  @JsonProperty("status") RefundStatus status,
                  @JsonProperty("merchantReconciliationReferenceNumber") String merchantReconciliationReferenceNumber,
                  @JsonProperty("_embedded") Map<String, Object> embedded,
                  @JsonProperty("_links") Map<String, Link> links) {
        super(embedded, links);
        this.type = type;
        this.transactionId = transactionId;
        this.amount = amount;
        this.note = note;
        this.merchantRefundReferenceNumber = merchantRefundReferenceNumber;
        this.paymentInformationId = paymentInformationId;
        this.status = status;
        this.merchantReconciliationReferenceNumber = merchantReconciliationReferenceNumber;
    }

    public String getType() {
        return type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    public String getMerchantRefundReferenceNumber() {
        return merchantRefundReferenceNumber;
    }

    public String getPaymentInformationId() {
        return paymentInformationId;
    }

    public RefundStatus getStatus() {
        return status;
    }

    public String getMerchantReconciliationReferenceNumber() {
        return merchantReconciliationReferenceNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transactionId, amount, note, merchantRefundReferenceNumber, paymentInformationId, status, merchantReconciliationReferenceNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Refund)) {
            return false;
        }
        final Refund other = (Refund) obj;
        return Objects.equals(type, other.type)
                && Objects.equals(transactionId, other.transactionId)
                && Objects.equals(amount, other.amount)
                && Objects.equals(note, other.note)
                && Objects.equals(merchantRefundReferenceNumber, other.merchantRefundReferenceNumber)
                && Objects.equals(paymentInformationId, other.paymentInformationId)
                && Objects.equals(status, other.status)
                && Objects.equals(merchantReconciliationReferenceNumber, other.merchantReconciliationReferenceNumber);
    }
}
