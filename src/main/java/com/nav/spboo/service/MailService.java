package com.nav.spboo.service;

import com.nav.spboo.model.Mail;
import com.nav.spboo.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService {

    private final MailRepository mailRepository;

    @Autowired
    public MailService(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    public Mail findById(Long id) {
        return mailRepository.getOne(id);
    }

    public List<Mail> findAll() {
        return mailRepository.findAll();
    }

    public Mail saveMail(Mail mail) {
        return mailRepository.save(mail);
    }

    public void deleteById(Long id) {
        mailRepository.deleteById(id);
    }
}
