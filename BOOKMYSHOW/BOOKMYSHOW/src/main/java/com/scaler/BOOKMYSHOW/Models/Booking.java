package com.scaler.BOOKMYSHOW.Models;

import com.scaler.BOOKMYSHOW.Models.Types.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends  BaseModel{

    @ManyToOne
    private Show show;
    @OneToOne
    private User user;
    @OneToMany
    private List<ShowSeat> seats;
    @Enumerated(value = EnumType.STRING)
    private BookingStatus status;
    @OneToOne
    private Payment payment;
    private double amount;


}
