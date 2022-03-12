package com.duing.dao;

import com.duing.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GuestDao {
    static List<Guest> guestList = new ArrayList<>();
    static {
        guestList.add(new Guest("kpq","boos"));
        guestList.add(new Guest("hwy","guest"));
        guestList.add(new Guest("hsg","guest"));
    }

    public List<Guest> queryAllGuest(){
        return guestList;
    }

    public void add(Guest guest){
        guestList.add(guest);
    }

    public Guest get(String name) {
        for (Guest guest : guestList){
            if (name.equals(guest.getName())){
                return guest;
            }
        }
        return new Guest("","");
    }

    public void update(Guest newGuest) {
        Guest oldGuest = get(newGuest.getName());
        oldGuest.setRole(newGuest.getRole());
    }

    public void delete(String name){
        guestList.remove(get(name));
    }
}
