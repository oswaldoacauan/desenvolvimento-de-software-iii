package com.egov.impl.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 * Created by marcus on 17/11/2016.
 */
@MappedTypes(LocalDateTime.class)
public class LocalDateTimeHandler extends BaseTypeHandler<LocalDateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType) throws SQLException {
        ps.setTimestamp(
                i, Timestamp.valueOf(parameter),
                GregorianCalendar.from(
                        ZonedDateTime.of(
                                parameter,
                                ZoneId.systemDefault()
                        )
                )
        );
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnName);
        if (ts != null) {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        Timestamp ts = rs.getTimestamp(columnIndex);
        if (ts != null) {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Timestamp ts = cs.getTimestamp(columnIndex);
        if (ts != null) {
            return LocalDateTime.ofInstant(ts.toInstant(), ZoneId.systemDefault());
        }
        return null;
    }
}
