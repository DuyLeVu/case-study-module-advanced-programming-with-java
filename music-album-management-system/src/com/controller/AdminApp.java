package com.controller;

import com.model.Song;
import com.service.Impl.ClientService;
import com.service.Impl.SongService;

public class AdminApp {
    private ClientService clientService;
    private SongService songService;

    public AdminApp() {
        clientService = ClientService.getInstance();
        songService = SongService.getInstance();
    }

    public void createSong(Song song) {
        songService.create(song);
    }

    public void deleteTaxi(int id) {
        taxiService.delete(id);
    }

    public void update(int id, Taxi taxi) {
        taxiService.update(id, taxi);
    }

    public Taxi findById(int id) {
        return taxiService.findById(id);
    }

    public Taxi findByLicense(String taxiLicense) {
        return taxiService.findByLicensePlate(taxiLicense);
    }

    public List<Taxi> findAllTaxi() {
        return taxiService.findAll();
    }

    public void displaySong() {
        SongService.display();
    }

    public int countTaxiInOrder(Taxi taxi) {
        int turn = 0;
        for (Order order : findAllOrder()) {
            if (order.getTaxi().equals(taxi)) turn += 1;
        }
        return turn;
    }

    public void sortTaxi() {
        Collections.sort(findAllTaxi(), new Comparator<Taxi>() {
            @Override
            public int compare(Taxi o1, Taxi o2) {
                return countTaxiInOrder(o2) - countTaxiInOrder(o1);
            }
        });
        displayTaxi();
    }
}
}
