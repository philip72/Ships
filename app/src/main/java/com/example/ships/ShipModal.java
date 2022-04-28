package com.example.ships;

public class ShipModal {
    private String ship_id;
    private String ship_name;
    private String image;
    private String home_port;
    private String ship_type;

    public ShipModal(String ship_id, String ship_name, String image, String home_port, String ship_type) {
        this.ship_id = ship_id;
        this.ship_name = ship_name;
        this.image = image;
        this.home_port = home_port;
        this.ship_type = ship_type;
    }

    public String getShip_id() {
        return ship_id;
    }

    public String getShip_name() {
        return ship_name;
    }

    public String getImage() {
        return shp_type;
    }

    public String getHome_port() {
        return home_port;
    }

    public String getShip_type() {
        return image;
    }
}
