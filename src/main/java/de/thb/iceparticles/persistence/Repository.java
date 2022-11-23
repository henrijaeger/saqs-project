package de.thb.iceparticles.persistence;

import de.thb.iceparticles.persistence.domain.Station;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;


public class Repository implements IRepository {

    List stations = new ArrayList();

    public Repository() throws FileNotFoundException {

        File f = new File("/Users/mxdeu/Desktop/stations.csv ");
        if(f.exists() && !f.isDirectory()) {    //tests if given File exists
            Scanner sc = new Scanner(f);
            sc.useDelimiter(",");        //sets the delimiter pattern
            while (sc.hasNext())                //returns a boolean value
            {
                stations.add(sc.next());        //find and returns the next complete token from this scanner
            } sc.close();                       //closes the scanner

        } else throw new FileNotFoundException("NEIN");



    }


    @Override
    public List<Station> findAll() {
        return stations;
    }

    @Override
    public Station save(Station station) {
        return null;
    }
}
