package com.acme.sbwmtce.album;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface AlbumClient {

    @GetExchange("/albums")
    List<Album> findAll();

    @GetExchange("/albums/{id}")
    Album find(@PathVariable Long id);

}
