package com.data.DataReceiver.repository;

import com.data.DataReceiver.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDataRepository extends JpaRepository<Data, Long> {
}
