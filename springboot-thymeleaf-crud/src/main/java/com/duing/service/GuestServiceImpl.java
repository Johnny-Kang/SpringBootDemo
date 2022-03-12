package com.duing.service;

import com.duing.dao.GuestDao;
import com.duing.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GuestServiceImpl implements GuestService{
    @Autowired
    private GuestDao guestDao;

    @Override
    public List<Guest> GuestList() {
        return guestDao.queryAllGuest();
    }

    @Override
    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public Guest get(String name) {
        return guestDao.get(name);
    }

    @Override
    public void update(Guest guest) {
        guestDao.update(guest);
    }

    @Override
    public void delete(String name) {
        guestDao.delete(name);
    }
}
