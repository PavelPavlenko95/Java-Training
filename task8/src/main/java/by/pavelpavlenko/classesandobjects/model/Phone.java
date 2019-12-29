package by.pavelpavlenko.classesandobjects.model;

public class Phone extends Model{

    private int creditCardNumber;
    private int debit;
    private int credit;
    private int timeUrbanDialog;
    private int timeInternationalDialog;


    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public int getDebit() {
        return debit;
    }

    public int getCredit() {
        return credit;
    }

    public int getTimeUrbanDialog() {
        return timeUrbanDialog;
    }

    public int getTimeInternationalDialog() {
        return timeInternationalDialog;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setDebit(int debit) {
        this.debit = debit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setTimeUrbanDialog(int timeUrbanDialog) {
        this.timeUrbanDialog = timeUrbanDialog;
    }

    public void setTimeInternationalDialog(int timeInternationalDialog) {
        this.timeInternationalDialog = timeInternationalDialog;
    }

    public Phone(int id, int creditCardNumber, int debit, int credit, int timeUrbanDialog, int timeInternationalDialog) {
        super(id);
        this.creditCardNumber = creditCardNumber;
        this.debit = debit;
        this.credit = credit;
        this.timeUrbanDialog = timeUrbanDialog;
        this.timeInternationalDialog = timeInternationalDialog;
    }

    public Phone(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (creditCardNumber != phone.creditCardNumber) return false;
        if (debit != phone.debit) return false;
        if (credit != phone.credit) return false;
        if (timeUrbanDialog != phone.timeUrbanDialog) return false;
        return timeInternationalDialog == phone.timeInternationalDialog;
    }

    @Override
    public int hashCode() {
        int result = creditCardNumber;
        result = 31 * result + debit;
        result = 31 * result + credit;
        result = 31 * result + timeUrbanDialog;
        result = 31 * result + timeInternationalDialog;
        return result;
    }
}
