import java.util.*;

class Flight {
    public void bookFlight(String from, String to) {
        System.out.println("Booking flight from " + from + " to " + to);
    }
}

class Hotel {
    public void bookHotel(String hotelName, int nights) {
        System.out.println("Booking " + nights + " nights at " + hotelName);
    }
}

class TravelFacade {
    private Flight flight;
    private Hotel hotel;
    public TravelFacade() {
        flight = new Flight();
        hotel = new Hotel();

    }
    public void bookCompleteTravel(String from, String to, String hotelName, int nights) {
        System.out.println("Starting travel booking process...");
        flight.bookFlight(from, to);
        hotel.bookHotel(hotelName, nights);
        System.out.println("Travel booking completed!");
        
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();
        travelFacade.bookCompleteTravel("New York", "Paris", "Hilton", 5);
    }
}
