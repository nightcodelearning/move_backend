package com.leinaro.move.move.entity;

import javax.persistence.*;
/*
@Entity
@Table(name = "room")

 */
public class Room {
/*
    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(generator = "room_sequence",strategy = GenerationType.SEQUENCE)
    private String roomId;
    private String name;
    private int boxCount;
    @ManyToOne
    @JoinColumn(name = "move_id",nullable = false)
    private Move move;

 */
}
