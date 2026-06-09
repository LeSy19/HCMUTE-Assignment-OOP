
string v = new PhanSo(2, 4).ToString();
string v1 = new PhanSo(1, -4).ToString();
Console.WriteLine(v);
Console.WriteLine(v1);


PhanSo ps1 = new PhanSo(1, 2);
PhanSo ps2 = new PhanSo(1, 3);

Console.WriteLine($"ps1 = {ps1}");
Console.WriteLine($"ps2 = {ps2}");
Console.WriteLine($"ps1 + ps2 = {ps1 + ps2}");
Console.WriteLine($"ps1 - ps2 = {ps1 - ps2}");
Console.WriteLine($"ps1 * ps2 = {ps1 * ps2}");
Console.WriteLine($"ps1 / ps2 = {ps1 / ps2}");

PhanSo ps3 = new PhanSo(1, 2);
PhanSo ps4 = new PhanSo(2, 4);
PhanSo ps5 = new PhanSo(1, 3);

Console.WriteLine(ps3 == ps5);
Console.WriteLine(ps3 != ps5);
Console.WriteLine(ps5 < ps3);
Console.WriteLine(ps3 > ps5);

