package com.sensoric.sensor.domain.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSensorType is a Querydsl query type for SensorType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSensorType extends EntityPathBase<SensorType> {

    private static final long serialVersionUID = 1410724668L;

    public static final QSensorType sensorType = new QSensorType("sensorType");

    public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

    public final StringPath name = createString("name");

    public QSensorType(String variable) {
        super(SensorType.class, forVariable(variable));
    }

    public QSensorType(Path<? extends SensorType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSensorType(PathMetadata metadata) {
        super(SensorType.class, metadata);
    }

}

