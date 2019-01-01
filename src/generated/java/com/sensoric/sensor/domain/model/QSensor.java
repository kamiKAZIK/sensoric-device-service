package com.sensoric.sensor.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSensor is a Querydsl query type for Sensor
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSensor extends EntityPathBase<Sensor> {

    private static final long serialVersionUID = 1972711650L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSensor sensor = new QSensor("sensor");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    public final QSensorType sensorType;

    public QSensor(String variable) {
        this(Sensor.class, forVariable(variable), INITS);
    }

    public QSensor(Path<? extends Sensor> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSensor(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSensor(PathMetadata metadata, PathInits inits) {
        this(Sensor.class, metadata, inits);
    }

    public QSensor(Class<? extends Sensor> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sensorType = inits.isInitialized("sensorType") ? new QSensorType(forProperty("sensorType")) : null;
    }

}

