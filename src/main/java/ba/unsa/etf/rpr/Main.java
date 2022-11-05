package ba.unsa.etf.rpr;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main(String[] args) throws IOException {
//        LaptopDao dao = new LaptopDaoXmlFile();
        LaptopDao dao1 = new LaptopDaoJsonFile();
//        LaptopDao bin = new LaptopDaoSerializableFileImpl();
        Laptop l = new Laptop("lenovo", "IdeaPad", "I7-4480MQ", "NVIDIA", 700, 15.6, 8, 1000, 240);
        Laptop l1 = new Laptop("acer", "IdeaPad", "I7-4480MQ", "NVIDIA", 700, 15.6, 8, 1000, 240);
        Laptop l2 = new Laptop("koasdasdp", "IdeaPad", "I7-4480MQ", "NVIDIA", 700, 15.6, 8, 1000, 240);
        Laptop l3 = new Laptop("koasdasdp", "IdeaPad", "I7-4480MQ", "NVIDIA", 700, 15.6, 8, 1000, 240);

        dao1.dodajLaptopUFile(l);
        dao1.dodajLaptopUFile(l1);
        dao1.dodajLaptopUFile(l2);
        dao1.dodajLaptopUFile(l3);
//        dao.dodajLaptopUFile(l);
//        dao.dodajLaptopUFile(l1);
//        bin.dodajLaptopUFile(l1);


    }
}
