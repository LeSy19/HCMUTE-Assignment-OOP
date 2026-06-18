// VECTOR2D

Vector2D v1 = new Vector2D(3, 4);
Vector2D v2 = new Vector2D(1, 2);

Console.WriteLine($"v1 = {v1}");
Console.WriteLine($"v2 = {v2}");

Console.WriteLine($"v1 + v2 = {v1 + v2}");
Console.WriteLine($"v1 - v2 = {v1 - v2}");
Console.WriteLine($"v1 * 2 = {v1 * 2}");
Console.WriteLine($"3 * v2 = {3 * v2}");
Console.WriteLine($"-v1 = {-v1}");
Console.WriteLine($"|v1|   = {v1.DoDai:F4}");

Console.WriteLine($"v1 * v2 = {v1 * v2}");
Console.WriteLine($"v1 == v2? {v1 == v2}");

// MONEY

Money luong = new Money(15_000_000, "VND");
Money thuong = new Money(3_000_000, "VND");
Money lamThemGio = luong * 1.5m;

Console.WriteLine($"Luong co ban:   {luong}");
Console.WriteLine($"Thuong thang:   {thuong}");
Console.WriteLine($"Luong lam them: {lamThemGio}");
Console.WriteLine($"Tong thu nhap:  {luong + thuong}");

Console.WriteLine($"Luong > Thuong: {luong > thuong}");

Console.WriteLine($"Luong == Thuong: {luong == thuong}");

// Kiem tra bep logic – khac don vi
try
{
    Money usd = new Money(100, "USD");
    Money tong = luong + usd;  // Nem ngoai le!
}
catch (InvalidOperationException ex)
{
    Console.WriteLine($"Loi: {ex.Message}");
    // In: Loi: Khong the thuc hien phep toan giua VND va USD...
}
