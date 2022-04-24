package com.example.ships;

public class ShipModal {
    private String ship_name;
    private String ship_id;
    private String image;
    private String weight_kg;
    private String ship_model;
    private String ship_type;


    public ShipModal(String ship_name, String ship_id, String image, String weight_kg, String ship_model, String ship_type) {
        this.ship_name = ship_name;
        this.ship_id = ship_id;
        this.image = image;
        this.weight_kg = weight_kg;
        this.ship_model = ship_model;
        this.ship_type = ship_type;
    }

    public String getShip_name() {
        return ship_name;
    }

    public String getShip_id() {
        return ship_id;
    }

    public String getImage() {
        return image;
    }

    public String getWeight_kg() {
        return weight_kg;
    }

    public String getShip_model() {
        return ship_model;
    }

    public String getShip_type() {
        return ship_type;
    }
}
