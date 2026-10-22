package jp.co.medITrail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import jp.co.medITrail.repository.HospitalRepository;

@Controller
public class HospitalController {

    @Autowired
    private HospitalRepository repository;

}