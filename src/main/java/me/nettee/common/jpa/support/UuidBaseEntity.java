package me.nettee.common.jpa.support;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class UuidBaseEntity implements Serializable {
    // NOTE MySQL: binary(16)
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    public UUID id() {
        return id;
    }
}
