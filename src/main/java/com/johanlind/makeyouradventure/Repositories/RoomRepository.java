package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
