package client.model;

import autoBus.Tour;

import java.util.List;

/**
 * Created by lenovo on 4/21/2017.
 */
public class Model {
    private List<Tour> tours;

    public Model() {
        this.tours = new ProxyArrayList<>();
    }

    public List<Tour> getTours() {
        return tours;
    }

}
