package com.duing.service;

import com.duing.domain.Guest;

import java.util.List;

public interface GuestService {
    List<Guest> GuestList();

    void add(Guest guest);

    Guest get(String name);

    void update(Guest guest);

    void delete(String name);
}
