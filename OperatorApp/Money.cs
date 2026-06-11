public class Money
{
    public decimal Amount { get; private set; }
    public string Currency { get; private set; }

    public Money(decimal amount, string currency)
    {
        if (amount < 0)
        {
            throw new ArgumentException("So tien khong the am");
        }
        Amount = amount;
        Currency = currency.ToUpper();
    }

    // Ham kiem tra cung don vi - dung lai trong nhieu toan tu
    public static void KiemTraCungDonVi(Money a, Money b)
    {
        if (a.Currency != b.Currency)
        {
            throw new InvalidOperationException(
                $"Khong the thuc hien phep toan giua {a.Currency} va {b.Currency}. " +
                $"Vui long quy doi ve cung don vi truoc.");

        }
    }

    public static Money operator +(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return new Money(a.Amount + b.Amount, a.Currency);
    }

    public static Money operator -(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        if (a.Amount < b.Amount)
            throw new InvalidOperationException("Ket qua tru khong duoc am!");
        return new Money(a.Amount - b.Amount, a.Currency);
    }

    //Nhan voi he so (Vi du: Tinh luong lam them gio)
    public static Money operator *(Money a, decimal heSo)
    {
        if (heSo < 0)
        {
            throw new ArgumentException("He so khong the am");
        }
        return new Money(a.Amount * heSo, a.Currency);

    }

    public static Money operator *(decimal heSo, Money a)
    {
        return a * heSo;
    }

    public static bool operator >(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return a.Amount > b.Amount;
    }

    public static bool operator <(Money a, Money b)
    {
        KiemTraCungDonVi(a, b);
        return a.Amount < b.Amount;
    }

    public override string ToString()
        => $"{Amount:N0} {Currency}";

    public static bool operator ==(Money m1, Money m2)
    {
        if (ReferenceEquals(m1, m2))
            return true;

        if (m1 is null || m2 is null)
            return false;

        return m1.Currency == m2.Currency
            && m1.Amount == m2.Amount;
    }

    public static bool operator !=(Money m1, Money m2)
    {
        return !(m1 == m2);
    }

}