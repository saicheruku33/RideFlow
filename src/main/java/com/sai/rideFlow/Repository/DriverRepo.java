package com.sai.rideFlow.Repository;

import com.sai.rideFlow.Model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Integer> {
    @Query(value = "select * from driver where cab_id=:cabID",nativeQuery = true)
    Driver getDriverByCabId(@Param("cabID") int cabID);
}
