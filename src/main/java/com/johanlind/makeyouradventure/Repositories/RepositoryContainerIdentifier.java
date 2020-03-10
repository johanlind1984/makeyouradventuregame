package com.johanlind.makeyouradventure.Repositories;

import com.johanlind.makeyouradventure.Entity.Alternatives;
import com.johanlind.makeyouradventure.Entity.ContainerIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryContainerIdentifier extends JpaRepository<ContainerIdentifier, Integer> {
}
