package model;

import exeption.NullDateException;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate start;
    private LocalDate finish;

    private String subtitle;

    private String periodDescription;

    public Period() {
    }

    public Period(LocalDate start, LocalDate finish, String subtitle, String periodDescription) {
        Objects.requireNonNull(start, "Start date value can't be null");
        Objects.requireNonNull(finish, "Finish date value can't be null");
        Objects.requireNonNull(subtitle, "Subtitle value can't be null");
        Objects.requireNonNull(periodDescription, "Period description value can't be null");
        this.start = start;
        this.finish = finish;
        this.subtitle = subtitle;
        this.periodDescription = periodDescription;
    }
    public Period(LocalDate start, LocalDate finish, String subtitle) {
        Objects.requireNonNull(start, "Start date value can't be null");
        Objects.requireNonNull(finish, "Finish date value can't be null");
        this.start = start;
        this.finish = finish;
        this.subtitle = subtitle;
    }

    public Period(int startMonth, int startYear, String subtitle, String periodDescription) {
        checkPeriod(startMonth, startYear);
        Objects.requireNonNull(subtitle, "Subtitle value can't be null");
        Objects.requireNonNull(periodDescription, "Period description value can't be null");
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.subtitle = subtitle;
        this.periodDescription = periodDescription;
    }

    public Period(int startMonth, int startYear, int finishMonth, int finishYear, String subtitle) {
        Objects.requireNonNull(subtitle, "Subtitle value can't be null");
        checkPeriod(startMonth, startYear, finishMonth, finishYear);
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.finish = LocalDate.of(finishYear, finishMonth, 1);
        this.subtitle = subtitle;
    }


    public Period(int startMonth, int startYear, int finishMonth, int finishYear, String subtitle, String periodDescription) {
        Objects.requireNonNull(subtitle, "Subtitle value can't be null");
        Objects.requireNonNull(periodDescription, "Period description value can't be null");
        checkPeriod(startMonth, startYear, finishMonth, finishYear);
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.finish = LocalDate.of(finishYear, finishMonth, 1);
        this.subtitle = subtitle;
        this.periodDescription = periodDescription;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }
    private void checkPeriod(int startMonth, int startYear, int finishMonth, int finishYear) {
        if (startMonth == 0 || startYear == 0 || finishMonth == 0 || finishYear == 0){
            throw new NullDateException("Дата не может содержать параметр равный 0");
        }
    }

    private void checkPeriod(int startMonth, int startYear) {
        if (startMonth == 0 || startYear == 0){
            throw new NullDateException("Дата не может содержать параметр равный 0");
        }
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
            return start.toString() + " - " + "По настоящее время" + "\n" + subtitle + "\n" + periodDescription;
        }
        return start.toString() + " - " + finish.toString() + "\n" + subtitle + "\n" + periodDescription;
    }
}
