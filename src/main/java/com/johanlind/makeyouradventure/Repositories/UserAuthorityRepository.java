package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Authority;
import com.johanlind.makeyouradventure.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthorityRepository extends JpaRepository<Authority, Long> {

}
