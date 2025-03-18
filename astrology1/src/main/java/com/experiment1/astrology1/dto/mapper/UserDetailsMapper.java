package com.experiment1.astrology1.dto.mapper;


import com.experiment1.astrology1.dto.RequestObject;
import com.experiment1.astrology1.dto.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserDetailsMapper {
    UserDetailsMapper INSTANCE = Mappers.getMapper(UserDetailsMapper.class);

    @Mapping(target = "day", expression = "java(getDayFromDate(userDetails.getDateOfBirth()))")
    @Mapping(target = "month", expression = "java(getMonthFromDate(userDetails.getDateOfBirth()))")
    @Mapping(target = "year", expression = "java(getYearFromDate(userDetails.getDateOfBirth()))")
    @Mapping(target = "hour", expression = "java(getHourFromTime(userDetails.getTimeOfBirth()))")
    @Mapping(target = "min", expression = "java(getMinuteFromTime(userDetails.getTimeOfBirth()))")
    @Mapping(source = "lat", target = "lat")
    @Mapping(source = "lon", target = "lon")
    RequestObject userDetailsToRequestObject(UserDetails userDetails, double lat, double lon);

    default int getDayFromDate(String dateOfBirth) {
        return Integer.parseInt(dateOfBirth.split("-")[2]);
    }

    default int getMonthFromDate(String dateOfBirth) {
        return Integer.parseInt(dateOfBirth.split("-")[1]);
    }

    default int getYearFromDate(String dateOfBirth) {
        return Integer.parseInt(dateOfBirth.split("-")[0]);
    }

    default int getHourFromTime(String timeOfBirth) {
        return Integer.parseInt(timeOfBirth.split(":")[0]);
    }

    default int getMinuteFromTime(String timeOfBirth) {
        return Integer.parseInt(timeOfBirth.split(":")[1]);
    }
}
