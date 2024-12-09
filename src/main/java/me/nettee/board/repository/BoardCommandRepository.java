package me.nettee.board.repository;

import me.nettee.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommandRepository extends JpaRepository<Board, Long> {

}
