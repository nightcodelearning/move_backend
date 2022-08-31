package com.leinaro.move.move.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "move")
@Getter
@NoArgsConstructor
public class Move {
    @Id
    @SequenceGenerator(
            name = "move_sequence",
            sequenceName = "move_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "move_sequence" ,strategy = GenerationType.SEQUENCE)
    private String moveId;
    private LocalDate moveDate;
    private int boxCounter;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @OneToMany(mappedBy = "move")
//    List<Room> rooms;


    public Move(LocalDate moveDate, int boxCounter, User user) {
        this.moveDate = moveDate;
        this.boxCounter = boxCounter;
        this.user = user;
    }


}
