package com.smnprn.appstorevisualizer.model;

public record App(
        int id,
        String app_id,
        String name,
        String url,
        String genre,
        String contentRating,
        long size,
        float ios_version,
        float price,
        String currency,
        byte free,
        long developerId,
        double user_rating,
        int reviews
) {
}
