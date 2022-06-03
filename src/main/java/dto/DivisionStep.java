package dto;

import java.util.Objects;

public class DivisionStep {
    private int reminderNumber;
    private int subtrahend;

    public DivisionStep(final int reminderNumber, final int subtrahend) {
        this.reminderNumber = reminderNumber;
        this.subtrahend = subtrahend;
    }

    public int getReminderNumber() {
        return reminderNumber;
    }

    public int getSubtrahend() {
        return subtrahend;
    }

    @Override
    public String toString() {
        return "DivisionStep [reminderNumber=" + reminderNumber + ", subtrahend=" + subtrahend + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(reminderNumber, subtrahend);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DivisionStep other = (DivisionStep) obj;
        return reminderNumber == other.reminderNumber && subtrahend == other.subtrahend;
    }
}

