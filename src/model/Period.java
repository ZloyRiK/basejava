package model;

import exeption.NullDateException;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private LocalDate start;
    private LocalDate finish;

    public Period(int startMonth, int startYear, int finishMonth, int finishYear) {
        if (startMonth == 0 || startYear == 0 || finishMonth == 0 || finishYear == 0){
            throw new NullDateException("Дата не может содержать параметр равный 0");
        }
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.finish = LocalDate.of(finishYear, finishMonth, 1);
    }

    public Period(int startMonth, int startYear) {
        this.start = LocalDate.of(startYear, startMonth, 1);
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return start.equals(period.start) && finish.equals(period.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish);
    }

    @Override
    public String toString() {
        if (finish == null){
            return start.toString() + " - " + "По настоящее время";
        }
        return start.toString() + " - " + finish.toString();
    }
}
