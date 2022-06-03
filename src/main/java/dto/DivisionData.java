package dto;

import java.util.List;
import java.util.Objects;

public class DivisionData {
    private int dividend;
    private int divisor;
    private int result;
    private int rest;
    private List<DivisionStep> steps;

    public DivisionData() {
    }

    public static Builder builder() {
        return new DivisionData().new Builder();
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getResult() {
        return result;
    }

    public int getRest() {
        return rest;
    }

    public List<DivisionStep> getSteps() {
        return steps;
    }

    public class Builder {

        private Builder() {
        }

        public Builder withDividend(int dividend) {
            DivisionData.this.dividend = dividend;
            return this;
        }

        public Builder withDivisor(int divisor) {
            DivisionData.this.divisor = divisor;
            return this;
        }

        public Builder withResult(int result) {
            DivisionData.this.result = result;
            return this;
        }

        public Builder withRest(int rest) {
            DivisionData.this.rest = rest;
            return this;
        }

        public Builder withStep(List<DivisionStep> steps) {
            DivisionData.this.steps = steps;
            return this;
        }

        public DivisionData build() {
            return DivisionData.this;
        }
    }

    @Override
    public String toString() {
        return "DivisionData [dividend=" + dividend + ", divisor=" + divisor + ", result=" + result + ", rest=" + rest
                + ", steps=" + steps + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, rest, result, steps);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionData other = (DivisionData) obj;
        return dividend == other.dividend && divisor == other.divisor && rest == other.rest && result == other.result
                && Objects.equals(steps, other.steps);
    }

}

