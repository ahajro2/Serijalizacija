package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoXmlFile implements LaptopDao{

    private File file;
    private ArrayList<Laptop> laptopi = new ArrayList<>();

    public LaptopDaoXmlFile() {
        this.file = new File("datotekaZaXml.xml");
    }

    public LaptopDaoXmlFile(File file, ArrayList<Laptop> laptopi) {
        this.file = file;
        this.laptopi = laptopi;
    }


    @Override
    public void dodajLaptopUListu(Laptop laptop) {
        this.laptopi.add(laptop);
    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException{
        this.laptopi.add(laptop);
        XmlMapper mapper = new XmlMapper();
        String xml = mapper.writeValueAsString(laptopi);
        FileOutputStream fo = new FileOutputStream(this.file);
        fo.write(xml.getBytes());
        fo.close();
    }

    @Override
    public Laptop getLaptop(String procesor) {
        return null;
    }

    @Override
    public void napuniListu(ArrayList<Laptop> laptopi) {

    }

    @Override
    public List<Laptop> vratiPodatkeIzDatoteke() {
        ArrayList<Laptop> ls = new ArrayList<>();
        try {
            ls = (new XmlMapper()).readValue(file, new TypeReference<ArrayList<Laptop>>() {
            });
        } catch (Exception e) {
            System.out.println("Nema nista u datoteci");
            e.printStackTrace();
        }
        return ls;
    }
}
