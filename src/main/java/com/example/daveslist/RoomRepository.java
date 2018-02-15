package com.example.daveslist;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long>{
    Iterable<Room> findAllByPrivated(boolean checkPrivated);
}
