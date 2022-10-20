package com.dropsapppro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dropsapppro.storageobjects.BestRouteReplicaDetails;

@Repository
public interface BestRouteReplicaDetailsRepository extends JpaRepository<BestRouteReplicaDetails,Long> {

}
