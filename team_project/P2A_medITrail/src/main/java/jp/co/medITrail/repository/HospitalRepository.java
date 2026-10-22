package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.medITrail.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

}