package model;

import exeption.NullDateException;

import java.time.LocalDate;
import java.util.Objects;

public class Period {
    private LocalDate start;
    private LocalDate finish;

    private String subtitle;

    private String periodDescription;


    public Period(LocalDate start, LocalDate finish, String subtitle, String periodDescription) {
        this.start = start;
        this.finish = finish;
        this.subtitle = subtitle;
        this.periodDescription = periodDescription;
    }
    public Period(LocalDate start, LocalDate finish, String subtitle) {
        this.start = start;
        this.finish = finish;
        this.subtitle = subtitle;
    }

    public Period(int startMonth, int startYear, String subtitle, String periodDescription) {
        checkPeriod(startMonth, startYear);
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.subtitle = subtitle;
        this.periodDescription = periodDescription;
    }

    public Period(int startMonth, int startYear, int finishMonth, int finishYear, String subtitle) {
        checkPeriod(startMonth, startYear, finishMonth, finishYear);
        this.start = LocalDate.of(startYear, startMonth, 1);
        this.finish = LocalDate.of(finishYear, finishMonth, 1);
        this.subtitle = subtitle;
    }


    public Period(int startMonth, int startYear, int finishMonth, int finishYear, String subtitle, String periodDescription) {
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
            return start.toString() + " - " + "По настоящее время";
        }
        return start.toString() + " - " + finish.toString() + "\n" + subtitle + "\n" + periodDescription;
    }
}
