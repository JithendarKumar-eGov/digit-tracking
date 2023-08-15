package org.digit.tracking.data.rowmapper;

import org.digit.tracking.util.DbUtil;
import org.openapitools.model.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripProgressMapper implements RowMapper<TripProgress> {
    DbUtil dbUtil = new DbUtil();
    public TripProgress mapRow(ResultSet rs, int rowNum) throws SQLException {
        TripProgress tripProgress = new TripProgress();
        tripProgress.setId(rs.getString("id"));
        tripProgress.setTripId(rs.getString("tripId"));
        tripProgress.setProgressReportedTime(rs.getString("progressReportedTime"));

        //Start - Since the data in table is flattened by TripProgress entity supports only array of location, do following
        List<Location> locationList = dbUtil.convertSpatialToLocation(rs.getString("positionPoint"));
        List<TripProgressProgressDataInner> tripProgressProgressDataInnerList = new ArrayList<>();
        TripProgressProgressDataInner tripProgressProgressDataInner = new TripProgressProgressDataInner();
        //Take just the first element since a POINT spatial will have only one LatLong
        tripProgressProgressDataInner.setLocation(locationList.get(0));
        tripProgressProgressDataInner.setProgressTime(rs.getString("progressTime"));
        //Finally set the trip progress data into main entity
        tripProgressProgressDataInnerList.add(tripProgressProgressDataInner);
        tripProgress.setProgressData(tripProgressProgressDataInnerList);
        //End
        
        tripProgress.setMatchedPoiId(rs.getString("matchedPoiId"));
        tripProgress.setUserId(rs.getString("userId"));
        return tripProgress;
    }
}
