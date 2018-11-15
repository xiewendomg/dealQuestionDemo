package com.xiewendomg.admin.bigdata.hive;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.serde2.AbstractSerDe;
import org.apache.hadoop.hive.serde2.SerDeException;
import org.apache.hadoop.hive.serde2.SerDeStats;
import org.apache.hadoop.hive.serde2.objectinspector.ObjectInspector;
import org.apache.hadoop.io.Writable;

import javax.annotation.Nullable;
import java.util.Properties;

public class XMLSerDe extends AbstractSerDe {

    @Override
    public void initialize(@Nullable Configuration configuration, Properties properties) throws SerDeException {

    }

    @Override
    public Class<? extends Writable> getSerializedClass() {
        return null;
    }

    @Override
    public Writable serialize(Object o, ObjectInspector objectInspector) throws SerDeException {
        return null;
    }

    @Override
    public SerDeStats getSerDeStats() {
        return null;
    }

    @Override
    public Object deserialize(Writable writable) throws SerDeException {
        return null;
    }

    @Override
    public ObjectInspector getObjectInspector() throws SerDeException {
        return null;
    }
}
