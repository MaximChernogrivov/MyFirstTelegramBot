package ru.chernogrivov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.chernogrivov.entity.RawData;

public interface RawDataDAO extends JpaRepository<RawData, Long> {

}
