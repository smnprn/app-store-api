package com.smnprn.appstoreapi.controller;

import com.smnprn.appstoreapi.model.App;
import com.smnprn.appstoreapi.service.AppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v0.1/apps")
public class AppController {
    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @CrossOrigin // TODO: Config CORS
    @GetMapping
    public ResponseEntity<List<App>> app(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "appid", required = false) String app_id,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "url", required = false) String url,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "rating", required = false) String contentRating,
            @RequestParam(value = "size", required = false) Long size,
            @RequestParam(value = "ios", required = false) String ios_version,
            @RequestParam(value = "price", required = false) Float price,
            @RequestParam(value = "currency", required = false) String currency,
            @RequestParam(value = "free", required = false) Byte free,
            @RequestParam(value = "developer", required = false) Long developer_id,
            @RequestParam(value = "user_rating", required = false) Double user_rating, // TODO: Check param
            @RequestParam(value = "reviews", required = false) Integer reviews
    ) {
        App app = new App(
                id,
                app_id,
                name,
                url,
                genre,
                contentRating,
                size,
                ios_version,
                price,
                currency,
                free,
                developer_id,
                user_rating,
                reviews
        );

        List<App> apps = appService.getApps(app);

        if(!apps.isEmpty()) {
            return ResponseEntity.ok(apps);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
