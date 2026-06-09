public class PhanSo
{
    public int TuSo { get; private set; }
    public int MauSo { get; private set; }

    public PhanSo(int tuSo, int mauSo)
    {
        if (mauSo == 0)
        {
            throw new ArgumentException("Mẫu số không được bằng 0.");
        }
        //Xu ly dau: dua dau am len tu so
        if (mauSo < 0)
        {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
        int ucln = UCLN(Math.Abs(tuSo), Math.Abs(mauSo));
        TuSo = tuSo / ucln;
        MauSo = mauSo / ucln;
    }

    private static int UCLN(int a, int b)
    {
        while (b != 0) { int t = b; b = a % b; a = t; }
        return a;

    }

    public PhanSo RutGon()
    {
        return new PhanSo(TuSo, MauSo); // tu dong rut gon
    }

    public override string ToString()
    {
        if (MauSo == 1)
        {
            return TuSo.ToString();
        }
        return $"{TuSo}/{MauSo}";
    }

    // Toan Tu cong (+)
    public static PhanSo operator +(PhanSo a, PhanSo b)
    {
        int tuSoMoi = a.TuSo * b.MauSo + b.TuSo * a.MauSo;
        int mauSoMoi = a.MauSo * b.MauSo;
        return new PhanSo(tuSoMoi, mauSoMoi);
    }

    // Toan Tu tru (-)
    public static PhanSo operator -(PhanSo a, PhanSo b)
    {
        int tuSoMoi = a.TuSo * b.MauSo - b.TuSo * a.MauSo;
        int mauSoMoi = a.MauSo * b.MauSo;
        return new PhanSo(tuSoMoi, mauSoMoi);
    }

    // Toan Tu nhan (*)
    public static PhanSo operator *(PhanSo a, PhanSo b)
    {
        int tuSoMoi = a.TuSo * b.TuSo;
        int mauSoMoi = a.MauSo * b.MauSo;
        return new PhanSo(tuSoMoi, mauSoMoi);
    }

    // Toan Tu chia (/)
    public static PhanSo operator /(PhanSo a, PhanSo b)
    {
        if (b.TuSo == 0)
        {
            throw new ArgumentException("Không thể chia cho phân số có tử số bằng 0.");
        }
        int tuSoMoi = a.TuSo * b.MauSo;
        int mauSoMoi = a.MauSo * b.TuSo;
        return new PhanSo(tuSoMoi, mauSoMoi);
    }


    // Toan Tu bang (==) va khac (!=)
    public static bool operator ==(PhanSo a, PhanSo b)
    {
        return a.TuSo * b.MauSo == b.TuSo * a.MauSo;
    }

    public static bool operator !=(PhanSo a, PhanSo b)
    {
        return !(a == b);
    }

    // Toan Tu lon hon (>) va nho hon (<)
    public static bool operator >(PhanSo a, PhanSo b)
    {
        return a.TuSo * b.MauSo > a.MauSo * b.TuSo;
    }

    public static bool operator <(PhanSo a, PhanSo b)
    {
        return b > a;
    }




}