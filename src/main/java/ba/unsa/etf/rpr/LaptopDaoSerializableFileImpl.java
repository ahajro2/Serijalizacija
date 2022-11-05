package ba.unsa.etf.rpr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoSerializableFileImpl implements LaptopDao {

    private File file;
    private FileOutputStream f;
    public LaptopDaoSerializableFileImpl() throws IOException {
        this.file = new File("myObjects.txt");

    }


    @Override
    public void dodajLaptopUListu(Laptop laptop) {

    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        FileOutputStream f = new FileOutputStream(this.file);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(laptop);
        o.close();
        f.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {

    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() throws IOException {
        ArrayList<Laptop> lista = new ArrayList<>();
        FileInputStream fi = new FileInputStream(this.file);
        ObjectInputStream is = new ObjectInputStream(fi);
        while(true) {
            Laptop l;
            try {
                l = (Laptop) is.readObject();
            } catch (IOException | ClassNotFoundException e) {
                break;
            }
            lista.add(l);
        }
        fi.close();
        is.close();

        return lista;
    }
}
