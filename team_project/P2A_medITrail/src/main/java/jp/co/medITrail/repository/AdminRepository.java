package jp.co.medITrail.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.medITrail.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	Admin findByHosIdAndAdminIdAndPassword(Integer hosId,Integer adminId,String password);

}