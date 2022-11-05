package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LaptopDaoJsonFile implements LaptopDao {

    private File file;
    private ArrayList<Laptop> laptopi = new ArrayList<>();

    public LaptopDaoJsonFile() {
        file = new File("datotekaZaJackson.json");

    }

    @Override
    public void dodajLaptopUListu(Laptop laptop) {

    }

    @Override
    public void dodajLaptopUFile(Laptop laptop) throws IOException {
        laptopi.add(laptop);
        ObjectMapper mapper = new ObjectMapper();
        String jsonFormat = mapper.writeValueAsString(laptopi);
        FileOutputStream fo = new FileOutputStream(this.file);
        fo.write(jsonFormat.getBytes());
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
        ArrayList<Laptop> povratni = new ArrayList<>();
        try {
            povratni = (new ObjectMapper()).readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return povratni;
    }
}
