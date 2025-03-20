package com.experiment1.astrology1.dto.response;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Data consists only @Getter, @Setter, @ToString, @EqualsAndHashCode
public class Astro_Details {
    @SerializedName("ascendant")
    private String ascendant;

    @SerializedName("ascendant_lord")
    private String ascendantLord;

    @SerializedName("Varna")
    private String varna;

    @SerializedName("Vashya")
    private String vashya;

    @SerializedName("Yoni")
    private String yoni;

    @SerializedName("Gan")
    private String gan;

    @SerializedName("Nadi")
    private String nadi;

    @SerializedName("SignLord")
    private String signLord;

    @SerializedName("sign")
    private String sign;

    @SerializedName("Naksahtra")
    private String nakshatra;

    @SerializedName("NaksahtraLord")
    private String nakshatraLord;

    @SerializedName("Charan")
    private int charan;

    @SerializedName("Yog")
    private String yog;

    @SerializedName("Karan")
    private String karan;

    @SerializedName("Tithi")
    private String tithi;

    @SerializedName("yunja")
    private String yunja;

    @SerializedName("tatva")
    private String tatva;

    @SerializedName("name_alphabet")
    private String nameAlphabet;

    @SerializedName("paya")
    private String paya;

}
