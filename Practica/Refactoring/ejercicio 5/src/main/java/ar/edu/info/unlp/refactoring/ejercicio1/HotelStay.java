package ar.edu.info.unlp.refactoring.ejercicio1;

public class HotelStay extends Product {
    private double quote;
    private Hotel hotel;

    public HotelStay(double quote, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
        this.quote = quote;
        this.hotel = hotel;
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.getTimePeriod().duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }

    public double getCost() {
        return this.quote;
    }    
}
