package com.gllfl.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gllfl.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Serializable> {

}
