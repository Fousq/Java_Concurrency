package kz.zhanbolat.concurrency.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculationResult {
    private BigDecimal amount;
    private String warning;
    private boolean hasWarning;

    public CalculationResult(BigDecimal amount, String warning, boolean hasWarning) {
        this.amount = amount;
        this.warning = warning;
        this.hasWarning = hasWarning;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public boolean isHasWarning() {
        return hasWarning;
    }

    public void setHasWarning(boolean hasWarning) {
        this.hasWarning = hasWarning;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResult that = (CalculationResult) o;
        return hasWarning == that.hasWarning &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(warning, that.warning);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, warning, hasWarning);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "amount=" + amount +
                ", warning='" + warning + '\'' +
                ", hasWarning=" + hasWarning +
                '}';
    }
}
