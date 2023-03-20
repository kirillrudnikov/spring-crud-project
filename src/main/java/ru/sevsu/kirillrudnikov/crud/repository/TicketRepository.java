package ru.sevsu.kirillrudnikov.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevsu.kirillrudnikov.crud.entity.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}